package com.sudao.cloud.module.idea.service;

import com.sudao.cloud.module.base.config.enums.Status;
import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.service.BaseServiceImpl;
import com.sudao.cloud.module.base.utils.BeanUtils;
import com.sudao.cloud.module.idea.dao.dto.IdeaDTO;
import com.sudao.cloud.module.idea.dao.dto.IdeaDTOExample;
import com.sudao.cloud.module.idea.dao.mapper.IdeaDTOMapper;
import com.sudao.cloud.module.idea.vo.req.IdeaQuery;
import com.sudao.cloud.module.idea.vo.req.IdeaReq;
import com.sudao.cloud.module.idea.vo.resp.IdeaResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class IdeaServiceImpl extends BaseServiceImpl implements IdeaService {

    @Autowired
    private IdeaDTOMapper ideaDTOMapper;

	@Override
	public IdeaResp getById(Long ideaId) {
		IdeaDTO ideaDTO = this.ideaDTOMapper.selectByPrimaryKey(ideaId);
		if (ideaDTO != null && Status.NORMAL.equals(ideaDTO.getStatus())) {
			return BeanUtils.copyProperties(ideaDTO, IdeaResp.class);
		}

		return null;
	}

	@Override
	public boolean create(IdeaReq obj) {
		logger.debug("Creating Idea: {}", obj);
		Long time = new Date().getTime();

		IdeaDTO ideaDTO = BeanUtils.copyProperties(obj, IdeaDTO.class);
		ideaDTO.setStatus(Status.NORMAL);
		ideaDTO.setCreatedById(obj.getOperator());
		ideaDTO.setCreatedTime(time);
		ideaDTO.setUpdatedById(obj.getOperator());
		ideaDTO.setUpdatedTime(time);

		return this.ideaDTOMapper.insertSelective(ideaDTO) > 0;
	}

	@Override
	public boolean update(IdeaReq obj) {
		logger.debug("Updating Idea: {}", obj);

		IdeaDTO ideaDTO = BeanUtils.copyProperties(obj, IdeaDTO.class);
		ideaDTO.setUpdatedById(obj.getOperator());
		ideaDTO.setUpdatedTime(new Date().getTime());
		return this.ideaDTOMapper.updateByPrimaryKeySelective(ideaDTO) > 0;
	}

	@Override
	public Page<IdeaResp> find(IdeaQuery query) {
		Page<IdeaResp> page = new Page<IdeaResp>(query);
        IdeaDTOExample example = new IdeaDTOExample();
        IdeaDTOExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(Status.NORMAL);
        example.setOrderByClause("ideaId DESC");

        long total = this.ideaDTOMapper.countByExample(example);
        page.setTotal(total);
        if (total > query.getOffset()) {
            List<IdeaDTO> list = this.ideaDTOMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
            page.setItems(BeanUtils.copyListProperties(list, IdeaResp.class));
        }
        return page;
	}
}
