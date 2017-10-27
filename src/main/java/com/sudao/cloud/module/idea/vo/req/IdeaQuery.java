package com.sudao.cloud.module.idea.vo.req;

import com.sudao.cloud.module.base.dao.page.Pagination;
import com.sudao.cloud.module.idea.enums.IdeaType;

public class IdeaQuery extends Pagination {
    private Long categoryId;
    private IdeaType ideaType;
    private String keyword;

    public Long getCategoryId() {
        return categoryId;
    }

    public IdeaQuery setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public IdeaType getIdeaType() {
        return ideaType;
    }

    public IdeaQuery setIdeaType(IdeaType ideaType) {
        this.ideaType = ideaType;
        return this;
    }

    public String getKeyword() {
        return keyword;
    }

    public IdeaQuery setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
        return this;
    }
}
