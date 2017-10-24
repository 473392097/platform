package com.sudao.cloud.component.user.manager.controller;


import com.sudao.cloud.component.user.manager.service.UserRoleService;
import com.sudao.cloud.component.user.manager.service.UserRoleService.UserRole;
import com.sudao.cloud.component.user.manager.service.UserRoleService.UserRoleQuery;
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
@RequestMapping("/cloud/component/userRole")
public class UserRoleController extends LocalBasicController {

    @Autowired
    private UserRoleService userRoleService;

    @PostMapping("")
    public Map<String, Object> create(@RequestBody final UserRole obj) {
        // create
        obj.setOperator(getSession().getUserId());
        Long id = userRoleService.create(obj);

        return resultMap(ResultCode.OK, "UserRole_id", id);
    }

    @PutMapping("/{id}")
    public Map<String, Object> update(
            @PathVariable("id") final Long id,
            @RequestBody final UserRole obj) {
        obj.setUserRoleId(id);
        obj.setOperator(getSession().getUserId());
        userRoleService.update(obj);
        
        return resultMap(ResultCode.OK);
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable("id") final Long id) {
        UserRole obj = new UserRole();
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
    public UserRole get(@PathVariable("id") final Long id) {
        UserRole obj = userRoleService.getById(id);
        
        return obj;
    }

    @GetMapping("")
    public Result<Page<UserRole>> find(
              @RequestParam(value = "offset", required = false) Integer offset,
              @RequestParam(value = "limit", required = false) Integer limit,
              @RequestParam(value = "page", required = false) Integer pageNum
            ) {
		UserRoleQuery query = new UserRoleQuery();
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
		
		Page<UserRole> page = userRoleService.find(query);
        return new Result<Page<UserRole>>(ResultCode.OK, page);
    }
}
