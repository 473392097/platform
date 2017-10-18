package com.sudao.cloud.module.praise.dao.mapper;

import com.sudao.cloud.module.praise.dao.dto.FeedbackDTO;
import com.sudao.cloud.module.praise.dao.dto.FeedbackDTOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface FeedbackDTOMapper {
    long countByExample(FeedbackDTOExample example);

    int deleteByExample(FeedbackDTOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FeedbackDTO record);

    int insertSelective(FeedbackDTO record);

    List<FeedbackDTO> selectByExampleWithRowbounds(FeedbackDTOExample example, RowBounds rowBounds);

    List<FeedbackDTO> selectByExample(FeedbackDTOExample example);

    FeedbackDTO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FeedbackDTO record, @Param("example") FeedbackDTOExample example);

    int updateByExample(@Param("record") FeedbackDTO record, @Param("example") FeedbackDTOExample example);

    int updateByPrimaryKeySelective(FeedbackDTO record);

    int updateByPrimaryKey(FeedbackDTO record);
}