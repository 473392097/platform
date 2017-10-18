package com.sudao.cloud.module.base.config;

public enum ResultCode {
    // Use standard HTTP status code
    CREATE_FAIL("101", "create fail"),
    UPDATE_FAIL("102", "create fail"),

    OK("200", "OK"),
    CREATED("201", "Created"),

    BAD_REQUEST("400", "Bad Request"),
    UNAUTHORIZED("401", "Unauthorized"),
    FORBIDDEN("403", "Forbidden"),
    NOT_FOUND("404", "Not Found"),
    CONFLICT("409", "Conflict"),

    NULL_PARAMETERS("1001", "参数为空"),
    ID_CODE_EXISTS("1002", "ID已执行"),
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
}
