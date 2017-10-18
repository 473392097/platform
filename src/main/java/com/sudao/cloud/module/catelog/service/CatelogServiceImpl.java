package com.sudao.cloud.module.catelog.service;

import com.sudao.cloud.module.base.config.enums.Status;
import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.service.BaseServiceImpl;
import com.sudao.cloud.module.base.utils.BeanUtils;
import com.sudao.cloud.module.catelog.dao.dto.CatelogDTO;
import com.sudao.cloud.module.catelog.dao.dto.CatelogDTOExample;
import com.sudao.cloud.module.catelog.dao.mapper.CatelogDTOMapper;
import com.sudao.cloud.module.catelog.vo.req.CatelogQuery;
import com.sudao.cloud.module.catelog.vo.req.CatelogReq;
import com.sudao.cloud.module.catelog.vo.resp.CatelogResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CatelogServiceImpl extends BaseServiceImpl implements CatelogService {

    @Autowired
    private CatelogDTOMapper catelogDTOMapper;

	@Override
	public CatelogResp getById(Long catelogId) {
		CatelogDTO catelogDTO = this.catelogDTOMapper.selectByPrimaryKey(catelogId);
		if (catelogDTO != null && Status.NORMAL.equals(catelogDTO.getStatus())) {
			return BeanUtils.copyProperties(catelogDTO, CatelogResp.class);
		}

		return null;
	}

	@Override
	public boolean create(CatelogReq obj) {
		logger.debug("Creating Catelog: {}", obj);
		Long time = new Date().getTime();

		CatelogDTO catelogDTO = BeanUtils.copyProperties(obj, CatelogDTO.class);
		catelogDTO.setStatus(Status.NORMAL);
		catelogDTO.setCreatedById(obj.getOperator());
		catelogDTO.setCreatedTime(time);
		catelogDTO.setUpdatedById(obj.getOperator());
		catelogDTO.setUpdatedTime(time);

		return this.catelogDTOMapper.insertSelective(catelogDTO) > 0;
	}

	@Override
	public boolean update(CatelogReq obj) {
		logger.debug("Updating Catelog: {}", obj);

		CatelogDTO catelogDTO = BeanUtils.copyProperties(obj, CatelogDTO.class);
		catelogDTO.setUpdatedById(obj.getOperator());
		catelogDTO.setUpdatedTime(new Date().getTime());
		return this.catelogDTOMapper.updateByPrimaryKeySelective(catelogDTO) > 0;
	}

	@Override
	public Page<CatelogResp> find(CatelogQuery query) {
		Page<CatelogResp> page = new Page<CatelogResp>(query);
        CatelogDTOExample example = new CatelogDTOExample();
        CatelogDTOExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(Status.NORMAL);
        example.setOrderByClause("catelogId DESC");

        long total = this.catelogDTOMapper.countByExample(example);
        page.setTotal(total);
        if (total > query.getOffset()) {
            List<CatelogDTO> list = this.catelogDTOMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
            page.setItems(BeanUtils.copyListProperties(list, CatelogResp.class));
        }
        return page;
	}
}
