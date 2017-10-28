package com.sudao.cloud.module.commons.service;

import com.sudao.cloud.module.base.config.enums.Deleted;
import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.service.BaseServiceImpl;
import com.sudao.cloud.module.base.utils.BeanUtils;
import com.sudao.cloud.module.commons.dao.dto.ReportDTO;
import com.sudao.cloud.module.commons.dao.dto.ReportDTOExample;
import com.sudao.cloud.module.commons.dao.mapper.ReportDTOMapper;
import com.sudao.cloud.module.commons.vo.req.ReportQuery;
import com.sudao.cloud.module.commons.vo.req.ReportReq;
import com.sudao.cloud.module.commons.vo.resp.ReportResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReportServiceImpl extends BaseServiceImpl implements ReportService {

    @Autowired
    private ReportDTOMapper reportDTOMapper;

	@Override
	public ReportResp getById(Long reportId) {
		ReportDTO reportDTO = this.reportDTOMapper.selectByPrimaryKey(reportId);
		if (reportDTO != null && Deleted.NORMAL.code() == reportDTO.getDeleted()) {
			return BeanUtils.copyProperties(reportDTO, ReportResp.class);
		}

		return null;
	}

	@Override
	public boolean create(ReportReq obj) {
		logger.debug("Creating Report: {}", obj);
		Date date = new Date();

		ReportDTO reportDTO = BeanUtils.copyProperties(obj, ReportDTO.class);
		reportDTO.setDeleted(Deleted.NORMAL.code());
        reportDTO.setCreateTime(date);
        reportDTO.setCreateUserId(obj.getOperatorId());
        reportDTO.setCreateUserName(obj.getOperatorName());
        reportDTO.setUpdateTime(date);
        reportDTO.setUpdateUserId(obj.getOperatorId());
        reportDTO.setUpdateUserName(obj.getOperatorName());

		return this.reportDTOMapper.insertSelective(reportDTO) > 0;
	}

	@Override
	public boolean update(ReportReq obj) {
		logger.debug("Updating Report: {}", obj);

		ReportDTO reportDTO = BeanUtils.copyProperties(obj, ReportDTO.class);
		reportDTO.setUpdateTime(new Date());
        reportDTO.setUpdateUserId(obj.getOperatorId());
        reportDTO.setUpdateUserName(obj.getOperatorName());
		return this.reportDTOMapper.updateByPrimaryKeySelective(reportDTO) > 0;
	}

	@Override
	public Page<ReportResp> find(ReportQuery query) {
		Page<ReportResp> page = new Page<ReportResp>(query);
        ReportDTOExample example = new ReportDTOExample();
        ReportDTOExample.Criteria criteria = example.createCriteria();

		if(null != query.getBeginDateTime() && null != query.getEndDateTime()) {
			criteria.andCreateTimeBetween(query.getBeginDateTime(), query.getEndDateTime());
		}
		if(null != query.getProcessStatus()){
			criteria.andProcessStatusLike(query.getProcessStatus());
		}
        criteria.andDeletedEqualTo(Deleted.NORMAL.code());
        example.setOrderByClause("report_id DESC");

        long total = this.reportDTOMapper.countByExample(example);
        page.setTotal(total);
        if (total > query.getOffset()) {
            List<ReportDTO> list = this.reportDTOMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
            page.setItems(BeanUtils.copyListProperties(list, ReportResp.class));
        }
        return page;
	}
}
