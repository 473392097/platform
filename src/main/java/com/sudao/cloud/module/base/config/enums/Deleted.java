package com.sudao.cloud.module.base.config.enums;

public enum Deleted {
    DELETED(-1, "已删除"),
    NORMAL(1, "正常"),
    ;
    private final int code;
    private final String text;

    private Deleted(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public int code() {
        return code;
    }

    public String text() {
        return text;
    }
    public static Deleted nameOf(String name) {
        try {
            return Deleted.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static Deleted codeOf(int code) {
        if (code < 0) {
            return Deleted.DELETED;
        }
        
        for (Deleted value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
