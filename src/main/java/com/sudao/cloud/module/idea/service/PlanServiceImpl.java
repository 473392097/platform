package com.sudao.cloud.module.idea.service;

import com.sudao.cloud.module.base.config.enums.Deleted;
import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.dao.page.Pagination;
import com.sudao.cloud.module.base.service.BaseServiceImpl;
import com.sudao.cloud.module.base.utils.BeanUtils;
import com.sudao.cloud.module.idea.dao.dto.PlanDTO;
import com.sudao.cloud.module.idea.dao.dto.PlanDTOExample;
import com.sudao.cloud.module.idea.dao.dto.PlanDTO;
import com.sudao.cloud.module.idea.dao.dto.PlanDTOExample;
import com.sudao.cloud.module.idea.dao.mapper.PlanDTOMapper;
import com.sudao.cloud.module.idea.vo.req.PlanQuery;
import com.sudao.cloud.module.idea.vo.req.PlanReq;
import com.sudao.cloud.module.idea.vo.resp.IdeaResp;
import com.sudao.cloud.module.idea.vo.resp.PlanResp;
import com.sudao.cloud.module.idea.vo.resp.PlanResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PlanServiceImpl extends BaseServiceImpl implements PlanService {

    @Autowired
    private PlanDTOMapper planDTOMapper;

	@Override
	public PlanResp getById(Long planId) {
		PlanDTO planDTO = this.planDTOMapper.selectByPrimaryKey(planId);
		if (planDTO != null && Deleted.NORMAL.code() == planDTO.getDeleted()) {
			return BeanUtils.copyProperties(planDTO, PlanResp.class);
		}

		return null;
	}

	@Override
	public boolean create(PlanReq obj) {
		logger.debug("Creating Plan: {}", obj);
		Date date = new Date();

		PlanDTO planDTO = BeanUtils.copyProperties(obj, PlanDTO.class);
		planDTO.setDeleted(Deleted.NORMAL.code());
        planDTO.setCreateTime(date);
        planDTO.setCreateUserId(obj.getOperatorId());
        planDTO.setCreateUserName(obj.getOperatorName());
        planDTO.setUpdateTime(date);
        planDTO.setUpdateUserId(obj.getOperatorId());
        planDTO.setUpdateUserName(obj.getOperatorName());

		return this.planDTOMapper.insertSelective(planDTO) > 0;
	}

	@Override
	public boolean update(PlanReq obj) {
		logger.debug("Updating Plan: {}", obj);

		PlanDTO planDTO = BeanUtils.copyProperties(obj, PlanDTO.class);
		planDTO.setUpdateTime(new Date());
        planDTO.setUpdateUserId(obj.getOperatorId());
        planDTO.setUpdateUserName(obj.getOperatorName());
		return this.planDTOMapper.updateByPrimaryKeySelective(planDTO) > 0;
	}

	@Override
	public Page<PlanResp> find(PlanQuery query) {
		Page<PlanResp> page = new Page<PlanResp>(query);
        PlanDTOExample example = new PlanDTOExample();
        PlanDTOExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(Deleted.NORMAL.code());
        example.setOrderByClause("plan_id DESC");

        long total = this.planDTOMapper.countByExample(example);
        page.setTotal(total);
        if (total > query.getOffset()) {
            List<PlanDTO> list = this.planDTOMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
            page.setItems(BeanUtils.copyListProperties(list, PlanResp.class));
        }
        return page;
	}

	@Override
	public Page<PlanResp> findByExample(PlanDTOExample example, Pagination pagination) {
		Page<PlanResp> page = new Page<PlanResp>(pagination);
		long total = this.planDTOMapper.countByExample(example);
		page.setTotal(total);
		if (total > pagination.getOffset()) {
			List<PlanDTO> list = this.planDTOMapper.selectByExampleWithRowbounds(example, this.toRowBounds(pagination));
			page.setItems(BeanUtils.copyListProperties(list, PlanResp.class));
		}
		return page;

	}

	@Override
	public List<PlanResp> findByExample(PlanDTOExample example) {
		List<PlanDTO> list = this.planDTOMapper.selectByExample(example);
		List<PlanResp> targets = BeanUtils.copyListProperties(list, PlanResp.class);
		return targets;
	}
}
