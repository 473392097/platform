package com.sudao.cloud.component.user.manager.core;

import com.sudao.cloud.component.user.manager.platform.base.core.Session;
import com.sudao.cloud.component.user.manager.platform.base.core.SessionAware;
import com.sudao.cloud.component.user.manager.platform.base.crypt.AuthToken;
import com.sudao.cloud.component.user.manager.platform.base.service.redis.RedisService;
import com.sudao.cloud.component.user.manager.platform.base.service.session.SessionService;
import com.sudao.cloud.component.user.manager.platform.common.cons.Constants;
import com.sudao.cloud.component.user.manager.platform.common.utils.TokenUtils;
import com.sudao.cloud.component.user.manager.platform.exception.UnauthorizeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * platform
 * <p>
 * Description :
 * <p>
 * Creator :
 * @author Sudao @ Tim Zhang
 * Email : zhanglong@kuaicto.com or solidsnake2007@gmail.com
 * Date: 2017/10/25
 * Time: 上午11:29
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2017/10/25 上午11:29
 */
@Component
public class SessionTokenResolver implements SessionAware {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    /******* Fields Area *******/
    private RedisService redisService;
    private SessionService sessionService;

    /******* Construction Area *******/
    public SessionTokenResolver(@Autowired SessionService sessionService,
                                @Autowired RedisService redisService) {
        this.sessionService = sessionService;
        this.redisService = redisService;
    }
    /******* GetSet Area ******/

    /******* Method Area *******/

    public Session getSessionQuietly(HttpServletRequest request) {
        Session session = (Session) request.getAttribute(Constants.SESSION);
        if (session == null) {
            session = this.sessionService.getSession(getSessionAuthToken(request));
            request.setAttribute(Constants.SESSION, session);
        }
        return session;
    }

    @Override
    public Session getSession(HttpServletRequest request) {
        Session session = getSessionQuietly(request);

        if (session == null || session.getUserId() == null || session.getUserId() == 0) {
            Integer userId = (Integer) request.getAttribute(Constants.SESSION_USER_ID);
            throw new UnauthorizeException("session inactive, userId: " + userId);
        }
        return session;
    }

    @Override
    public boolean clearSession(HttpServletRequest request) {
        //clear session
        String tokenString = TokenUtils.getTokenString(request);
        AuthToken authToken = null;
        try {
            authToken = AuthToken.parse(tokenString);
        } catch (Exception e) {
            logger.error("Failed decrypt token: {}, exception: {}", tokenString, e.getMessage());
            return false;
        }

        sessionService.deleteSession(authToken);
        return true;
    }

    private AuthToken getSessionAuthToken(HttpServletRequest request) {
        AuthToken authToken = (AuthToken) request.getAttribute(Constants.SESSION_AUTH_TOKEN);
        return authToken;
    }


}
