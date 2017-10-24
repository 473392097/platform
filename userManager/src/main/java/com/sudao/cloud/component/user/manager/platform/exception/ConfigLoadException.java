package com.sudao.cloud.component.user.manager.platform.exception;


import com.sudao.cloud.component.user.manager.platform.enums.base.EnumType;
import com.sudao.cloud.component.user.manager.platform.exception.base.ManagerException;

public class ConfigLoadException extends ManagerException {

    private static final long serialVersionUID = 272654964421153391L;

    private Integer code;
    private String message;

    public ConfigLoadException(){}

    public ConfigLoadException(String message){
        this.code = -1;
        this.message = message;
    }

    public ConfigLoadException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ConfigLoadException(EnumType enumType){
        this.code = enumType.code();
        this.message = enumType.text();
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
    
}
