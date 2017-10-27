package com.sudao.cloud.module.commons.service;

import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.service.BaseService;
import com.sudao.cloud.module.commons.vo.req.ArticleQuery;
import com.sudao.cloud.module.commons.vo.req.ArticleReq;
import com.sudao.cloud.module.commons.vo.resp.ArticleResp;

public interface ArticleService extends BaseService {

    public ArticleResp getById(Long article_id);

    public boolean create(ArticleReq obj);

    public boolean update(ArticleReq obj);

    public Page<ArticleResp> find(ArticleQuery query);
}
