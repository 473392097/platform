package com.sudao.cloud.module.praise.enums;

public enum ActionType {
    PRAISE(1, "点赞"),
    CANCEL_PRAISE(2, "取消点赞"),
    ADD_COLLECT(3, "添加收藏"),
    CANCEL_COLLECT(4, "取消收藏"),
    ;
    private final int code;
    private final String text;

    ActionType(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public int code() {
        return code;
    }

    public String text() {
        return text;
    }
    public static ActionType nameOf(String name) {
        try {
            return ActionType.valueOf(name);
        } catch(Exception e) {
        }

        return null;
    }

    public static ActionType codeOf(int code) {
        if (code < 0) {
            return ActionType.CANCEL_PRAISE;
        }

        for (ActionType value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }

}
