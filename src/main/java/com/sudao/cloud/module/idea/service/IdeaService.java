package com.sudao.cloud.module.idea.service;

import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.service.BaseService;
import com.sudao.cloud.module.idea.vo.req.IdeaQuery;
import com.sudao.cloud.module.idea.vo.req.IdeaReq;
import com.sudao.cloud.module.idea.vo.resp.IdeaResp;

public interface IdeaService extends BaseService {

    public IdeaResp getById(Long ideaId);

    public boolean create(IdeaReq obj);

    public boolean update(IdeaReq obj);

    public Page<IdeaResp> find(IdeaQuery query);
}
