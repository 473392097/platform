package com.sudao.cloud.module.idea.dao.mapper;

import com.sudao.cloud.module.idea.dao.dto.UserIdeaStatisticsDTO;
import com.sudao.cloud.module.idea.dao.dto.UserIdeaStatisticsDTOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface UserIdeaStatisticsDTOMapper {
    long countByExample(UserIdeaStatisticsDTOExample example);

    int deleteByExample(UserIdeaStatisticsDTOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserIdeaStatisticsDTO record);

    int insertSelective(UserIdeaStatisticsDTO record);

    List<UserIdeaStatisticsDTO> selectByExampleWithRowbounds(UserIdeaStatisticsDTOExample example, RowBounds rowBounds);

    List<UserIdeaStatisticsDTO> selectByExample(UserIdeaStatisticsDTOExample example);

    UserIdeaStatisticsDTO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserIdeaStatisticsDTO record, @Param("example") UserIdeaStatisticsDTOExample example);

    int updateByExample(@Param("record") UserIdeaStatisticsDTO record, @Param("example") UserIdeaStatisticsDTOExample example);

    int updateByPrimaryKeySelective(UserIdeaStatisticsDTO record);

    int updateByPrimaryKey(UserIdeaStatisticsDTO record);
}