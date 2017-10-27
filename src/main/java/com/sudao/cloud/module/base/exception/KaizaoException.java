package com.sudao.cloud.module.base.exception;

import com.sudao.cloud.module.base.config.ResultCode;
import jodd.http.HttpRequest;

/**
 * Created by hao.ch on 2017/10/26.
 */
public class KaizaoException extends Exception {

    private ResultCode resultCode;

    public KaizaoException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public KaizaoException setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
        return this;
    }
}
