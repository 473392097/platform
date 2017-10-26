package com.sudao.cloud.module.idea.service;

import com.sudao.cloud.component.user.manager.exception.ManagerUserException;
import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.service.BaseService;
import com.sudao.cloud.module.idea.vo.req.UserQuery;
import com.sudao.cloud.module.idea.vo.req.UserReq;
import com.sudao.cloud.module.idea.vo.req.biz.LoginForTelephoneReq;
import com.sudao.cloud.module.idea.vo.req.biz.UpdatePasswordReq;
import com.sudao.cloud.module.idea.vo.req.biz.UserRegistryReq;
import com.sudao.cloud.module.idea.vo.resp.UserResp;

public interface UserService extends BaseService {

    public UserResp getById(Long id);

    public boolean create(UserReq obj);

    public boolean update(UserReq obj);

    public Page<UserResp> find(UserQuery query);

    public UserResp getByTelephone(String telephone);


    UserResp login(LoginForTelephoneReq param) throws ManagerUserException;

    void registry(UserRegistryReq param) throws ManagerUserException;

    public void updatePassword(Long userId, UpdatePasswordReq param) throws ManagerUserException;
}
