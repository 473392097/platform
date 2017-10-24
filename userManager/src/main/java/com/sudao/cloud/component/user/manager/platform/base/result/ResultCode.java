package com.sudao.cloud.component.user.manager.platform.base.result;

public enum ResultCode {

    // Use standard HTTP status code
    OK("200", "OK"),
    BAD_REQUEST("400", "Bad Request"),
    UNAUTHORIZED("401", "Unauthorized"),
    FORBIDDEN("403", "Forbidden"),
    NOT_FOUND("404", "Not Found"),
    CONFLICT("409", "此账号已注册"),
    NULL_PARAMETER("408", "null parameter"),
    INTERNAL_SERVER_ERROR("500", " Internal Server Error"),

    //------------------business code
    //user

    USER_PASSWORD_ERROR("1101", "密码错误"),
    AUTH_FAILED("1102", "登陆授权失败，手机号或密码错误"),
    ;

    private final String code;
    private final String message;

    private ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static ResultCode codeOf(String code) {
        for (ResultCode value : values()) {
            if (value.code == code)
                return value;
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }
}