package com.sudao.cloud.module.idea.enums;

public enum ProcessStatus {
    PASSED(1, "通过"),
    FAIL_PASS(2, "未通过"),
    ;
    private final int code;
    private final String text;

    ProcessStatus(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public int code() {
        return code;
    }

    public String text() {
        return text;
    }
    public static ProcessStatus nameOf(String name) {
        try {
            return ProcessStatus.valueOf(name);
        } catch(Exception e) {
        }

        return null;
    }

    public static ProcessStatus codeOf(int code) {
        if (code < 0) {
            return ProcessStatus.FAIL_PASS;
        }

        for (ProcessStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }

}
