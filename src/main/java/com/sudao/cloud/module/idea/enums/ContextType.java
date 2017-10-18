package com.sudao.cloud.module.idea.enums;

import com.sudao.cloud.module.base.config.enums.Status;

public enum ContextType {
    IMAGE(1, "图片"),
    TEXT(2, "文本"),
    GRAFFTI(3, "涂鸦"),
    VIDEO(4, "视频"),
    ;
    private final int code;
    private final String text;

    private ContextType(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public int code() {
        return code;
    }

    public String text() {
        return text;
    }
    public static ContextType nameOf(String name) {
        try {
            return ContextType.valueOf(name);
        } catch(Exception e) {
        }

        return null;
    }

    public static ContextType codeOf(int code) {
        if (code < 0) {
            return ContextType.IMAGE;
        }

        for (ContextType value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }

}
