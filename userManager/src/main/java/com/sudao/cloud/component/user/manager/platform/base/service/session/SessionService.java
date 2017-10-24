package com.sudao.cloud.component.user.manager.platform.base.service.session;

import com.sudao.cloud.component.user.manager.platform.base.core.Session;
import com.sudao.cloud.component.user.manager.platform.base.crypt.AuthToken;
import com.sudao.cloud.component.user.manager.platform.base.service.BaseService;

public interface SessionService extends BaseService {

    void createSession(AuthToken authToken) throws Exception;

    void createSession(AuthToken authToken, Integer cycle) throws Exception;

    /**
     * 清除session
     */
    void deleteSession(AuthToken authToken);

    Session getSession(AuthToken authToken);

    /**
     * 通过token判断session是否有效
     * */
    public boolean isSessionActive(AuthToken authToken) throws Exception;

    /**
     * 重新设定redis中的session生命周期
     * */
    public void resetSessionExpiryTime(AuthToken authToken) throws Exception;
    public void resetSessionExpiryTime(AuthToken authToken, Integer cycle) throws Exception;

}
