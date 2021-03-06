package com.sudao.cloud.module.idea.service;

import com.sudao.cloud.module.base.config.enums.Deleted;
import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.dao.page.Pagination;
import com.sudao.cloud.module.base.service.BaseServiceImpl;
import com.sudao.cloud.module.base.utils.BeanUtils;
import com.sudao.cloud.module.idea.dao.dto.PlanContextDTO;
import com.sudao.cloud.module.idea.dao.dto.PlanContextDTOExample;
import com.sudao.cloud.module.idea.dao.mapper.PlanContextDTOMapper;
import com.sudao.cloud.module.idea.vo.req.PlanContextQuery;
import com.sudao.cloud.module.idea.vo.req.PlanContextReq;
import com.sudao.cloud.module.idea.vo.resp.PlanContextResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PlanContextServiceImpl extends BaseServiceImpl implements PlanContextService {

    @Autowired
    private PlanContextDTOMapper planContextDTOMapper;

	@Override
	public PlanContextResp getById(Long contextId) {
		PlanContextDTO planContextDTO = this.planContextDTOMapper.selectByPrimaryKey(contextId);
		if (planContextDTO != null && Deleted.NORMAL.code() == planContextDTO.getDeleted()) {
			return BeanUtils.copyProperties(planContextDTO, PlanContextResp.class);
		}

		return null;
	}

	@Override
	public boolean create(PlanContextReq obj) {
		logger.debug("Creating PlanContext: {}", obj);
		Date date = new Date();

		PlanContextDTO planContextDTO = BeanUtils.copyProperties(obj, PlanContextDTO.class);
		planContextDTO.setDeleted(Deleted.NORMAL.code());
        planContextDTO.setCreateTime(date);
        planContextDTO.setCreateUserId(obj.getOperatorId());
        planContextDTO.setCreateUserName(obj.getOperatorName());
        planContextDTO.setUpdateTime(date);
        planContextDTO.setUpdateUserId(obj.getOperatorId());
        planContextDTO.setUpdateUserName(obj.getOperatorName());

		return this.planContextDTOMapper.insertSelective(planContextDTO) > 0;
	}

	@Override
	public boolean update(PlanContextReq obj) {
		logger.debug("Updating PlanContext: {}", obj);

		PlanContextDTO planContextDTO = BeanUtils.copyProperties(obj, PlanContextDTO.class);
		planContextDTO.setUpdateTime(new Date());
        planContextDTO.setUpdateUserId(obj.getOperatorId());
        planContextDTO.setUpdateUserName(obj.getOperatorName());
		return this.planContextDTOMapper.updateByPrimaryKeySelective(planContextDTO) > 0;
	}

	@Override
	public Page<PlanContextResp> find(PlanContextQuery query) {
		Page<PlanContextResp> page = new Page<PlanContextResp>(query);
        PlanContextDTOExample example = new PlanContextDTOExample();
        PlanContextDTOExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(Deleted.NORMAL.code());
        example.setOrderByClause("context_id DESC");

        long total = this.planContextDTOMapper.countByExample(example);
        page.setTotal(total);
        if (total > query.getOffset()) {
            List<PlanContextDTO> list = this.planContextDTOMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
            page.setItems(BeanUtils.copyListProperties(list, PlanContextResp.class));
        }
        return page;
	}

	@Override
	public Page<PlanContextResp> findByExample(PlanContextDTOExample example, Pagination pagination) {
		Page<PlanContextResp> page = new Page<PlanContextResp>(pagination);
		long total = this.planContextDTOMapper.countByExample(example);
		page.setTotal(total);
		if (total > pagination.getOffset()) {
			List<PlanContextDTO> list = this.planContextDTOMapper.selectByExampleWithRowbounds(example, this.toRowBounds(pagination));
			page.setItems(BeanUtils.copyListProperties(list, PlanContextResp.class));
		}
		return page;

	}

	@Override
	public List<PlanContextResp> findByExample(PlanContextDTOExample example) {
		List<PlanContextDTO> list = this.planContextDTOMapper.selectByExample(example);
		List<PlanContextResp> targets = BeanUtils.copyListProperties(list, PlanContextResp.class);
		return targets;
	}
}
