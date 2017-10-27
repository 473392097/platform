package com.sudao.cloud.module.idea.service;

import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.dao.page.Pagination;
import com.sudao.cloud.module.base.service.BaseService;
import com.sudao.cloud.module.base.utils.BeanUtils;
import com.sudao.cloud.module.idea.dao.dto.PlanContextDTO;
import com.sudao.cloud.module.idea.dao.dto.PlanContextDTOExample;
import com.sudao.cloud.module.idea.vo.req.PlanContextQuery;
import com.sudao.cloud.module.idea.vo.req.PlanContextReq;
import com.sudao.cloud.module.idea.vo.resp.IdeaResp;
import com.sudao.cloud.module.idea.vo.resp.PlanContextResp;

import java.util.List;

public interface PlanContextService extends BaseService {

    public PlanContextResp getById(Long contextId);

    public boolean create(PlanContextReq obj);

    public boolean update(PlanContextReq obj);

    public Page<PlanContextResp> find(PlanContextQuery query);

    public Page<PlanContextResp> findByExample(PlanContextDTOExample example, Pagination pagination);

    public List<PlanContextResp> findByExample(PlanContextDTOExample example);
}
