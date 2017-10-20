package com.sudao.cloud.module.idea.controller;

import com.sudao.cloud.module.base.config.ResultCode;
import com.sudao.cloud.module.base.config.enums.Status;
import com.sudao.cloud.module.idea.vo.req.PlanQuery;
import com.sudao.cloud.module.idea.vo.req.PlanReq;
import com.sudao.cloud.module.idea.vo.resp.PlanResp;
import com.sudao.framework.controller.BaseRecord;
import com.sudao.framework.controller.RestPrototypeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sudao.cloud.module.idea.service.PlanService;
import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.controller.LocalBasicController;


@RestPrototypeController
@RequestMapping("/plan")
public class PlanController extends LocalBasicController {

    @Autowired
    private PlanService planService;
    
    @PostMapping("/create")
    public BaseRecord create(@RequestBody final PlanReq obj) {
        setOk(ResultCode.OK);

        // create
        obj.setOperatorId(getUserId());
        boolean created = planService.create(obj);
        if(!created){
            setFail(ResultCode.CREATE_FAIL);
        }
        return baseRecord;
    }

    @PostMapping("/update/{planId}")
    public BaseRecord update(@PathVariable(name = "planId") final Long planId, @RequestBody PlanReq obj) {
        setOk(ResultCode.OK);

        obj.setOperatorId(getUserId());
        obj.setPlanId(planId);
        boolean updated = planService.update(obj);
        if(!updated){
            setFail(ResultCode.UPDATE_FAIL);
        }
        return baseRecord;
    }

    @PostMapping("/delete/{planId}")
    public BaseRecord delete(@PathVariable(name = "planId") final Long planId) {
        PlanReq obj = new PlanReq();
        obj.setOperatorId(getUserId());
        obj.setStatus(Status.DELETED);
        return update(planId, obj);
    }

    @GetMapping("/{planId}")
    public PlanResp get(@PathVariable(name = "planId") final Long planId) {
        PlanResp obj = planService.getById(planId);
        return obj;
    }

    @GetMapping("")
    public BaseRecord find(PlanQuery planQuery) {
        Page<PlanResp> page = planService.find(planQuery);
        setOk(page);
        return baseRecord;
    }

}
