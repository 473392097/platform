package com.sudao.cloud.component.user.manager.platform.common.cons;

/**
 * Created by Administrator on 2017/7/18.
 */
public class Constants {
    public static final String SUCCESS = "1";  //成功
    public static final String ERROR = "0";    //失败
    public static final int FROZEN = 0;        //冻结
    public static final int ACTIVATE = 1;      //激活
    public static final int DELETED = 0;       //删除

    public static final String SESSION = "session";
    public static final String SESSION_AUTH_TOKEN = "session_authToken";
    public static final String SESSION_USER_ID = "userId";
    public static final String SESSION_USER_TYPE = "userType";

    public static final int DEFAULT_PAGE_OFFSET = 0;
    public static final int DEFAULT_PAGE_LIMIT = 15;

    /**
     * AuthToken 活跃时间（即自动续期最大间隔）（24小时）
     */
    public static final int AUTH_TOKEN_AGE_ACTIVE = 24 * 3600;
    /**
     * AuthToken 最长过期时间（2周）
     */
    public static final int AUTH_TOKEN_AGE_MAX = 14 * 24 * 3600;
    /**
     * APP AuthToken 最长过期时间（1年）
     */
    public static final int APP_AUTH_TOKEN_AGE_MAX = 365 * 24 * 3600;
    public static final String AUTH_TOKEN_NAME = "_MCH_AT";

    /**
     * token默认名称
     */
    public static final String AUTH_TOKEN_NAME_DEFAULT = "token";

    /**
     * 默认session活跃时间(半小时)
     * */
    public static final int DEFAULT_SESSION_ACTIVE = 30 * 60;


    public static final String EXPLORER_SESSION = "explorer_session";
    public static final String EXPLORER_SESSION_USER_ID = "explorer_userId";
    public static final String EXPLORER_SESSION_USER_TYPE = "explorer_userType";

    /**
     * ClientUser AuthToken 最长保留时间(一个月)
     * */
    public static final int REMENBER_AUTH_TOKEN_AGE = 30 * 24 * 3600;

    /**
     * 默认编码格式
     */
    public static final String UTF8 = "UTF-8";

    public static final int ONE_HOUR_TIME = 60 * 60;

    public static class UserType{
        /**
         * 平台用户
         * */
        public static final Long ADMIN = 0L;

        /**
         * 客户端用户
         * */
        public static final Long CLIENT = 1L;
    }

    /**
     * verify code id
     * */
    public static final String VERIFY_CODE_ID  = "$verifyCodeId";

    /**
     * 验证码过期时间(十分钟)
     * */
    public static final int VERIFY_CODE_ID_ACTIVE = 60 * 10;

    /**
     * 邮件有效时间(24小时)
     * */
    public static final int EMAIL_ACTIVE = 60 * 60 * 24;

    /**
     * 平台编码
     * */
    public static final String BASE_ENCODE = "UTF-8";
}
