package com.sudao.cloud.module.idea.controller;

import com.sudao.cloud.module.base.config.ResultCode;
import com.sudao.cloud.module.base.config.enums.Deleted;
import com.sudao.cloud.module.base.controller.LocalBasicController;
import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.idea.service.UserService;
import com.sudao.cloud.module.idea.vo.req.UserQuery;
import com.sudao.cloud.module.idea.vo.req.UserReq;
import com.sudao.cloud.module.idea.vo.resp.UserResp;
import com.sudao.framework.controller.BaseRecord;
import com.sudao.framework.controller.RestPrototypeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestPrototypeController
@RequestMapping("cloud/component/user")
public class UserController extends LocalBasicController {

    @Autowired
    private UserService userService;
    
    @PostMapping("/create")
    public BaseRecord create(@RequestBody final UserReq obj) {
        setOk(ResultCode.OK);

        // create
        obj.setOperatorId(getUserId());
        boolean created = userService.create(obj);
        if(!created){
            setFail(ResultCode.CREATE_FAIL);
        }
        return baseRecord;
    }

    @PostMapping("/update/{id}")
    public BaseRecord update(@PathVariable(name = "id") final Long id, @RequestBody UserReq obj) {
        setOk(ResultCode.OK);

        obj.setOperatorId(getUserId());
        obj.setUserId(id);
        boolean updated = userService.update(obj);
        if(!updated){
            setFail(ResultCode.UPDATE_FAIL);
        }
        return baseRecord;
    }

    @PostMapping("/delete/{id}")
    public BaseRecord delete(@PathVariable(name = "id") final Long id) {
        UserReq obj = new UserReq();
        obj.setOperatorId(getUserId());
        obj.setDeleted(Deleted.DELETED.code());
        return update(id, obj);
    }

    @GetMapping("/{id}")
    public UserResp get(@PathVariable(name = "id") final Long id) {
        UserResp obj = userService.getById(id);
        return obj;
    }

    @GetMapping("")
    public BaseRecord find(UserQuery userQuery) {
        Page<UserResp> page = userService.find(userQuery);
        setOk(page);
        return baseRecord;
    }

}
