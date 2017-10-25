package com.sudao.cloud.module.idea.enums;

/**
 * platform
 * <p>
 * Description :
 * <p>
 * Creator :
 *
 * @author Sudao @ Tim Zhang
 * @email : zhanglong@kuaicto.com or solidsnake2007@gmail.com
 * @date: 2017/10/25
 * @time: 下午10:20
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2017/10/25 下午10:20
 */
public enum EnumInformationType {
    IMAGE(1, "图片"),
    TEXT(2, "文本"),
    GRAFFTI(3, "涂鸦"),
    VIDEO(4, "视频"),
    ;
    private final int code;
    private final String text;

    private EnumInformationType(int code, String text) {
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

    public static EnumInformationType codeOf(int code) {
        if (code < 0) {
            return EnumInformationType.IMAGE;
        }

        for (EnumInformationType value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }


}
