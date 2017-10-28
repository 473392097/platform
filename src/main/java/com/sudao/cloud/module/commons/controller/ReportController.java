package com.sudao.cloud.module.commons.controller;

import com.sudao.cloud.component.user.manager.platform.base.core.Session;
import com.sudao.cloud.module.base.config.ResultCode;
import com.sudao.cloud.module.base.config.enums.Deleted;
import com.sudao.cloud.module.base.exception.KaizaoException;
import com.sudao.cloud.module.commons.service.UserService;
import com.sudao.cloud.module.commons.vo.req.ReportQuery;
import com.sudao.cloud.module.commons.vo.req.ReportReq;
import com.sudao.cloud.module.commons.vo.resp.ReportResp;
import com.sudao.cloud.module.commons.vo.resp.UserResp;
import com.sudao.framework.controller.BaseRecord;
import com.sudao.framework.controller.RestPrototypeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sudao.cloud.module.commons.service.ReportService;
import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.controller.LocalBasicController;


@RestPrototypeController
@RequestMapping("/report")
public class ReportController extends LocalBasicController {

    @Autowired
    private ReportService reportService;
    @Autowired
    private UserService userService;
    
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



    @DeleteMapping("/delete/{reportId}")
    public BaseRecord delete(@PathVariable(name = "reportId") final Long reportId) {
        ReportReq obj = new ReportReq();
        obj.setOperatorId(getUserId());
        obj.setDeleted(Deleted.DELETED.code());
        return update(reportId, obj);
    }

    @GetMapping("/{reportId}")
    public ReportResp get(@PathVariable(name = "reportId") final Long reportId) {
        ReportResp obj = reportService.getById(reportId);
        return obj;
    }


    @GetMapping("")
    public BaseRecord find(ReportQuery reportQuery) throws KaizaoException {
//        Session sessionQuietly = this.sessionTokenResolver.getSessionQuietly(this.request);
//        Long userId = sessionQuietly.getUserId();
//        UserResp targetUser = this.userService.getById(userId);
//        if(targetUser == null) {
//            throw new KaizaoException(ResultCode.UNAUTHORIZED);
//        }
        Page<ReportResp> page = reportService.find(reportQuery);
        setOk(page);
        return baseRecord;
    }



}
