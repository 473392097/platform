package com.sudao.cloud.module.praise.controller;

import com.sudao.cloud.module.base.config.ResultCode;
import com.sudao.cloud.module.base.config.enums.Deleted;
import com.sudao.cloud.module.base.controller.LocalBasicController;
import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.exception.KaizaoException;
import com.sudao.cloud.module.praise.dao.dto.FeedbackDTO;
import com.sudao.cloud.module.praise.service.FeedbackService;
import com.sudao.cloud.module.praise.vo.req.FeedbackQuery;
import com.sudao.cloud.module.praise.vo.req.FeedbackReq;
import com.sudao.cloud.module.praise.vo.req.biz.SubmitFeedbackReq;
import com.sudao.cloud.module.praise.vo.resp.FeedbackResp;
import com.sudao.framework.controller.BaseRecord;
import com.sudao.framework.controller.RestPrototypeController;
import jodd.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestPrototypeController
@RequestMapping("/feedback")
public class FeedbackController extends LocalBasicController {

    @Autowired
    private FeedbackService feedbackService;
    
    @PostMapping("/create")
    public void create(@RequestBody final FeedbackReq obj) {
        boolean created = feedbackService.create(obj);
    }



    @PostMapping("/feedback")
    public void feedback(@RequestBody final SubmitFeedbackReq param) {
        Long userId = super.sessionTokenResolver.getSessionQuietly(super.request).getUserId();

        // create
        FeedbackReq target = new FeedbackReq();
        BeanUtils.copyProperties(param, target);
        feedbackService.create(target);
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

    @GetMapping("/find/phoneAndStatus")
    public Page<FeedbackResp> findPhoneAndStatus(FeedbackQuery feedbackQuery) throws KaizaoException {
        if(StringUtil.isEmpty(feedbackQuery.getFeedbackCellphone())) {
            throw new KaizaoException(ResultCode.NULL_PARAMETERS);
        }
        Page<FeedbackResp> page = feedbackService.findPhoneAndStatus(feedbackQuery);
        return page;
    }



    //添加意见反馈
    @PostMapping("/insert/adviceFeedback")
    public void adviceFeedback(@RequestBody final FeedbackDTO feedbackDTO){
        System.out.println("controller");
        feedbackService.insertSelective(feedbackDTO);
    }




}
