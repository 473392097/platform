package com.sudao.cloud.component.user.manager.platform.base.crypt;

import com.sudao.cloud.component.user.manager.platform.exception.EncryptException;

public class AuthToken {

    private static class TokenKeys {
        private static final String[] keys = { "86af68d63bb3c1804de1824afd605", "20542037ab4FZHTsNSnyyLwt51n" };

        public static String[] get() {
            return keys;
        }
    }

    private static final String SEPARATOR = ",";

    private static final TokenEncryption TOKEN_ENCRYPTION = new TokenEncryption(TokenKeys.get());

    public final long userId;
    public final long type;
    public final String rand;
    public boolean remember = false;

    
	/**
     * @param rand 随机数
     * @param userId 用户id
     * @param type 用户类型(0-平台用户， 1-客户端)
     */
    public AuthToken(long userId, long type, String rand, boolean remember) {
        super();
        this.userId = userId;
        this.type = type;
        this.rand = rand;
        this.remember = remember;
    }

    /**
     * Create the token string.
     * 
     * @return encrypted string
     * @throws EncryptException
     */
    public String token() throws EncryptException {
        String unencrypted = new StringBuilder()
                .append(this.userId).append(SEPARATOR)
                .append(this.type).append(SEPARATOR)
                .append(this.rand).append(SEPARATOR)
                .append(this.remember)
                .toString();
        String token = TOKEN_ENCRYPTION.encrypt(unencrypted);
        return token;
    }

    /*public static boolean isActive(AuthToken authToken) {
        long now = System.currentTimeMillis();
        return authToken != null && now > authToken.active && now < authToken.expiry;
    }*/

    /*public static boolean isActive(String token) throws EncryptException {
        return isActive(parse(token));
    }*/

    public static AuthToken parse(String token) throws EncryptException {
        String decrypt = TOKEN_ENCRYPTION.decrypt(token);
        String[] arr = decrypt.split(SEPARATOR);
        if (arr != null && arr.length == 4) {
            int idx = 0;
            long userId = Long.valueOf(arr[idx++]);
            long type = Long.valueOf(arr[idx++]);
//            long active = Long.valueOf(arr[idx++]);
//            long expiry = Long.valueOf(arr[idx++]);
            String rand = arr[idx++];
            boolean remenber = Boolean.parseBoolean(arr[idx++]);

//            return new AuthToken(userId, type, active, expiry, rand);

            return new AuthToken(userId, type, rand, remenber);
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AuthToken [userId=")
                .append(userId)
                .append(", rand=")
                .append(rand)
                .append(", remenber=")
                .append(remember)
                .append("]");
        return builder.toString();
    }
    
    public static void main(String[] args) {

        String unencrypted = new StringBuilder()
                .append(1001L).append(SEPARATOR)
                .append(2L).append(SEPARATOR)
                .append("rand").append(SEPARATOR)
                .append("true")
                .toString();
        String token = TOKEN_ENCRYPTION.encrypt(unencrypted);
        System.out.println(token);
	}
}
