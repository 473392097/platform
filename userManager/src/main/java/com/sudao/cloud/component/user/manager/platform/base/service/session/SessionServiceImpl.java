package com.sudao.cloud.component.user.manager.platform.base.service.session;

import com.sudao.cloud.component.user.manager.service.ManagerUserService;
import com.sudao.cloud.component.user.manager.service.MenuService;
import com.sudao.cloud.component.user.manager.platform.base.core.Session;
import com.sudao.cloud.component.user.manager.platform.base.crypt.AuthToken;
import com.sudao.cloud.component.user.manager.platform.base.service.BaseServiceImpl;
import com.sudao.cloud.component.user.manager.platform.base.service.redis.RedisService;
import com.sudao.cloud.component.user.manager.platform.enums.Deleted;
import com.sudao.cloud.component.user.manager.platform.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SessionServiceImpl extends BaseServiceImpl implements SessionService {


    @Autowired
    private ManagerUserService managerUserService ;

    @Autowired
    private MenuService menuService;



    @Override
    public void createSession(AuthToken authToken) throws Exception {

    }

    @Override
    public void createSession(AuthToken authToken, Integer cycle) throws Exception {

    }

    @Override
    public void deleteSession(AuthToken authToken) {

    }

    @Override
    public Session getSession(AuthToken authToken) {
        if (authToken == null) {
            return anonymousSession;
        }
        return getAdminSession(authToken);
    }

    @Override
    public boolean isSessionActive(AuthToken authToken) throws Exception {
        return false;
    }

    @Override
    public void resetSessionExpiryTime(AuthToken authToken) throws Exception {

    }

    @Override
    public void resetSessionExpiryTime(AuthToken authToken, Integer cycle) throws Exception {

    }

    @Autowired
    protected RedisService redisService;
//    @Autowired
//    protected ManagerUserService managerUserService;
//    @Autowired
//    private PortalUserService portalUserService;


    protected static final Session anonymousSession = new Session() {

        @Override
        public Long getUserId() {
            return null;
        }

        @Override
        public String getLoginName() {
            return null;
        }

        @Override
        public Map<String,Object> getPermissions() {
            return new HashMap<>();
        }


    };

    private final Session getAdminSession(final AuthToken authToken) {

//        if (authToken == null || this.isSessionInactive(authToken)) {
//            return anonymousSession;
//        }

        final Long userId = authToken.userId;

//        this.resetSessionExpiryTime(authToken);

        final ManagerUserService.ManagerUser user = managerUserService.getById(userId);
        if (user.getDeleted() != Deleted.NORMAL || user.getStatus() != Status.ACTIVATE) {
            logger.warn("userStatus is not available,{}", user);
            return anonymousSession;
        }

        return new Session() {
            @Override
            public Long getUserId() {
                return userId;
            }

            @Override
            public String getLoginName() {
                return user.getLoginName();
            }

            @Override
            public Map<String,Object> getPermissions() {
                return menuService.findPermissionsByUserId(userId);
            }

        };
    }

}
