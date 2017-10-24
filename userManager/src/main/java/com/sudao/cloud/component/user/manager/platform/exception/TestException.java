package com.sudao.cloud.component.user.manager.platform.exception;



import com.sudao.cloud.component.user.manager.platform.enums.base.EnumType;
import com.sudao.cloud.component.user.manager.platform.exception.base.ManagerException;

/**
 * Created by fuqinqin on 2017/7/19.
 */
public class TestException extends ManagerException {
    private Integer code;
    private String message;

    public TestException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public TestException(EnumType enumType){
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
