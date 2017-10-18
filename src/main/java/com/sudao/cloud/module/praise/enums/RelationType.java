package com.sudao.cloud.module.praise.enums;

public enum RelationType {
    IDEA(1, "创意");
    private final int code;
    private final String text;

    RelationType(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public int code() {
        return code;
    }

    public String text() {
        return text;
    }
    public static RelationType nameOf(String name) {
        try {
            return RelationType.valueOf(name);
        } catch(Exception e) {
        }

        return null;
    }

    public static RelationType codeOf(int code) {
        if (code < 0) {
            return RelationType.IDEA;
        }

        for (RelationType value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }

}
