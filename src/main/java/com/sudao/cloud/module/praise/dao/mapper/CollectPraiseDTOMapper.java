package com.sudao.cloud.module.praise.dao.mapper;

import com.sudao.cloud.module.praise.dao.dto.CollectPraiseDTO;
import com.sudao.cloud.module.praise.dao.dto.CollectPraiseDTOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface CollectPraiseDTOMapper {
    long countByExample(CollectPraiseDTOExample example);

    int deleteByExample(CollectPraiseDTOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CollectPraiseDTO record);

    int insertSelective(CollectPraiseDTO record);

    List<CollectPraiseDTO> selectByExampleWithRowbounds(CollectPraiseDTOExample example, RowBounds rowBounds);

    List<CollectPraiseDTO> selectByExample(CollectPraiseDTOExample example);

    CollectPraiseDTO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CollectPraiseDTO record, @Param("example") CollectPraiseDTOExample example);

    int updateByExample(@Param("record") CollectPraiseDTO record, @Param("example") CollectPraiseDTOExample example);

    int updateByPrimaryKeySelective(CollectPraiseDTO record);

    int updateByPrimaryKey(CollectPraiseDTO record);
}