package com.sudao.cloud.module.praise.controller;

import com.sudao.cloud.module.base.config.ResultCode;
import com.sudao.cloud.module.base.config.enums.Deleted;
import com.sudao.cloud.module.base.controller.LocalBasicController;
import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.praise.service.FeedbackService;
import com.sudao.cloud.module.praise.vo.req.FeedbackQuery;
import com.sudao.cloud.module.praise.vo.req.FeedbackReq;
import com.sudao.cloud.module.praise.vo.resp.FeedbackResp;
import com.sudao.framework.controller.BaseRecord;
import com.sudao.framework.controller.RestPrototypeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestPrototypeController
@RequestMapping("/feeback")
public class FeedbackController extends LocalBasicController {

    @Autowired
    private FeedbackService feedbackService;
    
    @PostMapping("/create")
    public BaseRecord create(@RequestBody final FeedbackReq obj) {
        setOk(ResultCode.OK);

        // create
        obj.setOperatorId(getUserId());
        boolean created = feedbackService.create(obj);
        if(!created){
            setFail(ResultCode.CREATE_FAIL);
        }
        return baseRecord;
    }

    @PostMapping("/update/{id}")
    public BaseRecord update(@PathVariable(name = "id") final Long id, @RequestBody FeedbackReq obj) {
        setOk(ResultCode.OK);

        obj.setOperatorId(getUserId());
        obj.setId(id);
        boolean updated = feedbackService.update(obj);
        if(!updated){
            setFail(ResultCode.UPDATE_FAIL);
        }
        return baseRecord;
    }

    @PostMapping("/delete/{id}")
    public BaseRecord delete(@PathVariable(name = "id") final Long id) {
        FeedbackReq obj = new FeedbackReq();
        obj.setOperatorId(getUserId());
        obj.setDeleted(Deleted.DELETED.code());
        return update(id, obj);
    }

    @GetMapping("/{id}")
    public FeedbackResp get(@PathVariable(name = "id") final Long id) {
        FeedbackResp obj = feedbackService.getById(id);
        return obj;
    }

    @GetMapping("")
    public BaseRecord find(FeedbackQuery feedbackQuery) {
        Page<FeedbackResp> page = feedbackService.find(feedbackQuery);
        setOk(page);
        return baseRecord;
    }

}
