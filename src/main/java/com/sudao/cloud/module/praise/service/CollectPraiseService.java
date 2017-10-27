package com.sudao.cloud.module.praise.service;

import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.service.BaseService;
import com.sudao.cloud.module.praise.dao.dto.CollectPraiseDTOExample;
import com.sudao.cloud.module.praise.vo.req.CollectPraiseQuery;
import com.sudao.cloud.module.praise.vo.req.CollectPraiseReq;
import com.sudao.cloud.module.praise.vo.resp.CollectPraiseResp;

import java.util.List;

public interface CollectPraiseService extends BaseService {

    public CollectPraiseResp getById(Long id);

    public boolean create(CollectPraiseReq obj);

    public boolean update(CollectPraiseReq obj);

    public Page<CollectPraiseResp> find(CollectPraiseQuery query);

    public List<CollectPraiseResp> findByExample(CollectPraiseDTOExample example);
}
