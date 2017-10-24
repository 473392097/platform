package com.sudao.cloud.component.user.manager.controller;

import com.sudao.cloud.component.user.manager.service.RoleMenuService;
import com.sudao.cloud.component.user.manager.service.RoleService;
import com.sudao.cloud.component.user.manager.service.RoleService.Role;
import com.sudao.cloud.component.user.manager.service.RoleService.RoleQuery;
import com.sudao.framework.controller.RestPrototypeController;
import com.sudao.cloud.component.user.manager.platform.base.controller.LocalBasicController;
import com.sudao.cloud.component.user.manager.platform.base.result.Page;
import com.sudao.cloud.component.user.manager.platform.base.result.Result;
import com.sudao.cloud.component.user.manager.platform.base.result.ResultCode;
import com.sudao.cloud.component.user.manager.platform.enums.Deleted;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestPrototypeController
@RequestMapping("/cloud/component/role")
public class RoleController extends LocalBasicController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleMenuService roleMenuService;

    @PostMapping("")
    public Map<String, Object> create(@RequestBody final Role obj) {
        // create
        Long userId = getSession().getUserId();

        obj.setOperator(userId);
        Long id = roleService.create(obj);

        if (CollectionUtils.isNotEmpty(obj.getMenuIds())){
            //
            for (Long menuId : obj.getMenuIds()) {
                 RoleMenuService.RoleMenu roleMenu = new RoleMenuService.RoleMenu();
                 roleMenu.setRoleId(id);
                 roleMenu.setMenuId(menuId);
                 roleMenu.setOperator(userId);
                 roleMenuService.create(roleMenu);
            }

        }

        return resultMap(ResultCode.OK, "Role_id", id);
    }

    @PutMapping("/{id}")
    public Map<String, Object> update(
            @PathVariable("id") final Long id,
            @RequestBody final Role obj) {

        Long userId = getSession().getUserId();

        obj.setRoleId(id);
        obj.setOperator(userId);
        roleService.update(obj);

        //删除已有的
        RoleMenuService.RoleMenu rm = new RoleMenuService.RoleMenu();
        rm.setRoleId(id);
        roleMenuService.deleteByObj(rm);

        if (CollectionUtils.isNotEmpty(obj.getMenuIds())) {
            //新增菜单
            for (Long menuId : obj.getMenuIds()) {
                 RoleMenuService.RoleMenu roleMenu = new RoleMenuService.RoleMenu();
                 roleMenu.setRoleId(id);
                 roleMenu.setMenuId(menuId);
                 roleMenu.setOperator(userId);
                 roleMenuService.create(roleMenu);
            }
        }

        return resultMap(ResultCode.OK);
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable("id") final Long id) {
        Role obj = new Role();
        obj.setDeleted(Deleted.DELETED);
        return update(id, obj);
    }

    @DeleteMapping("")
    public Map<String, Object> deleteMore(@RequestBody final List<Long> ids) {
    	if (!CollectionUtils.isEmpty(ids)) {
			for (Long id : ids) {
				 delete(id);
			}
    	}
        return resultMap(ResultCode.OK);
    }

    @GetMapping("/{id}")
    public Role get(@PathVariable("id") final Long id) {
        Role obj = roleService.getById(id);

        List<RoleMenuService.RoleMenu> roleMenus = roleMenuService.findByRoleId(id);

        if(CollectionUtils.isNotEmpty(roleMenus)){
            obj.setMenuIds(new ArrayList<Long>());
            for (RoleMenuService.RoleMenu roleMenu: roleMenus
                 ) {
                 obj.getMenuIds().add(roleMenu.getMenuId());
            }
        }

        return obj;
    }

    @GetMapping("")
    public Result<Page<Role>> find(
              @RequestParam(value = "offset", required = false) Integer offset,
              @RequestParam(value = "limit", required = false) Integer limit,
              @RequestParam(value = "page", required = false) Integer pageNum
            ) {
		RoleQuery query = new RoleQuery();
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
		
		Page<Role> page = roleService.find(query);
        return new Result<Page<Role>>(ResultCode.OK, page);
    }
}
