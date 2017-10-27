package com.sudao.cloud.module.commons.service;

import com.sudao.cloud.module.base.config.enums.Deleted;
import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.service.BaseServiceImpl;
import com.sudao.cloud.module.base.utils.BeanUtils;
import com.sudao.cloud.module.commons.dao.dto.InformationDTO;
import com.sudao.cloud.module.commons.dao.dto.InformationDTOExample;
import com.sudao.cloud.module.commons.dao.mapper.InformationDTOMapper;
import com.sudao.cloud.module.commons.vo.req.InformationQuery;
import com.sudao.cloud.module.commons.vo.req.InformationReq;
import com.sudao.cloud.module.commons.vo.resp.InformationResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InformationServiceImpl extends BaseServiceImpl implements InformationService {

    @Autowired
    private InformationDTOMapper informationDTOMapper;

	@Override
	public InformationResp getById(Long id) {
		InformationDTO informationDTO = this.informationDTOMapper.selectByPrimaryKey(id);
		if (informationDTO != null && Deleted.NORMAL.code() == informationDTO.getDeleted()) {
			return BeanUtils.copyProperties(informationDTO, InformationResp.class);
		}

		return null;
	}

	@Override
	public boolean create(InformationReq obj) {
		logger.debug("Creating Information: {}", obj);
		Date date = new Date();

		InformationDTO informationDTO = BeanUtils.copyProperties(obj, InformationDTO.class);
        informationDTO.setDeleted(Deleted.NORMAL.code());
        informationDTO.setCreateTime(date);
        informationDTO.setCreateUserId(obj.getOperatorId());
        informationDTO.setCreateUserName(obj.getOperatorName());
        informationDTO.setUpdateTime(date);
        informationDTO.setUpdateUserId(obj.getOperatorId());
        informationDTO.setUpdateUserName(obj.getOperatorName());

		return this.informationDTOMapper.insertSelective(informationDTO) > 0;
	}

	@Override
	public boolean update(InformationReq obj) {
		logger.debug("Updating Information: {}", obj);

		InformationDTO informationDTO = BeanUtils.copyProperties(obj, InformationDTO.class);
        informationDTO.setUpdateTime(new Date());
        informationDTO.setUpdateUserId(obj.getOperatorId());
        informationDTO.setUpdateUserName(obj.getOperatorName());
		return this.informationDTOMapper.updateByPrimaryKeySelective(informationDTO) > 0;
	}

	@Override
	public Page<InformationResp> find(InformationQuery query) {
		Page<InformationResp> page = new Page<InformationResp>(query);
        InformationDTOExample example = new InformationDTOExample();
        InformationDTOExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(Deleted.NORMAL.code());
        example.setOrderByClause("id DESC");

        long total = this.informationDTOMapper.countByExample(example);
        page.setTotal(total);
        if (total > query.getOffset()) {
        List<InformationDTO> list = this.informationDTOMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
            page.setItems(BeanUtils.copyListProperties(list, InformationResp.class));
        }
        return page;
	}
}
