package com.sudao.cloud.module.idea.dao.mapper;

import com.sudao.cloud.module.idea.dao.dto.ReportDTO;
import com.sudao.cloud.module.idea.dao.dto.ReportDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ReportDTOMapper {
    long countByExample(ReportDTOExample example);

    int deleteByExample(ReportDTOExample example);

    int deleteByPrimaryKey(Long reportId);

    int insert(ReportDTO record);

    int insertSelective(ReportDTO record);

    List<ReportDTO> selectByExampleWithRowbounds(ReportDTOExample example, RowBounds rowBounds);

    List<ReportDTO> selectByExample(ReportDTOExample example);

    ReportDTO selectByPrimaryKey(Long reportId);

    int updateByExampleSelective(@Param("record") ReportDTO record, @Param("example") ReportDTOExample example);

    int updateByExample(@Param("record") ReportDTO record, @Param("example") ReportDTOExample example);

    int updateByPrimaryKeySelective(ReportDTO record);

    int updateByPrimaryKey(ReportDTO record);
}