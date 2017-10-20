package com.sudao.cloud.module.idea.service;

import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.service.BaseService;
import com.sudao.cloud.module.idea.vo.req.UserIdeaStatisticsQuery;
import com.sudao.cloud.module.idea.vo.req.UserIdeaStatisticsReq;
import com.sudao.cloud.module.idea.vo.resp.UserIdeaStatisticsResp;

public interface UserIdeaStatisticsService extends BaseService {

    public UserIdeaStatisticsResp getById(Long id);

    public boolean create(UserIdeaStatisticsReq obj);

    public boolean update(UserIdeaStatisticsReq obj);

    public Page<UserIdeaStatisticsResp> find(UserIdeaStatisticsQuery query);
}
