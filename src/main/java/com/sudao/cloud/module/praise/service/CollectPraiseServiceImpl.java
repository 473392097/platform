package com.sudao.cloud.module.praise.service;

import com.sudao.cloud.module.base.config.enums.Deleted;
import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.service.BaseServiceImpl;
import com.sudao.cloud.module.base.utils.BeanUtils;
import com.sudao.cloud.module.praise.dao.dto.CollectPraiseDTO;
import com.sudao.cloud.module.praise.dao.dto.CollectPraiseDTOExample;
import com.sudao.cloud.module.praise.dao.mapper.CollectPraiseDTOMapper;
import com.sudao.cloud.module.praise.vo.req.CollectPraiseQuery;
import com.sudao.cloud.module.praise.vo.req.CollectPraiseReq;
import com.sudao.cloud.module.praise.vo.resp.CollectPraiseResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CollectPraiseServiceImpl extends BaseServiceImpl implements CollectPraiseService {

    @Autowired
    private CollectPraiseDTOMapper collectPraiseDTOMapper;

	@Override
	public CollectPraiseResp getById(Long id) {
		CollectPraiseDTO collectPraiseDTO = this.collectPraiseDTOMapper.selectByPrimaryKey(id);
		if (collectPraiseDTO != null && Deleted.NORMAL.code() == collectPraiseDTO.getDeleted()) {
			return BeanUtils.copyProperties(collectPraiseDTO, CollectPraiseResp.class);
		}

		return null;
	}

	@Override
	public boolean create(CollectPraiseReq obj) {
		logger.debug("Creating CollectPraise: {}", obj);
		Date date = new Date();

		CollectPraiseDTO collectPraiseDTO = BeanUtils.copyProperties(obj, CollectPraiseDTO.class);
		collectPraiseDTO.setDeleted(Deleted.NORMAL.code());
        collectPraiseDTO.setCreateTime(date);
        collectPraiseDTO.setCreateUserId(obj.getOperatorId());
        collectPraiseDTO.setCreateUserName(obj.getOperatorName());
        collectPraiseDTO.setUpdateTime(date);
        collectPraiseDTO.setUpdateUserId(obj.getOperatorId());
        collectPraiseDTO.setUpdateUserName(obj.getOperatorName());

		return this.collectPraiseDTOMapper.insertSelective(collectPraiseDTO) > 0;
	}

	@Override
	public boolean update(CollectPraiseReq obj) {
		logger.debug("Updating CollectPraise: {}", obj);

		CollectPraiseDTO collectPraiseDTO = BeanUtils.copyProperties(obj, CollectPraiseDTO.class);
		collectPraiseDTO.setUpdateTime(new Date());
        collectPraiseDTO.setUpdateUserId(obj.getOperatorId());
        collectPraiseDTO.setUpdateUserName(obj.getOperatorName());
		return this.collectPraiseDTOMapper.updateByPrimaryKeySelective(collectPraiseDTO) > 0;
	}

	@Override
	public Page<CollectPraiseResp> find(CollectPraiseQuery query) {
		Page<CollectPraiseResp> page = new Page<CollectPraiseResp>(query);
        CollectPraiseDTOExample example = new CollectPraiseDTOExample();
        CollectPraiseDTOExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(Deleted.NORMAL.code());
        example.setOrderByClause("id DESC");

        long total = this.collectPraiseDTOMapper.countByExample(example);
        page.setTotal(total);
        if (total > query.getOffset()) {
            List<CollectPraiseDTO> list = this.collectPraiseDTOMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
            page.setItems(BeanUtils.copyListProperties(list, CollectPraiseResp.class));
        }
        return page;
	}
}
