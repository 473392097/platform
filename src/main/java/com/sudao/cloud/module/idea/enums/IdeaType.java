package com.sudao.cloud.module.idea.enums;

public enum IdeaType {
    IDEA(1, "创意"),
    PRODUCT_CASE(2, "产品案例"),
    ;
    private final int code;
    private final String text;

    IdeaType(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public int code() {
        return code;
    }

    public String text() {
        return text;
    }
    public static IdeaType nameOf(String name) {
        try {
            return IdeaType.valueOf(name);
        } catch(Exception e) {
        }

        return null;
    }

    public static IdeaType codeOf(int code) {
        if (code < 0) {
            return IdeaType.IDEA;
        }

        for (IdeaType value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }

}
