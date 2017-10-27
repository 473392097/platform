package com.sudao.cloud.module.idea.service;

import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.dao.page.Pagination;
import com.sudao.cloud.module.base.service.BaseService;
import com.sudao.cloud.module.base.utils.BeanUtils;
import com.sudao.cloud.module.idea.dao.dto.PlanDTO;
import com.sudao.cloud.module.idea.dao.dto.PlanDTOExample;
import com.sudao.cloud.module.idea.vo.req.PlanQuery;
import com.sudao.cloud.module.idea.vo.req.PlanReq;
import com.sudao.cloud.module.idea.vo.resp.PlanResp;

import java.util.List;

public interface PlanService extends BaseService {

    public PlanResp getById(Long planId);

    public boolean create(PlanReq obj);

    public boolean update(PlanReq obj);

    public Page<PlanResp> find(PlanQuery query);

    public Page<PlanResp> findByExample(PlanDTOExample example, Pagination pagination);

    public List<PlanResp> findByExample(PlanDTOExample example);
}
