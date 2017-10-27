package com.sudao.cloud.module.praise.service;

import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.service.BaseService;
import com.sudao.cloud.module.praise.dao.dto.FeedbackDTO;
import com.sudao.cloud.module.praise.vo.req.FeedbackQuery;
import com.sudao.cloud.module.praise.vo.req.FeedbackReq;
import com.sudao.cloud.module.praise.vo.resp.FeedbackResp;
import org.apache.ibatis.annotations.Param;

public interface FeedbackService extends BaseService {

    public FeedbackResp getById(Long id);

    public boolean create(FeedbackReq obj);

    public boolean update(FeedbackReq obj);

    public Page<FeedbackResp> find(FeedbackQuery query);

    Page<FeedbackResp> findPhoneAndStatus(FeedbackQuery query);

    int insertSelective(FeedbackDTO feedbackDTO);


}
