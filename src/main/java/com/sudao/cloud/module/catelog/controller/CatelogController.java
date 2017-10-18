package com.sudao.cloud.module.catelog.controller;

import com.sudao.cloud.module.base.config.ResultCode;
import com.sudao.cloud.module.base.config.enums.Status;
import com.sudao.cloud.module.catelog.vo.req.CatelogQuery;
import com.sudao.cloud.module.catelog.vo.req.CatelogReq;
import com.sudao.cloud.module.catelog.vo.resp.CatelogResp;
import com.sudao.framework.controller.BaseRecord;
import com.sudao.framework.controller.RestPrototypeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sudao.cloud.module.catelog.service.CatelogService;
import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.controller.LocalBasicController;

/**
 * 类目API
 * @author Spector
 */
@RestPrototypeController
@RequestMapping("/catelog")
public class CatelogController extends LocalBasicController {

    @Autowired
    private CatelogService catelogService;
    
    @PostMapping("/create")
    public BaseRecord create(@RequestBody final CatelogReq obj) {
        setOk(ResultCode.OK);

        // create
        obj.setOperator(getUserId());
        boolean created = catelogService.create(obj);
        if(!created){
            setFail(ResultCode.CREATE_FAIL);
        }
        return baseRecord;
    }

    @PostMapping("/update/{catelogId}")
    public BaseRecord update(@PathVariable(name = "catelogId") final Long catelogId, @RequestBody CatelogReq obj) {
        setOk(ResultCode.OK);

        obj.setOperator(getUserId());
        obj.setCatelogId(catelogId);
        boolean updated = catelogService.update(obj);
        if(!updated){
            setFail(ResultCode.UPDATE_FAIL);
        }
        return baseRecord;
    }

    @PostMapping("/delete/{catelogId}")
    public BaseRecord delete(@PathVariable(name = "catelogId") final Long catelogId) {
        CatelogReq obj = new CatelogReq();
        obj.setOperator(getUserId());
        obj.setStatus(Status.DELETED);
        return update(catelogId, obj);
    }

    @GetMapping("/{catelogId}")
    public CatelogResp get(@PathVariable(name = "catelogId") final Long catelogId) {
        CatelogResp obj = catelogService.getById(catelogId);
        return obj;
    }

    @GetMapping("")
    public BaseRecord find(CatelogQuery catelogQuery) {
        Page<CatelogResp> page = catelogService.find(catelogQuery);
        setOk(page);
        return baseRecord;
    }

}
