package com.sudao.cloud.module.commons.dao.mapper;

import com.sudao.cloud.module.commons.dao.dto.InformationDTO;
import com.sudao.cloud.module.commons.dao.dto.InformationDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface InformationDTOMapper {
    long countByExample(InformationDTOExample example);

    int deleteByExample(InformationDTOExample example);

    int deleteByPrimaryKey(Long informationId);

    int insert(InformationDTO record);

    int insertSelective(InformationDTO record);

    List<InformationDTO> selectByExampleWithRowbounds(InformationDTOExample example, RowBounds rowBounds);

    List<InformationDTO> selectByExample(InformationDTOExample example);

    InformationDTO selectByPrimaryKey(Long informationId);

    int updateByExampleSelective(@Param("record") InformationDTO record, @Param("example") InformationDTOExample example);

    int updateByExample(@Param("record") InformationDTO record, @Param("example") InformationDTOExample example);

    int updateByPrimaryKeySelective(InformationDTO record);

    int updateByPrimaryKey(InformationDTO record);
}