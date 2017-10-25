package com.sudao.cloud.module.idea.service;

import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.service.BaseService;
import com.sudao.cloud.module.idea.vo.req.InformationQuery;
import com.sudao.cloud.module.idea.vo.req.InformationReq;
import com.sudao.cloud.module.idea.vo.resp.InformationResp;

public interface InformationService extends BaseService {

    public InformationResp getById(Long id);

    public boolean create(InformationReq obj);

    public boolean update(InformationReq obj);

    public Page<InformationResp> find(InformationQuery query);
}
