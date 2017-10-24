package com.sudao.cloud.component.user.manager.controller;


import com.sudao.cloud.component.user.manager.service.RoleMenuService;
import com.sudao.cloud.component.user.manager.service.RoleMenuService.RoleMenu;
import com.sudao.cloud.component.user.manager.service.RoleMenuService.RoleMenuQuery;
import com.sudao.framework.controller.RestPrototypeController;
import com.sudao.cloud.component.user.manager.platform.base.controller.LocalBasicController;
import com.sudao.cloud.component.user.manager.platform.base.result.Page;
import com.sudao.cloud.component.user.manager.platform.base.result.Result;
import com.sudao.cloud.component.user.manager.platform.base.result.ResultCode;
import com.sudao.cloud.component.user.manager.platform.enums.Deleted;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestPrototypeController
@RequestMapping("/cloud/component/roleMenu")
public class RoleMenuController extends LocalBasicController {

    @Autowired
    private RoleMenuService roleMenuService;

    @PostMapping("")
    public Map<String, Object> create(@RequestBody final RoleMenu obj) {
        // create
        obj.setOperator(getSession().getUserId());
        Long id = roleMenuService.create(obj);

        return resultMap(ResultCode.OK, "RoleMenu_id", id);
    }

    @PutMapping("/{id}")
    public Map<String, Object> update(
            @PathVariable("id") final Long id,
            @RequestBody final RoleMenu obj) {
        obj.setRoleMenuId(id);
        obj.setOperator(getSession().getUserId());
        roleMenuService.update(obj);
        
        return resultMap(ResultCode.OK);
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable("id") final Long id) {
        RoleMenu obj = new RoleMenu();
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
    public RoleMenu get(@PathVariable("id") final Long id) {
        RoleMenu obj = roleMenuService.getById(id);
        
        return obj;
    }

    @GetMapping("")
    public Result<Page<RoleMenu>> find(
              @RequestParam(value = "offset", required = false) Integer offset,
              @RequestParam(value = "limit", required = false) Integer limit,
              @RequestParam(value = "page", required = false) Integer pageNum
            ) {
		RoleMenuQuery query = new RoleMenuQuery();
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
		
		Page<RoleMenu> page = roleMenuService.find(query);
        return new Result<Page<RoleMenu>>(ResultCode.OK, page);
    }
}
