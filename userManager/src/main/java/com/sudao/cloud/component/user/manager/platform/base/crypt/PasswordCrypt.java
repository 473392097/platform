package com.sudao.cloud.component.user.manager.platform.base.crypt;

import org.apache.commons.codec.digest.Crypt;
import org.apache.commons.codec.digest.DigestUtils;

public abstract class PasswordCrypt {
    private static final String CRYPT_SALT = "$1$e-garage";

    public static String encrypt(String pwd) {
        String crypt = Crypt.crypt(pwd, CRYPT_SALT);
        return DigestUtils.md5Hex(crypt);
    }
}
