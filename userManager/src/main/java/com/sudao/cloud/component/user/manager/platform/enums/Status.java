package com.sudao.cloud.component.user.manager.platform.enums;

import com.sudao.cloud.component.user.manager.platform.enums.base.EnumType;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by fuqinqin on 2017/7/21.
 */
public enum Status implements EnumType {
    FREEZE(0, "冻结"),
    ACTIVATE(1, "激活"),
    ;

    private Status(Integer code, String text){
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

    public static Status codeOf(Integer code) {
        for (Status status : Status.values()) {
            if (status.code.equals(code)) {
                return status;
            }
        }
        return null;
    }

    public static Status nameOf(String name){
        if(StringUtils.isBlank(name)){
            return null;
        }

        try{
            return Status.valueOf(name);
        }catch(Exception ex){

        }

        return null;
    }

    public boolean equals(Status status){
        if(status == null){
            return false;
        }

        if(!this.toString().equals(status.toString())){
            return false;
        }

        return true;
    }

}
