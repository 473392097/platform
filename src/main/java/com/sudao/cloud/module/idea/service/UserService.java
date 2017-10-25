package com.sudao.cloud.module.idea.service;

import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.service.BaseService;
import com.sudao.cloud.module.idea.vo.req.UserQuery;
import com.sudao.cloud.module.idea.vo.req.UserReq;
import com.sudao.cloud.module.idea.vo.resp.UserResp;

public interface UserService extends BaseService {

    public UserResp getById(Long id);

    public boolean create(UserReq obj);

    public boolean update(UserReq obj);

    public Page<UserResp> find(UserQuery query);
}
