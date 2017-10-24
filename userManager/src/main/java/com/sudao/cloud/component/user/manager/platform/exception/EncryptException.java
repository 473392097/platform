package com.sudao.cloud.component.user.manager.platform.exception;

import com.sudao.cloud.component.user.manager.platform.enums.base.EnumType;
import com.sudao.cloud.component.user.manager.platform.exception.base.ManagerException;

public class EncryptException extends ManagerException {

    private static final long serialVersionUID = -7896887327676105502L;

    private Integer code;
    private String message;

    public EncryptException(Exception ex){
    }

    public EncryptException(String message){
        this.code = -1;
        this.message = message;
    }

    public EncryptException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public EncryptException(EnumType enumType){
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
