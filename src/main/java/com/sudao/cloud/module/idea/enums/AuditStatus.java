package com.sudao.cloud.module.idea.enums;

public enum AuditStatus {
    PASSED(1, "通过"),
    FAIL_PASS(2, "未通过"),
    ;
    private final int code;
    private final String text;

    AuditStatus(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public int code() {
        return code;
    }

    public String text() {
        return text;
    }
    public static AuditStatus nameOf(String name) {
        try {
            return AuditStatus.valueOf(name);
        } catch(Exception e) {
        }

        return null;
    }

    public static AuditStatus codeOf(int code) {
        if (code < 0) {
            return AuditStatus.FAIL_PASS;
        }

        for (AuditStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }

}
