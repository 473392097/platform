package com.sudao.cloud.module.category.dao.mapper;

import com.sudao.cloud.module.category.dao.dto.CategoryDTO;
import com.sudao.cloud.module.category.dao.dto.CategoryDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CategoryDTOMapper {
    long countByExample(CategoryDTOExample example);

    int deleteByExample(CategoryDTOExample example);

    int deleteByPrimaryKey(Long categoryId);

    int insert(CategoryDTO record);

    int insertSelective(CategoryDTO record);

    List<CategoryDTO> selectByExampleWithRowbounds(CategoryDTOExample example, RowBounds rowBounds);

    List<CategoryDTO> selectByExample(CategoryDTOExample example);

    CategoryDTO selectByPrimaryKey(Long categoryId);

    int updateByExampleSelective(@Param("record") CategoryDTO record, @Param("example") CategoryDTOExample example);

    int updateByExample(@Param("record") CategoryDTO record, @Param("example") CategoryDTOExample example);

    int updateByPrimaryKeySelective(CategoryDTO record);

    int updateByPrimaryKey(CategoryDTO record);
}