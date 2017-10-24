package com.sudao.cloud.component.user.manager.platform.common.utils;

import com.sudao.cloud.component.user.manager.platform.common.cons.Constants;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by fuqinqin on 2017/8/2.
 */
public class TokenUtils {
    public static final Logger logger = LoggerFactory.getLogger(TokenUtils.class);

    /**
     *获取客户端的token，优先级：header > cookie > queryParamter
     * */
    public static String getTokenString(HttpServletRequest httpRequest) {
        String tokenString = null;

        // from header
        if (StringUtils.isBlank(tokenString)) {
            tokenString = httpRequest.getHeader(Constants.AUTH_TOKEN_NAME_DEFAULT);
        }

        // from cookie
        if (StringUtils.isBlank(tokenString) && httpRequest.getCookies() != null) {
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

        // from querystring
        if (StringUtils.isBlank(tokenString)) {
            tokenString = httpRequest.getParameter(Constants.AUTH_TOKEN_NAME_DEFAULT);
        }

        logger.info("token={}", tokenString);
        return tokenString;
    }
}
