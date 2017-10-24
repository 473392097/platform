package com.sudao.cloud.component.user.manager.platform.enums;

import com.sudao.cloud.component.user.manager.platform.enums.base.EnumType;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by fuqinqin on 2017/7/18.
 */
public enum Deleted implements EnumType {
    DELETED(0, "删除"),
    NORMAL(1, "正常"),
    ;

    private Deleted(Integer code, String text){
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

    public static Deleted codeOf(Integer code) {
        for (Deleted deleteStatus : Deleted.values()) {
            if (deleteStatus.code.equals(code)) {
                return deleteStatus;
            }
        }
        return null;
    }

    public static Deleted nameOf(String name){
        if(StringUtils.isBlank(name)){
            return null;
        }

        try{
            return Deleted.valueOf(name);
        }catch(Exception ex){

        }

        return null;
    }

    public boolean equals(Deleted deleted){
        if(deleted == null){
            return false;
        }

        if(!this.toString().equals(deleted.toString())){
            return false;
        }

        return true;
    }
}
