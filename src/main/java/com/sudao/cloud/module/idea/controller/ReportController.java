package com.sudao.cloud.module.idea.controller;

import com.sudao.cloud.module.base.config.ResultCode;
import com.sudao.cloud.module.base.config.enums.Status;
import com.sudao.cloud.module.idea.vo.req.ReportQuery;
import com.sudao.cloud.module.idea.vo.req.ReportReq;
import com.sudao.cloud.module.idea.vo.resp.ReportResp;
import com.sudao.framework.controller.BaseRecord;
import com.sudao.framework.controller.RestPrototypeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sudao.cloud.module.idea.service.ReportService;
import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.controller.LocalBasicController;


@RestPrototypeController
@RequestMapping("/report")
public class ReportController extends LocalBasicController {

    @Autowired
    private ReportService reportService;
    
    @PostMapping("/create")
    public BaseRecord create(@RequestBody final ReportReq obj) {
        setOk(ResultCode.OK);

        // create
        obj.setOperatorId(getUserId());
        boolean created = reportService.create(obj);
        if(!created){
            setFail(ResultCode.CREATE_FAIL);
        }
        return baseRecord;
    }

    @PostMapping("/update/{reportId}")
    public BaseRecord update(@PathVariable(name = "reportId") final Long reportId, @RequestBody ReportReq obj) {
        setOk(ResultCode.OK);

        obj.setOperatorId(getUserId());
        obj.setReportId(reportId);
        boolean updated = reportService.update(obj);
        if(!updated){
            setFail(ResultCode.UPDATE_FAIL);
        }
        return baseRecord;
    }

    @PostMapping("/delete/{reportId}")
    public BaseRecord delete(@PathVariable(name = "reportId") final Long reportId) {
        ReportReq obj = new ReportReq();
        obj.setOperatorId(getUserId());
        obj.setStatus(Status.DELETED);
        return update(reportId, obj);
    }

    @GetMapping("/{reportId}")
    public ReportResp get(@PathVariable(name = "reportId") final Long reportId) {
        ReportResp obj = reportService.getById(reportId);
        return obj;
    }

    @GetMapping("")
    public BaseRecord find(ReportQuery reportQuery) {
        Page<ReportResp> page = reportService.find(reportQuery);
        setOk(page);
        return baseRecord;
    }

}
