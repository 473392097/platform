package com.sudao.cloud.module.commons.service;

import com.sudao.cloud.module.base.config.enums.Deleted;
import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.service.BaseServiceImpl;
import com.sudao.cloud.module.base.utils.BeanUtils;
import com.sudao.cloud.module.commons.dao.dto.ArticleDTO;
import com.sudao.cloud.module.commons.dao.dto.ArticleDTOExample;
import com.sudao.cloud.module.commons.dao.mapper.ArticleDTOMapper;
import com.sudao.cloud.module.commons.vo.req.ArticleQuery;
import com.sudao.cloud.module.commons.vo.req.ArticleReq;
import com.sudao.cloud.module.commons.vo.resp.ArticleResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl extends BaseServiceImpl implements ArticleService {

    @Autowired
    private ArticleDTOMapper articleDTOMapper;

	@Override
	public ArticleResp getById(Long article_id) {
		ArticleDTO articleDTO = this.articleDTOMapper.selectByPrimaryKey(article_id);
		if (articleDTO != null && Deleted.NORMAL.code() == articleDTO.getDeleted()) {
			return BeanUtils.copyProperties(articleDTO, ArticleResp.class);
		}

		return null;
	}

	@Override
	public boolean create(ArticleReq obj) {
		logger.debug("Creating Article: {}", obj);
		Date date = new Date();

		ArticleDTO articleDTO = BeanUtils.copyProperties(obj, ArticleDTO.class);
        articleDTO.setDeleted(Deleted.NORMAL.code());
        articleDTO.setCreateTime(date);
        articleDTO.setCreateUserId(obj.getOperatorId());
        articleDTO.setCreateUserName(obj.getOperatorName());
        articleDTO.setUpdateTime(date);
        articleDTO.setUpdateUserId(obj.getOperatorId());
        articleDTO.setUpdateUserName(obj.getOperatorName());

		return this.articleDTOMapper.insertSelective(articleDTO) > 0;
	}

	@Override
	public boolean update(ArticleReq obj) {
		logger.debug("Updating Article: {}", obj);

		ArticleDTO articleDTO = BeanUtils.copyProperties(obj, ArticleDTO.class);
        articleDTO.setUpdateTime(new Date());
        articleDTO.setUpdateUserId(obj.getOperatorId());
        articleDTO.setUpdateUserName(obj.getOperatorName());
		return this.articleDTOMapper.updateByPrimaryKeySelective(articleDTO) > 0;
	}

	@Override
	public Page<ArticleResp> find(ArticleQuery query) {
		Page<ArticleResp> page = new Page<ArticleResp>(query);
        ArticleDTOExample example = new ArticleDTOExample();
        ArticleDTOExample.Criteria criteria = example.createCriteria();
		if(null != query.getArticleTitle()){
			criteria.andArticleTitleLike("%"+query.getArticleTitle()+"%");
		}if(null != query.getArticleCode()){
			criteria.andArticleCodeLike("%"+query.getArticleCode()+"%");
		}

        criteria.andDeletedEqualTo(Deleted.NORMAL.code());
        example.setOrderByClause("article_id DESC");

        long total = this.articleDTOMapper.countByExample(example);
        page.setTotal(total);
        if (total > query.getOffset()) {
        List<ArticleDTO> list = this.articleDTOMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
            page.setItems(BeanUtils.copyListProperties(list, ArticleResp.class));
        }
        return page;
	}
}
