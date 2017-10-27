package com.sudao.cloud.module.base.exception;

import com.sudao.cloud.module.base.config.ResultCode;
import com.sudao.framework.controller.BaseRecord;
import com.sudao.framework.core.Handler;
import com.sudao.framework.kit.HttpRenderKit;
import org.springframework.web.util.NestedServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hao.ch on 2017/10/26.
 */
public class KaizaoExceptionHandler extends Handler {
    @Override
    public void handle(String s, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        try {
            this.next.handle(s, httpServletRequest, httpServletResponse);
        }catch (NestedServletException e) {
            if(e.getCause() instanceof KaizaoException) {
                KaizaoException ex = (KaizaoException)e.getCause();
                ResultCode resultCode = ex.getResultCode();
                BaseRecord baseRecord = new BaseRecord();
                baseRecord.setCode(resultCode.getCode());
                baseRecord.setMessage(resultCode.getMessage());
                HttpRenderKit.flushJson(httpServletResponse, baseRecord);
            }else {
                throw e;
            }
        }
    }
}
