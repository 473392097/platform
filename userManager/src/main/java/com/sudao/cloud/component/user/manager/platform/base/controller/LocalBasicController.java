package com.sudao.cloud.component.user.manager.platform.base.controller;

import com.sudao.framework.controller.BasicController;
import com.sudao.cloud.component.user.manager.platform.base.core.Session;
import com.sudao.cloud.component.user.manager.platform.base.core.SessionAware;
import com.sudao.cloud.component.user.manager.platform.base.crypt.AuthToken;
import com.sudao.cloud.component.user.manager.platform.base.crypt.TokenEncryption;
import com.sudao.cloud.component.user.manager.platform.base.crypt.TokenKeys;
import com.sudao.cloud.component.user.manager.platform.base.result.ResultCode;
import com.sudao.cloud.component.user.manager.platform.base.service.redis.RedisService;
import com.sudao.cloud.component.user.manager.platform.base.service.session.SessionService;
import com.sudao.cloud.component.user.manager.platform.common.cons.Constants;
import com.sudao.cloud.component.user.manager.platform.common.utils.CookieUtils;
import com.sudao.cloud.component.user.manager.platform.common.utils.MapHelper;
import com.sudao.cloud.component.user.manager.platform.common.utils.TokenUtils;
import com.sudao.cloud.component.user.manager.platform.exception.UnauthorizeException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;

/**
 * Created by fuqinqin on 2017/7/24.
 */
public class LocalBasicController extends BasicController implements SessionAware {
    private static final String CODE = "code";
    private static final String MESSAGE = "message";

    @Autowired
    protected SessionService sessionService;
    @Autowired
    protected RedisService redisService;
    protected static final TokenEncryption TOKEN_ENCRYPTION = new TokenEncryption(TokenKeys.get());

    protected SessionService getSessionService() {
        return this.sessionService;
    }

    public Session getSessionQuietly() {
        Session session = (Session)request.getAttribute(Constants.SESSION);
        if (session == null) {
            session = this.getSessionService().getSession(getSessionAuthToken());
            request.setAttribute(Constants.SESSION, session);
        }
        return session;
    }

    @Override
    public Session getSession() {
        Session session = getSessionQuietly();

        if (session == null || session.getUserId() == null || session.getUserId() == 0) {
            Integer userId = (Integer) request.getAttribute(Constants.SESSION_USER_ID);
            throw new UnauthorizeException("session inactive, userId: " + userId);
        }
        return session;
    }

    @Override
    public boolean clearSession() {
        //clear session
        String tokenString = TokenUtils.getTokenString(this.getRequest());
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
    private AuthToken getSessionAuthToken() {
        AuthToken authToken = (AuthToken) this.request.getAttribute(Constants.SESSION_AUTH_TOKEN);
        return authToken;
    }

    protected static byte[] readStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        while((len = inStream.read(buffer)) != -1){
            outStream.write(buffer, 0, len);
        }
        outStream.close();
        inStream.close();
        return outStream.toByteArray();
    }

    /**
     * 获取返回map
     * */
    protected Map<String, Object> resultMap(ResultCode resultCode){
        return resultMap(resultCode, null);
    }

    protected Map<String, Object> resultMap(ResultCode resultCode, Object... objects){
        Map<String, Object> resultMap = new MapHelper.MapBuilder<String, Object>().getMap();
        resultMap.put(CODE, resultCode.getCode());
        resultMap.put(MESSAGE, resultCode.getMessage());

        if(objects != null){
            if(objects.length%2 == 0){
                for(int i=0;i<objects.length;i+=2){
                    Object key = objects[i];
                    Object value = objects[i+1];

                    if(!(key instanceof String)){
                        continue;
                    }

                    resultMap.put((String) key, value);
                }
            }
        }

        return resultMap;
    }
    protected void setCookie(String name, String value, String path, String domain, Integer cycle){
        Cookie cookie = new Cookie(name, value);

        if(StringUtils.isBlank(path)){
            cookie.setPath("/");
        }else{
            cookie.setPath(path);
        }

        if (StringUtils.isNotBlank(domain)) {
            cookie.setDomain(domain);
        } else {
            String sysDomain = CookieUtils.getCookieDomain();
            if(StringUtils.isNotBlank(sysDomain)){
                cookie.setDomain(sysDomain);
            }
        }

        if(cycle != null){
            cookie.setMaxAge(cycle);
        }

        this.getResponse().addCookie(cookie);
    }

    /**
     * 验证码校验
     * */
    protected boolean verifyCode(String verifyCode){
        String verifyCodeId = getVerifyCodeId();
        if(StringUtils.isBlank(verifyCodeId)){
            return false;
        }
        verifyCodeId = TOKEN_ENCRYPTION.decrypt(verifyCodeId);

//        String $verifyCode = redisService.get(buildVerifyCodeKey(verifyCodeId));
//        if(StringUtils.isEmpty($verifyCode)){
//            return false;
//        }
//
//        if(!$verifyCode.equalsIgnoreCase(verifyCode)){
//            return false;
//        }

        //clear verify code id from redis
//        redisService.del(buildVerifyCodeKey(verifyCodeId));

        return true;
    }

    /**
     * 从cookie中获取验证码唯一标示
     * */
    protected String getVerifyCodeId() {
        String randomKey = null;

        if (this.getRequest().getCookies() != null) {
            for (Cookie c : this.getRequest().getCookies()) {
                if (Constants.VERIFY_CODE_ID.equals(c.getName())) {
                    randomKey = c.getValue();
                    break;
                }
            }
        }

        return randomKey;
    }

    /**
     * 构建图形验证码在reids中的key
     * */
    protected String buildVerifyCodeKey(String randomKey){
        return "$verifyCode-" + randomKey;
    }

    /**
     * 清除资源
     * */
    protected void clearResource(String key){
        if(StringUtils.isBlank(key))
            return;
//        redisService.del(key);
    }

}
