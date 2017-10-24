package com.sudao.cloud.component.user.manager.service.impl;

import com.sudao.cloud.component.user.manager.dao.RoleMenuEntity;
import com.sudao.cloud.component.user.manager.dao.RoleMenuEntityExample;
import com.sudao.cloud.component.user.manager.dao.RoleMenuEntityMapper;
import com.sudao.cloud.component.user.manager.service.RoleMenuService;
import com.sudao.cloud.component.user.manager.platform.base.result.Page;
import com.sudao.cloud.component.user.manager.platform.base.service.BaseServiceImpl;
import com.sudao.cloud.component.user.manager.platform.common.utils.BeanUtils;
import com.sudao.cloud.component.user.manager.platform.enums.Deleted;
import com.sudao.cloud.component.user.manager.platform.enums.Status;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class RoleMenuServiceImpl extends BaseServiceImpl implements RoleMenuService {
	private static final String TRACKING_TYPE = "RoleMenu";

    @Autowired
    private RoleMenuEntityMapper roleMenuEntityMapper;

	@Override
	public RoleMenu getById(Long roleMenuId) {
		RoleMenuEntity entity = this.roleMenuEntityMapper.selectByPrimaryKey(roleMenuId);
		if (entity != null && Deleted.NORMAL.equals(entity.getDeleted())) {
			return BeanUtils.copyProperties(entity, RoleMenu.class);
		}
		
		return null;
	}

	@Override
	public Long create(RoleMenu obj) {
		logger.debug("Creating RoleMenu: {}", obj);

//		obj.setRoleMenuId(this.getSequenceService().nextLong());
		
		RoleMenuEntity entity = BeanUtils.copyProperties(obj, RoleMenuEntity.class);
		entity.setDeleted(Deleted.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.roleMenuEntityMapper.insertSelective(entity);

//		this.getTrackingService().save(TRACKING_TYPE, entity.getRoleMenuId(), "create", entity);
		
		logger.info("Created RoleMenu: {}", obj);

		return entity.getRoleMenuId();
	}

	@Override
	public void update(RoleMenu obj) {
		logger.debug("Updating RoleMenu: {}", obj);

		RoleMenuEntity entity = BeanUtils.copyProperties(obj, RoleMenuEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.roleMenuEntityMapper.updateByPrimaryKeySelective(entity);

//		this.getTrackingService().save(TRACKING_TYPE, entity.getRoleMenuId(), "update", entity);

		logger.info("Updated RoleMenu: {}", obj);
	}

	@Override
	public void deleteByObj(RoleMenu obj) {
		obj.setDeleted(Deleted.DELETED);

		updateByObj(obj);
	}

	@Override
	public void updateByObj(RoleMenu obj) {
		logger.debug("Updating RoleMenu: {}", obj);
		RoleMenuEntityExample example = new RoleMenuEntityExample();
		RoleMenuEntityExample.Criteria criteria = example.createCriteria();
		if(obj.getRoleId() != null){
			criteria.andRoleIdEqualTo(obj.getRoleId());
		}

		RoleMenuEntity entity = BeanUtils.copyProperties(obj, RoleMenuEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.roleMenuEntityMapper.updateByExampleSelective(entity,example);

//		this.getTrackingService().save(TRACKING_TYPE, entity.getRoleMenuId(), "update", entity);

		logger.info("Updated RoleMenu: {}", obj);
	}
	@Override
	public Long save(RoleMenu obj) {
		logger.debug("Saving RoleMenu: {}", obj);

		if (obj.getRoleMenuId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getRoleMenuId();
	}

	@Override
	public Page<RoleMenu> find(RoleMenuQuery query) {
		Page<RoleMenu> page = new Page<RoleMenu>(query);
		RoleMenuEntityExample example = new RoleMenuEntityExample();
		RoleMenuEntityExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.ACTIVATE);
		criteria.andDeletedEqualTo(Deleted.NORMAL);
		example.setOrderByClause("role_menu_id DESC");
		page.setTotal(this.roleMenuEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<RoleMenuEntity> list = this.roleMenuEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, RoleMenu.class));
		}
		
		return page;
	}

	@Override
	public List<RoleMenu> findByObj(RoleMenu obj) {
		RoleMenuEntityExample example = new RoleMenuEntityExample();
		RoleMenuEntityExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.ACTIVATE);
		criteria.andDeletedEqualTo(Deleted.NORMAL);
		if (obj.getRoleId() != null) {
			criteria.andRoleIdEqualTo(obj.getRoleId());
		}
		if (obj.getRoleIds() != null) {
			criteria.andRoleIdIn(obj.getRoleIds());
		}
		example.setOrderByClause("role_menu_id DESC");

		List<RoleMenuEntity> list = this.roleMenuEntityMapper.selectByExample(example);
		return BeanUtils.copyListProperties(list, RoleMenu.class);
	}

	@Override
	public List<RoleMenu> findByRoleIds(List<Long> roleIds) {
		if (CollectionUtils.isEmpty(roleIds)) {
			return  null;
		}
		RoleMenu roleMenu = new RoleMenu();
		roleMenu.setRoleIds(roleIds);
		return  findByObj(roleMenu);
	}

	@Override
	public List<RoleMenu> findByRoleId(Long roleId) {
		if (roleId == null) {
			return  null;
		}
		RoleMenu roleMenu = new RoleMenu();
		roleMenu.setRoleId(roleId);
		return  findByObj(roleMenu);
	}
}
