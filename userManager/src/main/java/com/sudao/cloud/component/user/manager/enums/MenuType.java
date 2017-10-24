package com.sudao.cloud.component.user.manager.enums;

import com.sudao.cloud.component.user.manager.platform.enums.base.EnumType;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by fuqinqin on 2017/7/21.
 */
public enum MenuType implements EnumType{
    MENU(0, "菜单"),
    POINT(1, "功能点"),
    ;

    private MenuType(Integer code, String text){
        this.code = code;
        this.text = text;
    }

    private final Integer code;
    private final String text;

    @Override
    public int code() {
        return code;
    }

    @Override
    public String text() {
        return text;
    }

    public static MenuType codeOf(Integer code) {
        for (MenuType status : MenuType.values()) {
            if (status.code.equals(code)) {
                return status;
            }
        }
        return null;
    }

    public static MenuType nameOf(String name){
        if(StringUtils.isBlank(name)){
            return null;
        }

        try{
            return MenuType.valueOf(name);
        }catch(Exception ex){

        }

        return null;
    }

    public boolean equals(MenuType status){
        if(status == null){
            return false;
        }

        if(!this.toString().equals(status.toString())){
            return false;
        }

        return true;
    }

}
