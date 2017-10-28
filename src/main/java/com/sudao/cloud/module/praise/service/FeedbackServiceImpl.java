package com.sudao.cloud.module.praise.service;

import com.sudao.cloud.module.base.config.enums.Deleted;
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
		if (feedbackDTO != null && Deleted.NORMAL.code() == feedbackDTO.getDeleted()) {
			return BeanUtils.copyProperties(feedbackDTO, FeedbackResp.class);
		}
		return null;
	}

	@Override
	public boolean create(FeedbackReq obj) {
		logger.debug("Creating Feedback: {}", obj);
		Date date = new Date();
		FeedbackDTO feedbackDTO = BeanUtils.copyProperties(obj, FeedbackDTO.class);
        feedbackDTO.setDeleted(Deleted.NORMAL.code());
        feedbackDTO.setCreateTime(date);
        feedbackDTO.setCreateUserId(obj.getOperatorId());
        feedbackDTO.setCreateUserName(obj.getOperatorName());
        feedbackDTO.setUpdateTime(date);
        feedbackDTO.setUpdateUserId(obj.getOperatorId());
        feedbackDTO.setUpdateUserName(obj.getOperatorName());
		return this.feedbackDTOMapper.insertSelective(feedbackDTO) > 0;
	}


	@Override
	public boolean update(FeedbackReq obj) {
		logger.debug("Updating Feedback: {}", obj);

		FeedbackDTO feedbackDTO = BeanUtils.copyProperties(obj, FeedbackDTO.class);
        feedbackDTO.setUpdateTime(new Date());
        feedbackDTO.setUpdateUserId(obj.getOperatorId());
        feedbackDTO.setUpdateUserName(obj.getOperatorName());
		return this.feedbackDTOMapper.updateByPrimaryKeySelective(feedbackDTO) > 0;
	}

	@Override
	public Page<FeedbackResp> find(FeedbackQuery query) {
		Page<FeedbackResp> page = new Page<FeedbackResp>(query);
        FeedbackDTOExample example = new FeedbackDTOExample();
        FeedbackDTOExample.Criteria criteria = example.createCriteria();

		if(null != query.getFeedbackCellphone()){
			criteria.andFeedbackCellphoneLike("%"+query.getFeedbackCellphone()+"%");
		}if(null != query.getFeedbackUsername()){
			criteria.andFeedbackUsernameLike("%"+query.getFeedbackUsername()+"%");
		}if(null != query.getCreateTime()){
			criteria.andContentBetween(query.getCreateTime(),query.getCreateTime());
		}

		criteria.andDeletedEqualTo(Deleted.NORMAL.code());
        example.setOrderByClause("id DESC");
        long total = this.feedbackDTOMapper.countByExample(example);
        page.setTotal(total);
        if (total > query.getOffset()) {
        List<FeedbackDTO> list = this.feedbackDTOMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
            page.setItems(BeanUtils.copyListProperties(list, FeedbackResp.class));
        }
        return page;
	}

	@Override
	public Page<FeedbackResp> findPhoneAndStatus(FeedbackQuery query) {
		Page<FeedbackResp> page = new Page<FeedbackResp>(query);
		FeedbackDTOExample example = new FeedbackDTOExample();
		FeedbackDTOExample.Criteria criteria = example.createCriteria();
		criteria.andFeedbackCellphoneEqualTo(query.getFeedbackCellphone());
		criteria.andReadStatusEqualTo(query.getReadStatus());
		criteria.andDeletedEqualTo(Deleted.NORMAL.code());
		example.setOrderByClause("id DESC");

		long total = this.feedbackDTOMapper.countByExample(example);
		page.setTotal(total);
		if (total > query.getOffset()) {
			List<FeedbackDTO> list = this.feedbackDTOMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, FeedbackResp.class));
		}
		return page;
	}


    //意见反馈
	@Override
	public int insertSelective(FeedbackDTO feedbackDTO){
	    return feedbackDTOMapper.insertSelective(feedbackDTO);
	}



}
