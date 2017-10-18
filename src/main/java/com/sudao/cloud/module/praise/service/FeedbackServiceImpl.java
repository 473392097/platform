package com.sudao.cloud.module.praise.service;

import com.sudao.cloud.module.base.config.enums.Status;
import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.service.BaseServiceImpl;
import com.sudao.cloud.module.base.utils.BeanUtils;
import com.sudao.cloud.module.praise.dao.dto.FeedbackDTO;
import com.sudao.cloud.module.praise.dao.dto.FeedbackDTOExample;
import com.sudao.cloud.module.praise.dao.mapper.FeedbackDTOMapper;
import com.sudao.cloud.module.praise.vo.req.FeedbackQuery;
import com.sudao.cloud.module.praise.vo.req.FeedbackReq;
import com.sudao.cloud.module.praise.vo.resp.FeedbackResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FeedbackServiceImpl extends BaseServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackDTOMapper feedbackDTOMapper;

	@Override
	public FeedbackResp getById(Long id) {
		FeedbackDTO feedbackDTO = this.feedbackDTOMapper.selectByPrimaryKey(id);
		if (feedbackDTO != null && Status.NORMAL.equals(feedbackDTO.getStatus())) {
			return BeanUtils.copyProperties(feedbackDTO, FeedbackResp.class);
		}

		return null;
	}

	@Override
	public boolean create(FeedbackReq obj) {
		logger.debug("Creating Feedback: {}", obj);
		Long time = new Date().getTime();

		FeedbackDTO feedbackDTO = BeanUtils.copyProperties(obj, FeedbackDTO.class);
		feedbackDTO.setStatus(Status.NORMAL);
		feedbackDTO.setCreatedById(obj.getOperator());
		feedbackDTO.setCreatedTime(time);
		feedbackDTO.setUpdatedById(obj.getOperator());
		feedbackDTO.setUpdatedTime(time);

		return this.feedbackDTOMapper.insertSelective(feedbackDTO) > 0;
	}

	@Override
	public boolean update(FeedbackReq obj) {
		logger.debug("Updating Feedback: {}", obj);

		FeedbackDTO feedbackDTO = BeanUtils.copyProperties(obj, FeedbackDTO.class);
		feedbackDTO.setUpdatedById(obj.getOperator());
		feedbackDTO.setUpdatedTime(new Date().getTime());
		return this.feedbackDTOMapper.updateByPrimaryKeySelective(feedbackDTO) > 0;
	}

	@Override
	public Page<FeedbackResp> find(FeedbackQuery query) {
		Page<FeedbackResp> page = new Page<FeedbackResp>(query);
        FeedbackDTOExample example = new FeedbackDTOExample();
        FeedbackDTOExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(Status.NORMAL);
        example.setOrderByClause("id DESC");

        long total = this.feedbackDTOMapper.countByExample(example);
        page.setTotal(total);
        if (total > query.getOffset()) {
            List<FeedbackDTO> list = this.feedbackDTOMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
            page.setItems(BeanUtils.copyListProperties(list, FeedbackResp.class));
        }
        return page;
	}
}
