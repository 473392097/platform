package com.sudao.cloud.module.idea.dao.mapper;

import com.sudao.cloud.module.idea.dao.dto.PlanContextDTO;
import com.sudao.cloud.module.idea.dao.dto.PlanContextDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PlanContextDTOMapper {
    long countByExample(PlanContextDTOExample example);

    int deleteByExample(PlanContextDTOExample example);

    int deleteByPrimaryKey(Long contextId);

    int insert(PlanContextDTO record);

    int insertSelective(PlanContextDTO record);

    List<PlanContextDTO> selectByExampleWithRowbounds(PlanContextDTOExample example, RowBounds rowBounds);

    List<PlanContextDTO> selectByExample(PlanContextDTOExample example);

    PlanContextDTO selectByPrimaryKey(Long contextId);

    int updateByExampleSelective(@Param("record") PlanContextDTO record, @Param("example") PlanContextDTOExample example);

    int updateByExample(@Param("record") PlanContextDTO record, @Param("example") PlanContextDTOExample example);

    int updateByPrimaryKeySelective(PlanContextDTO record);

    int updateByPrimaryKey(PlanContextDTO record);
}