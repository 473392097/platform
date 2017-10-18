package com.sudao.cloud.module.idea.service;

import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.service.BaseService;
import com.sudao.cloud.module.idea.vo.req.PlanContextQuery;
import com.sudao.cloud.module.idea.vo.req.PlanContextReq;
import com.sudao.cloud.module.idea.vo.resp.PlanContextResp;

public interface PlanContextService extends BaseService {

    public PlanContextResp getById(Long contextId);

    public boolean create(PlanContextReq obj);

    public boolean update(PlanContextReq obj);

    public Page<PlanContextResp> find(PlanContextQuery query);



    /*public static class PlanContextQuery extends Pagination {
    }
    
    public static class PlanContext extends PlanContextDTO {
        private Long operator;

        public Long getOperator() {
            return operator;
        }
        public void setOperator(Long operator) {
            this.operator = operator;
        }
    }*/
}
