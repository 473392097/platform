package com.sudao.cloud.component.user.manager.platform.exception;

import com.sudao.cloud.component.user.manager.platform.enums.base.EnumType;
import com.sudao.cloud.component.user.manager.platform.exception.base.ManagerException;

public class UnauthorizeException extends ManagerException {
    private static final long serialVersionUID = -5625379607787487107L;

    private Integer code;
    private String message;

    public UnauthorizeException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public UnauthorizeException(EnumType enumType){
        this.code = enumType.code();
        this.message = enumType.text();
    }

    public UnauthorizeException(Exception e) {
        super(e);
    }

    public UnauthorizeException(String msg) {
        super(msg);
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