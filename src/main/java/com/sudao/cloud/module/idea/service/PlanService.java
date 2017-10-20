package com.sudao.cloud.module.idea.service;

import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.service.BaseService;
import com.sudao.cloud.module.idea.vo.req.PlanQuery;
import com.sudao.cloud.module.idea.vo.req.PlanReq;
import com.sudao.cloud.module.idea.vo.resp.PlanResp;

public interface PlanService extends BaseService {

    public PlanResp getById(Long planId);

    public boolean create(PlanReq obj);

    public boolean update(PlanReq obj);

    public Page<PlanResp> find(PlanQuery query);
}
