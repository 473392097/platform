package com.sudao.cloud.component.user.manager.platform.base.interceptor;

import com.sudao.framework.controller.BaseRecord;
import com.sudao.framework.controller.BasicController;
import com.sudao.framework.core.Handler;
import com.sudao.framework.core.Handlers;
import com.sudao.framework.core.Interceptor;
import com.sudao.framework.kit.HttpRenderKit;
import com.sudao.cloud.component.user.manager.platform.base.crypt.AuthToken;
import com.sudao.cloud.component.user.manager.platform.base.filters.FilterParamsConfig;
import com.sudao.cloud.component.user.manager.platform.base.result.ResultCode;
import com.sudao.cloud.component.user.manager.platform.common.cons.Constants;
import com.sudao.cloud.component.user.manager.platform.common.utils.CookieUtils;
import com.sudao.cloud.component.user.manager.platform.common.utils.MapHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * session filter
 *
 * @author chen
 * @company sudao
 * @create 2017-08-24 17:03
 **/
public class AuthTokenHandler extends Handler {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String CODE = "code";
    private static final String MESSAGE = "message";
    private List<String> authExcludes;

    public AuthTokenHandler() {
        this.authExcludes = FilterParamsConfig.getInstance().getAuthExcludes();
    }

    @Override
    public void handle(String s, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ThreadContext.put("cookie.domain", httpServletRequest.getServerName());
        if (!isAuthExcludes(httpServletRequest) && !checkAuth(httpServletRequest, httpServletResponse)) {
            BaseRecord record = new BaseRecord();
            Map<String, Object> resultMap = new MapHelper.MapBuilder<String, Object>().getMap();
            resultMap.put(CODE, ResultCode.UNAUTHORIZED.getCode());
            resultMap.put(MESSAGE, ResultCode.UNAUTHORIZED.getMessage());
            record.setData(resultMap);
            HttpRenderKit.flushJson(httpServletResponse, record);

        } else {
            this.next.handle(s, httpServletRequest, httpServletResponse);
        }
    }

    protected boolean checkAuth(HttpServletRequest req, HttpServletResponse resp) {
        // Get token string from cookie
        String tokenString = getTokenString(req);

        if (tokenString == null) {
            logger.warn("Not found authToken in cookie");
            return false;
        }

        // parse AuthToken
        AuthToken authToken = null;
        try {
            authToken = AuthToken.parse(tokenString);
        } catch (Exception e) {
            logger.error("Failed decrypt token: {}, exception: {}", tokenString, e.getMessage());
            clearAuthTokenCookie(resp);
            return false;
        }

        //TODO
//        if (AuthToken.isActive(authToken)) {
        if (authToken != null) {
            setLog4jXUID(String.valueOf(authToken.userId + "-" + authToken.rand));
            // place user info
            req.setAttribute(Constants.SESSION_USER_ID, authToken.userId);
            req.setAttribute(Constants.SESSION_AUTH_TOKEN, authToken);
            return true;
        }

        logger.warn("authToken cookie expired: {}={}", Constants.AUTH_TOKEN_NAME, tokenString);
        clearAuthTokenCookie(resp);
        return false;
    }

    private void clearAuthTokenCookie(HttpServletResponse httpResponse) {
        // clear cookie
        Cookie cookie = new Cookie(Constants.AUTH_TOKEN_NAME, null);
        cookie.setDomain(CookieUtils.getCookieDomain());
        cookie.setPath("/");
        cookie.setMaxAge(0);
        httpResponse.addCookie(cookie);
    }

    protected String getTokenString(HttpServletRequest httpRequest) {
        String tokenString = null;

        // from querystring
        if (StringUtils.isBlank(tokenString)) {
            tokenString = httpRequest.getParameter(Constants.AUTH_TOKEN_NAME_DEFAULT);
        }

        // from header
        if (StringUtils.isBlank(tokenString)) {
            tokenString = httpRequest.getHeader(Constants.AUTH_TOKEN_NAME_DEFAULT);
        }

        // from cookie
        if (httpRequest.getCookies() != null) {
            for (Cookie c : httpRequest.getCookies()) {
                if (Constants.AUTH_TOKEN_NAME.equals(c.getName())) {
                    tokenString = c.getValue();
                    break;
                }
                if (Constants.AUTH_TOKEN_NAME_DEFAULT.equals(c.getName())) {
                    tokenString = c.getValue();
                    break;
                }
            }
        }
        logger.info("token={}", tokenString);
        return tokenString;
    }

    protected void setLog4jXUID(String xuid) {
        // for log4j
        ThreadContext.put("X-UID", xuid);
    }

    private boolean isAuthExcludes(HttpServletRequest httpRequest) {
        String uri = httpRequest.getRequestURI();
        for (String item : this.authExcludes) {
            if (StringUtils.startsWith(uri, item)) {
                return true;
            }
        }
        return false;
    }

}
