package com.sudao.cloud.module.category.service;

import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.service.BaseService;
import com.sudao.cloud.module.category.vo.req.CategoryQuery;
import com.sudao.cloud.module.category.vo.req.CategoryReq;
import com.sudao.cloud.module.category.vo.resp.CategoryResp;

public interface CategoryService extends BaseService {

    public CategoryResp getById(Long categoryId);

    public boolean create(CategoryReq obj);

    public boolean update(CategoryReq obj);

    public Page<CategoryResp> find(CategoryQuery query);



    /*public static class CategoryQuery extends Pagination {
    }
    
    public static class Category extends CategoryDTO {
        private Long operator;

        public Long getOperator() {
            return operator;
        }
        public void setOperator(Long operator) {
            this.operator = operator;
        }
    }*/
}
