package com.sudao.cloud.module.idea.controller;

import com.sudao.cloud.module.base.config.ResultCode;
import com.sudao.cloud.module.base.config.enums.Status;
import com.sudao.cloud.module.idea.vo.req.UserIdeaStatisticsQuery;
import com.sudao.cloud.module.idea.vo.req.UserIdeaStatisticsReq;
import com.sudao.cloud.module.idea.vo.resp.UserIdeaStatisticsResp;
import com.sudao.framework.controller.BaseRecord;
import com.sudao.framework.controller.RestPrototypeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sudao.cloud.module.idea.service.UserIdeaStatisticsService;
import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.controller.LocalBasicController;


@RestPrototypeController
@RequestMapping("/ideaStatistics")
public class UserIdeaStatisticsController extends LocalBasicController {

    @Autowired
    private UserIdeaStatisticsService userIdeaStatisticsService;
    
    @PostMapping("/create")
    public BaseRecord create(@RequestBody final UserIdeaStatisticsReq obj) {
        setOk(ResultCode.OK);

        // create
        obj.setOperatorId(getUserId());
        boolean created = userIdeaStatisticsService.create(obj);
        if(!created){
            setFail(ResultCode.CREATE_FAIL);
        }
        return baseRecord;
    }

    @PostMapping("/update/{id}")
    public BaseRecord update(@PathVariable(name = "id") final Long id, @RequestBody UserIdeaStatisticsReq obj) {
        setOk(ResultCode.OK);

        obj.setOperatorId(getUserId());
        obj.setId(id);
        boolean updated = userIdeaStatisticsService.update(obj);
        if(!updated){
            setFail(ResultCode.UPDATE_FAIL);
        }
        return baseRecord;
    }

    @PostMapping("/delete/{id}")
    public BaseRecord delete(@PathVariable(name = "id") final Long id) {
        UserIdeaStatisticsReq obj = new UserIdeaStatisticsReq();
        obj.setOperatorId(getUserId());
        obj.setDeleted(Status.DELETED.code());
        return update(id, obj);
    }

    @GetMapping("/{id}")
    public UserIdeaStatisticsResp get(@PathVariable(name = "id") final Long id) {
        UserIdeaStatisticsResp obj = userIdeaStatisticsService.getById(id);
        return obj;
    }

    @GetMapping("")
    public BaseRecord find(UserIdeaStatisticsQuery userIdeaStatisticsQuery) {
        Page<UserIdeaStatisticsResp> page = userIdeaStatisticsService.find(userIdeaStatisticsQuery);
        setOk(page);
        return baseRecord;
    }

}
