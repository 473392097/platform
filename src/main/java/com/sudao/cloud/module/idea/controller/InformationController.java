package com.sudao.cloud.module.idea.controller;

import com.sudao.cloud.module.base.config.ResultCode;
import com.sudao.cloud.module.base.config.enums.Deleted;
import com.sudao.cloud.module.base.controller.LocalBasicController;
import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.idea.service.InformationService;
import com.sudao.cloud.module.idea.vo.req.InformationQuery;
import com.sudao.cloud.module.idea.vo.req.InformationReq;
import com.sudao.cloud.module.idea.vo.resp.InformationResp;
import com.sudao.framework.controller.BaseRecord;
import com.sudao.framework.controller.RestPrototypeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestPrototypeController
@RequestMapping("cloud/component/information")
public class InformationController extends LocalBasicController {

    @Autowired
    private InformationService informationService;
    
    @PostMapping("/create")
    public BaseRecord create(@RequestBody final InformationReq obj) {
        setOk(ResultCode.OK);

        // create
        obj.setOperatorId(getUserId());
        boolean created = informationService.create(obj);
        if(!created){
            setFail(ResultCode.CREATE_FAIL);
        }
        return baseRecord;
    }

    @PostMapping("/update/{id}")
    public BaseRecord update(@PathVariable(name = "id") final Long id, @RequestBody InformationReq obj) {
        setOk(ResultCode.OK);

        obj.setOperatorId(getUserId());
        obj.setInformationId(id);
        boolean updated = informationService.update(obj);
        if(!updated){
            setFail(ResultCode.UPDATE_FAIL);
        }
        return baseRecord;
    }

    @PostMapping("/delete/{id}")
    public BaseRecord delete(@PathVariable(name = "id") final Long id) {
        InformationReq obj = new InformationReq();
        obj.setOperatorId(getUserId());
        obj.setDeleted(Deleted.DELETED.code());
        return update(id, obj);
    }

    @GetMapping("/{id}")
    public InformationResp get(@PathVariable(name = "id") final Long id) {
        InformationResp obj = informationService.getById(id);
        return obj;
    }

    @GetMapping("")
    public BaseRecord find(InformationQuery informationQuery) {
        Page<InformationResp> page = informationService.find(informationQuery);
        setOk(page);
        return baseRecord;
    }

}
