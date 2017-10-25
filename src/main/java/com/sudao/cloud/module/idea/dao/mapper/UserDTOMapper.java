package com.sudao.cloud.module.idea.dao.mapper;

import com.sudao.cloud.module.idea.dao.dto.UserDTO;
import com.sudao.cloud.module.idea.dao.dto.UserDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserDTOMapper {
    long countByExample(UserDTOExample example);

    int deleteByExample(UserDTOExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(UserDTO record);

    int insertSelective(UserDTO record);

    List<UserDTO> selectByExampleWithRowbounds(UserDTOExample example, RowBounds rowBounds);

    List<UserDTO> selectByExample(UserDTOExample example);

    UserDTO selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") UserDTO record, @Param("example") UserDTOExample example);

    int updateByExample(@Param("record") UserDTO record, @Param("example") UserDTOExample example);

    int updateByPrimaryKeySelective(UserDTO record);

    int updateByPrimaryKey(UserDTO record);
}