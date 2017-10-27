package com.sudao.cloud.module.praise.controller;

import com.sudao.cloud.module.base.config.ResultCode;
import com.sudao.cloud.module.base.config.enums.Deleted;
import com.sudao.cloud.module.praise.vo.req.CollectPraiseQuery;
import com.sudao.cloud.module.praise.vo.req.CollectPraiseReq;
import com.sudao.cloud.module.praise.vo.resp.CollectPraiseResp;
import com.sudao.framework.controller.BaseRecord;
import com.sudao.framework.controller.RestPrototypeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sudao.cloud.module.praise.service.CollectPraiseService;
import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.controller.LocalBasicController;


@RestPrototypeController
@RequestMapping("/praise")
public class CollectPraiseController extends LocalBasicController {

    @Autowired
    private CollectPraiseService collectPraiseService;
    
    @PostMapping("/create")
    public BaseRecord create(@RequestBody final CollectPraiseReq obj) {
        setOk(ResultCode.OK);

        // create
        obj.setOperatorId(getUserId());
        boolean created = collectPraiseService.create(obj);
        if(!created){
            setFail(ResultCode.CREATE_FAIL);
        }
        return baseRecord;
    }

    @PostMapping("/update/{id}")
    public BaseRecord update(@PathVariable(name = "id") final Long id, @RequestBody CollectPraiseReq obj) {
        setOk(ResultCode.OK);

        obj.setOperatorId(getUserId());
        obj.setId(id);
        boolean updated = collectPraiseService.update(obj);
        if(!updated){
            setFail(ResultCode.UPDATE_FAIL);
        }
        return baseRecord;
    }


    @PostMapping("/delete/{id}")
    public BaseRecord delete(@PathVariable(name = "id") final Long id) {
        CollectPraiseReq obj = new CollectPraiseReq();
        obj.setOperatorId(getUserId());
        obj.setDeleted(Deleted.DELETED.code());
        return update(id, obj);
    }


    @GetMapping("/{id}")
    public CollectPraiseResp get(@PathVariable(name = "id") final Long id) {
        CollectPraiseResp obj = collectPraiseService.getById(id);
        return obj;
    }


    @GetMapping("")
    public BaseRecord find(CollectPraiseQuery collectPraiseQuery) {
        Page<CollectPraiseResp> page = collectPraiseService.find(collectPraiseQuery);
        setOk(page);
        return baseRecord;
    }

}
