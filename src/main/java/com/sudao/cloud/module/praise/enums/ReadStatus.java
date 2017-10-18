package com.sudao.cloud.module.praise.enums;

public enum ReadStatus {
    PASSED(1, "通过"),
    FAIL_PASS(2, "未通过"),
    ;
    private final int code;
    private final String text;

    ReadStatus(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public int code() {
        return code;
    }

    public String text() {
        return text;
    }
    public static ReadStatus nameOf(String name) {
        try {
            return ReadStatus.valueOf(name);
        } catch(Exception e) {
        }

        return null;
    }

    public static ReadStatus codeOf(int code) {
        if (code < 0) {
            return ReadStatus.FAIL_PASS;
        }

        for (ReadStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }

}
