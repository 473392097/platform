package com.sudao.cloud.module.idea.controller;

import com.sudao.cloud.module.base.config.ResultCode;
import com.sudao.cloud.module.base.config.enums.Status;
import com.sudao.cloud.module.idea.vo.req.PlanContextQuery;
import com.sudao.cloud.module.idea.vo.req.PlanContextReq;
import com.sudao.cloud.module.idea.vo.resp.PlanContextResp;
import com.sudao.framework.controller.BaseRecord;
import com.sudao.framework.controller.RestPrototypeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sudao.cloud.module.idea.service.PlanContextService;
import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.controller.LocalBasicController;


@RestPrototypeController
@RequestMapping("/planContext")
public class PlanContextController extends LocalBasicController {

    @Autowired
    private PlanContextService planContextService;
    
    @PostMapping("/create")
    public BaseRecord create(@RequestBody final PlanContextReq obj) {
        setOk(ResultCode.OK);

        // create
        obj.setOperatorId(getUserId());
        boolean created = planContextService.create(obj);
        if(!created){
            setFail(ResultCode.CREATE_FAIL);
        }
        return baseRecord;
    }

    @PostMapping("/update/{contextId}")
    public BaseRecord update(@PathVariable(name = "contextId") final Long contextId, @RequestBody PlanContextReq obj) {
        setOk(ResultCode.OK);

        obj.setOperatorId(getUserId());
        obj.setContextId(contextId);
        boolean updated = planContextService.update(obj);
        if(!updated){
            setFail(ResultCode.UPDATE_FAIL);
        }
        return baseRecord;
    }

    @PostMapping("/delete/{contextId}")
    public BaseRecord delete(@PathVariable(name = "contextId") final Long contextId) {
        PlanContextReq obj = new PlanContextReq();
        obj.setOperatorId(getUserId());
        obj.setStatus(Status.DELETED);
        return update(contextId, obj);
    }

    @GetMapping("/{contextId}")
    public PlanContextResp get(@PathVariable(name = "contextId") final Long contextId) {
        PlanContextResp obj = planContextService.getById(contextId);
        return obj;
    }

    @GetMapping("")
    public BaseRecord find(PlanContextQuery planContextQuery) {
        Page<PlanContextResp> page = planContextService.find(planContextQuery);
        setOk(page);
        return baseRecord;
    }

}
