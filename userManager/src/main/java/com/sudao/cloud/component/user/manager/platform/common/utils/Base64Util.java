package com.sudao.cloud.component.user.manager.platform.common.utils;

import org.apache.commons.codec.binary.Base64;

/**
 * Created by Administrator on 2017/7/4.
 */
public class Base64Util {
    /**
     * 加密
     *
     * @param key
     * @return
     */
    public static String encrypt(String key) {
        byte[] ec = Base64.encodeBase64(key.getBytes(), true);
        String ec_result = new String(ec).replaceAll("\r|\n", "");
        return ec_result;
    }

    /**
     * 解密
     *
     * @param key
     * @return
     */
    public static String decode(String key) {
        byte[] dc = Base64.decodeBase64(key.getBytes());
        String dc_result = new String(dc).replaceAll("\r|\n", "");
        return dc_result;
    }
}
