package com.sudao.cloud.module.catelog.dao.mapper;

import com.sudao.cloud.module.catelog.dao.dto.CatelogDTO;
import com.sudao.cloud.module.catelog.dao.dto.CatelogDTOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

public interface CatelogDTOMapper {
    long countByExample(CatelogDTOExample example);

    int deleteByExample(CatelogDTOExample example);

    int deleteByPrimaryKey(Long catelogId);

    int insert(CatelogDTO record);

    int insertSelective(CatelogDTO record);

    List<CatelogDTO> selectByExampleWithRowbounds(CatelogDTOExample example, RowBounds rowBounds);

    List<CatelogDTO> selectByExample(CatelogDTOExample example);

    CatelogDTO selectByPrimaryKey(Long catelogId);

    int updateByExampleSelective(@Param("record") CatelogDTO record, @Param("example") CatelogDTOExample example);

    int updateByExample(@Param("record") CatelogDTO record, @Param("example") CatelogDTOExample example);

    int updateByPrimaryKeySelective(CatelogDTO record);

    int updateByPrimaryKey(CatelogDTO record);
}