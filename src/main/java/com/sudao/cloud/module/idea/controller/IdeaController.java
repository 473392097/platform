package com.sudao.cloud.module.idea.controller;

import com.sudao.cloud.module.base.config.ResultCode;
import com.sudao.cloud.module.base.config.enums.Status;
import com.sudao.cloud.module.idea.vo.req.IdeaQuery;
import com.sudao.cloud.module.idea.vo.req.IdeaReq;
import com.sudao.cloud.module.idea.vo.resp.IdeaResp;
import com.sudao.framework.controller.BaseRecord;
import com.sudao.framework.controller.RestPrototypeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sudao.cloud.module.idea.service.IdeaService;
import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.controller.LocalBasicController;


@RestPrototypeController
@RequestMapping("/idea")
public class IdeaController extends LocalBasicController {

    @Autowired
    private IdeaService ideaService;
    
    @PostMapping("/create")
    public BaseRecord create(@RequestBody final IdeaReq obj) {
        setOk(ResultCode.OK);

        // create
        obj.setOperatorId(getUserId());
        boolean created = ideaService.create(obj);
        if(!created){
            setFail(ResultCode.CREATE_FAIL);
        }
        return baseRecord;
    }

    @PostMapping("/update/{ideaId}")
    public BaseRecord update(@PathVariable(name = "ideaId") final Long ideaId, @RequestBody IdeaReq obj) {
        setOk(ResultCode.OK);

        obj.setOperatorId(getUserId());
        obj.setIdeaId(ideaId);
        boolean updated = ideaService.update(obj);
        if(!updated){
            setFail(ResultCode.UPDATE_FAIL);
        }
        return baseRecord;
    }

    @PostMapping("/delete/{ideaId}")
    public BaseRecord delete(@PathVariable(name = "ideaId") final Long ideaId) {
        IdeaReq obj = new IdeaReq();
        obj.setOperatorId(getUserId());
        obj.setDeleted(Status.DELETED.code());
        return update(ideaId, obj);
    }

    @GetMapping("/{ideaId}")
    public IdeaResp get(@PathVariable(name = "ideaId") final Long ideaId) {
        IdeaResp obj = ideaService.getById(ideaId);
        return obj;
    }

    @GetMapping("")
    public BaseRecord find(IdeaQuery ideaQuery) {
        Page<IdeaResp> page = ideaService.find(ideaQuery);
        setOk(page);
        return baseRecord;
    }

}
