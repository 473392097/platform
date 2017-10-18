package com.sudao.cloud.module.catelog.service;

import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.service.BaseService;
import com.sudao.cloud.module.catelog.vo.req.CatelogQuery;
import com.sudao.cloud.module.catelog.vo.req.CatelogReq;
import com.sudao.cloud.module.catelog.vo.resp.CatelogResp;

public interface CatelogService extends BaseService {

    public CatelogResp getById(Long catelogId);

    public boolean create(CatelogReq obj);

    public boolean update(CatelogReq obj);

    public Page<CatelogResp> find(CatelogQuery query);



    /*public static class CatelogQuery extends Pagination {
    }
    
    public static class Catelog extends CatelogDTO {
        private Long operator;

        public Long getOperator() {
            return operator;
        }
        public void setOperator(Long operator) {
            this.operator = operator;
        }
    }*/
}
