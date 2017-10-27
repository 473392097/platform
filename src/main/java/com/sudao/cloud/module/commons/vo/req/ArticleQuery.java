package com.sudao.cloud.module.commons.vo.req;

import com.sudao.cloud.module.base.dao.page.Pagination;

public class ArticleQuery extends Pagination {
    private String articleTitle ;
    private String articleCode ;

    public String getArticleTitle() {
        return articleTitle;
    }

    public ArticleQuery setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
        return this;
    }

    public String getArticleCode() {
        return articleCode;
    }

    public ArticleQuery setArticleCode(String articleCode) {
        this.articleCode = articleCode;
        return this;
    }
}
