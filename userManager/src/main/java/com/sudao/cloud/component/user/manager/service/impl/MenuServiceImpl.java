package com.sudao.cloud.component.user.manager.service.impl;


import com.sudao.cloud.component.user.manager.dao.MenuEntity;
import com.sudao.cloud.component.user.manager.dao.MenuEntityExample;
import com.sudao.cloud.component.user.manager.dao.MenuEntityMapper;
import com.sudao.cloud.component.user.manager.dao.RoleMenuEntityMapper;
import com.sudao.cloud.component.user.manager.enums.MenuType;
import com.sudao.cloud.component.user.manager.service.MenuService;
import com.sudao.cloud.component.user.manager.service.RoleMenuService;
import com.sudao.cloud.component.user.manager.service.UserRoleService;
import com.sudao.cloud.component.user.manager.platform.base.result.Page;
import com.sudao.cloud.component.user.manager.platform.base.service.BaseServiceImpl;
import com.sudao.cloud.component.user.manager.platform.common.utils.BeanUtils;
import com.sudao.cloud.component.user.manager.platform.enums.Deleted;
import com.sudao.cloud.component.user.manager.platform.enums.Status;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class MenuServiceImpl extends BaseServiceImpl implements MenuService {
	private static final String TRACKING_TYPE = "Menu";

    @Autowired
    private MenuEntityMapper menuEntityMapper;

    @Autowired
	private UserRoleService userRoleService;

    @Autowired
	private RoleMenuEntityMapper roleMenuEntityMapper;

    @Autowired
	private RoleMenuService roleMenuService;


	@Override
	public Menu getById(Long menuId) {
		MenuEntity entity = this.menuEntityMapper.selectByPrimaryKey(menuId);
		if (entity != null && Deleted.NORMAL.equals(entity.getDeleted())) {
			return BeanUtils.copyProperties(entity, Menu.class);
		}
		
		return null;
	}

	@Override
	public Long create(Menu obj) {
		logger.debug("Creating Menu: {}", obj);

//		obj.setMenuId(this.getSequenceService().nextLong());
		
		MenuEntity entity = BeanUtils.copyProperties(obj, MenuEntity.class);
		entity.setDeleted(Deleted.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.menuEntityMapper.insertSelective(entity);

//		this.getTrackingService().save(TRACKING_TYPE, entity.getMenuId(), "create", entity);
		
		logger.info("Created Menu: {}", obj);

		return entity.getMenuId();
	}

	@Override
	public void update(Menu obj) {
		logger.debug("Updating Menu: {}", obj);

		MenuEntity entity = BeanUtils.copyProperties(obj, MenuEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.menuEntityMapper.updateByPrimaryKeySelective(entity);

//		this.getTrackingService().save(TRACKING_TYPE, entity.getMenuId(), "update", entity);

		logger.info("Updated Menu: {}", obj);
	}

	@Override
	public Long save(Menu obj) {
		logger.debug("Saving Menu: {}", obj);

		if (obj.getMenuId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getMenuId();
	}

	@Override
	public Page<Menu> find(MenuQuery query) {
		Page<Menu> page = new Page<Menu>(query);
		MenuEntityExample example = new MenuEntityExample();
		MenuEntityExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.ACTIVATE);
		criteria.andDeletedEqualTo(Deleted.NORMAL);

		if (query.getParentId() != null) {
			criteria.andParentIdEqualTo(query.getParentId());
		}
		example.setOrderByClause("menu_id DESC");
		page.setTotal(this.menuEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<MenuEntity> list = this.menuEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, Menu.class));
		}
		
		return page;
	}

	@Override
	public List<Menu> findByObj(Menu obj) {
		MenuEntityExample example = new MenuEntityExample();
		MenuEntityExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.ACTIVATE);
		criteria.andDeletedEqualTo(Deleted.NORMAL);
		if (obj.getParentId() != null) {
			criteria.andParentIdEqualTo(obj.getParentId());
		}
		if (StringUtils.isNotBlank(obj.getName())){
			criteria.andNameEqualTo(obj.getName());
		}
		if (CollectionUtils.isNotEmpty(obj.getMenuIds())) {
			criteria.andMenuIdIn(obj.getMenuIds());
		}
		example.setOrderByClause("menu_id DESC");
		List<MenuEntity> list = this.menuEntityMapper.selectByExample(example);
		return BeanUtils.copyListProperties(list, Menu.class);
	}

	@Override
	public List<Menu> findByParentId(Long parentId) {
		if (parentId == null) {
			return null;
		}
		Menu menu = new Menu();
		menu.setParentId(parentId);
		return findByObj(menu);
	}

	@Override
	public List<Menu> findRoleMenusByUserId(Long userId) {
		if (userId == null) {
			return  null;
		}
		//获取用户角色
		List<UserRoleService.UserRole> userRoles = userRoleService.findByUserId(userId);
		if (CollectionUtils.isEmpty(userRoles)) {
        	return null;
		}
		List<Long> roleIds = new ArrayList<Long>();
		for (UserRoleService.UserRole userRole: userRoles ) {
        	  roleIds.add(userRole.getRoleId());
		}

		//获取角色菜单
		List<RoleMenuService.RoleMenu> roleMenus = roleMenuService.findByRoleIds(roleIds);
		if (CollectionUtils.isEmpty(roleMenus)) {
			return  null;
		}
		List<Long> menuIds = new ArrayList<Long>();
		for (RoleMenuService.RoleMenu roleMenu:roleMenus) {
			  menuIds.add(roleMenu.getMenuId());
		}

		//获取菜单
		Menu menuQuery = new Menu();
		menuQuery.setMenuIds(menuIds);

		return findByObj(menuQuery);
	}

	@Override
	public Map<String, Object> findPermissionsByUserId(Long userId) {
		//转换成层级菜单
		return transformMenu(findRoleMenusByUserId(userId));
	}

	private Map<String,Object> transformMenu(List<Menu> menus) {
		Map<String,Object> map = new HashMap<String,Object>();

		List<Menu> firstMenus = new ArrayList<Menu>();
		List<Menu> pointMenus  = new ArrayList<Menu>();
		List<String> points  = new ArrayList<String>();
		for(Menu menu : menus){
			if (menu.getMenuType() == MenuType.MENU) {
				if(MenuType.MENU.code() == menu.getParentId()){
					firstMenus.add(menu);
				}
			}else {
				pointMenus.add(menu);
				points.add(menu.getCode());
			}
		}
		menus.removeAll(firstMenus);
		menus.removeAll(pointMenus);

		buildMenuTree(firstMenus, menus);
		map.put("menus",firstMenus);
		map.put("points",points);
		return map;
	}

	private  void buildMenuTree(List<Menu> firstMenus, List<Menu> menus){
		for(Menu menu : firstMenus){
			Iterator<Menu> it = menus.iterator();
			while(it.hasNext()){
				Menu m = it.next();
				if(m.getParentId().equals(menu.getMenuId())){
					if(menu.getChildren() == null) {
						menu.setChildren(new ArrayList<Menu>());
					}
					menu.getChildren().add(m);
					it.remove();
				}
			}
		}
		for(Menu menu : firstMenus){
			if(CollectionUtils.isNotEmpty(menu.getChildren())){
				buildMenuTree(menu.getChildren(), menus);
			}
		}
	}
}
