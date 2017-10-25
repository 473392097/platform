package com.sudao.cloud.module.idea.service;

import com.sudao.cloud.module.base.config.enums.Deleted;
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
		if (ideaDTO != null && Deleted.NORMAL.code() == ideaDTO.getDeleted()) {
			return BeanUtils.copyProperties(ideaDTO, IdeaResp.class);
		}

		return null;
	}

	@Override
	public boolean create(IdeaReq obj) {
		logger.debug("Creating Idea: {}", obj);
		Date date = new Date();

		IdeaDTO ideaDTO = BeanUtils.copyProperties(obj, IdeaDTO.class);
		ideaDTO.setDeleted(Deleted.NORMAL.code());
        ideaDTO.setCreateTime(date);
        ideaDTO.setCreateUserId(obj.getOperatorId());
        ideaDTO.setCreateUserName(obj.getOperatorName());
        ideaDTO.setUpdateTime(date);
        ideaDTO.setUpdateUserId(obj.getOperatorId());
        ideaDTO.setUpdateUserName(obj.getOperatorName());

		return this.ideaDTOMapper.insertSelective(ideaDTO) > 0;
	}

	@Override
	public boolean update(IdeaReq obj) {
		logger.debug("Updating Idea: {}", obj);

		IdeaDTO ideaDTO = BeanUtils.copyProperties(obj, IdeaDTO.class);
		ideaDTO.setUpdateTime(new Date());
        ideaDTO.setUpdateUserId(obj.getOperatorId());
        ideaDTO.setUpdateUserName(obj.getOperatorName());
		return this.ideaDTOMapper.updateByPrimaryKeySelective(ideaDTO) > 0;
	}

	@Override
	public Page<IdeaResp> find(IdeaQuery query) {
		Page<IdeaResp> page = new Page<IdeaResp>(query);
        IdeaDTOExample example = new IdeaDTOExample();
        IdeaDTOExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(Deleted.NORMAL.code());
        example.setOrderByClause("idea_id DESC");

        long total = this.ideaDTOMapper.countByExample(example);
        page.setTotal(total);
        if (total > query.getOffset()) {
            List<IdeaDTO> list = this.ideaDTOMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
            page.setItems(BeanUtils.copyListProperties(list, IdeaResp.class));
        }
        return page;
	}
}
