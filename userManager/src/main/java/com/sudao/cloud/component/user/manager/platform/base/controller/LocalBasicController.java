package com.sudao.cloud.component.user.manager.platform.base.controller;

import com.sudao.cloud.component.user.manager.core.SessionTokenResolver;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    protected SessionTokenResolver sessionTokenResolver;

    protected static final TokenEncryption TOKEN_ENCRYPTION = new TokenEncryption(TokenKeys.get());

    protected static byte[] readStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        outStream.close();
        inStream.close();
        return outStream.toByteArray();
    }

    /**
     * 获取返回map
     */
    protected Map<String, Object> resultMap(ResultCode resultCode) {
        return resultMap(resultCode, null);
    }

    protected Map<String, Object> resultMap(ResultCode resultCode, Object... objects) {
        Map<String, Object> resultMap = new MapHelper.MapBuilder<String, Object>().getMap();
        resultMap.put(CODE, resultCode.getCode());
        resultMap.put(MESSAGE, resultCode.getMessage());

        if (objects != null) {
            if (objects.length % 2 == 0) {
                for (int i = 0; i < objects.length; i += 2) {
                    Object key = objects[i];
                    Object value = objects[i + 1];

                    if (!(key instanceof String)) {
                        continue;
                    }

                    resultMap.put((String) key, value);
                }
            }
        }

        return resultMap;
    }

    public void setCookie(String name, String value, String path, String domain, Integer cycle) {
        this.sessionTokenResolver.setCookie(this.response, name, value, path, domain, cycle);
    }

    @Override
    public Session getSession(HttpServletRequest request) {
        return this.sessionTokenResolver.getSession(request);
    }

    @Override
    public boolean clearSession(HttpServletRequest request) {
        return this.sessionTokenResolver.clearSession(request);
    }

    protected Session getSession() {
        return this.getSession(this.request);
    }

    protected boolean clearSession() {
        return this.clearSession(this.request);
    }
}
