package com.sudao.cloud.module.idea.dao.mapper;

import com.sudao.cloud.module.idea.dao.dto.IdeaDTO;
import com.sudao.cloud.module.idea.dao.dto.IdeaDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface IdeaDTOMapper {
    long countByExample(IdeaDTOExample example);

    int deleteByExample(IdeaDTOExample example);

    int deleteByPrimaryKey(Long ideaId);

    int insert(IdeaDTO record);

    int insertSelective(IdeaDTO record);

    List<IdeaDTO> selectByExampleWithRowbounds(IdeaDTOExample example, RowBounds rowBounds);

    List<IdeaDTO> selectByExample(IdeaDTOExample example);

    IdeaDTO selectByPrimaryKey(Long ideaId);

    int updateByExampleSelective(@Param("record") IdeaDTO record, @Param("example") IdeaDTOExample example);

    int updateByExample(@Param("record") IdeaDTO record, @Param("example") IdeaDTOExample example);

    int updateByPrimaryKeySelective(IdeaDTO record);

    int updateByPrimaryKey(IdeaDTO record);
}