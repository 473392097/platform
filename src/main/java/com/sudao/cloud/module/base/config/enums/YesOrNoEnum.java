package com.sudao.cloud.module.base.config.enums;

public enum YesOrNoEnum {
    YES(100, "是"),
    NO(101, "否");

    private final int code;
    private final String text;

    private YesOrNoEnum(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public int code() {
        return code;
    }

    public String text() {
        return text;
    }
    public static YesOrNoEnum nameOf(String name) {
        try {
            return YesOrNoEnum.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static YesOrNoEnum codeOf(int code) {
        if (code < 0) {
            return YesOrNoEnum.NO;
        }
        
        for (YesOrNoEnum value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
