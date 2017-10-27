package com.sudao.cloud.module.commons.dao.mapper;

import com.sudao.cloud.module.commons.dao.dto.ArticleDTO;
import com.sudao.cloud.module.commons.dao.dto.ArticleDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ArticleDTOMapper {
    long countByExample(ArticleDTOExample example);

    int deleteByExample(ArticleDTOExample example);

    int deleteByPrimaryKey(Long articleId);

    int insert(ArticleDTO record);

    int insertSelective(ArticleDTO record);

    List<ArticleDTO> selectByExampleWithBLOBsWithRowbounds(ArticleDTOExample example, RowBounds rowBounds);

    List<ArticleDTO> selectByExampleWithBLOBs(ArticleDTOExample example);

    List<ArticleDTO> selectByExampleWithRowbounds(ArticleDTOExample example, RowBounds rowBounds);

    List<ArticleDTO> selectByExample(ArticleDTOExample example);

    ArticleDTO selectByPrimaryKey(Long articleId);

    int updateByExampleSelective(@Param("record") ArticleDTO record, @Param("example") ArticleDTOExample example);

    int updateByExampleWithBLOBs(@Param("record") ArticleDTO record, @Param("example") ArticleDTOExample example);

    int updateByExample(@Param("record") ArticleDTO record, @Param("example") ArticleDTOExample example);

    int updateByPrimaryKeySelective(ArticleDTO record);

    int updateByPrimaryKeyWithBLOBs(ArticleDTO record);

    int updateByPrimaryKey(ArticleDTO record);
}