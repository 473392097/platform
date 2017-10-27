package com.sudao.cloud.module.commons.service;

import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.service.BaseService;
import com.sudao.cloud.module.commons.vo.req.ReportQuery;
import com.sudao.cloud.module.commons.vo.req.ReportReq;
import com.sudao.cloud.module.commons.vo.resp.ReportResp;

public interface ReportService extends BaseService {

    public ReportResp getById(Long reportId);

    public boolean create(ReportReq obj);

    public boolean update(ReportReq obj);

    public Page<ReportResp> find(ReportQuery query);
}
