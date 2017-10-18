package com.sudao.cloud.module.idea.dao.mapper;

import com.sudao.cloud.module.idea.dao.dto.PlanDTO;
import com.sudao.cloud.module.idea.dao.dto.PlanDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PlanDTOMapper {
    long countByExample(PlanDTOExample example);

    int deleteByExample(PlanDTOExample example);

    int deleteByPrimaryKey(Long planId);

    int insert(PlanDTO record);

    int insertSelective(PlanDTO record);

    List<PlanDTO> selectByExampleWithRowbounds(PlanDTOExample example, RowBounds rowBounds);

    List<PlanDTO> selectByExample(PlanDTOExample example);

    PlanDTO selectByPrimaryKey(Long planId);

    int updateByExampleSelective(@Param("record") PlanDTO record, @Param("example") PlanDTOExample example);

    int updateByExample(@Param("record") PlanDTO record, @Param("example") PlanDTOExample example);

    int updateByPrimaryKeySelective(PlanDTO record);

    int updateByPrimaryKey(PlanDTO record);
}