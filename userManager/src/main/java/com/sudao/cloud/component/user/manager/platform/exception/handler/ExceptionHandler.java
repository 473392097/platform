package com.sudao.cloud.component.user.manager.platform.exception.handler;

import com.sudao.framework.controller.BaseRecord;
import com.sudao.framework.core.Handler;
import com.sudao.framework.kit.HttpRenderKit;
import com.sudao.cloud.component.user.manager.platform.exception.base.ManagerException;
import org.springframework.web.util.NestedServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fuqinqin on 2017/7/19.
 */
public class ExceptionHandler extends Handler {
    @Override
    public void handle(String url, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            super.next.handle(url, request, response);
        } catch (NestedServletException ex) {
            if(ex.getCause() instanceof ManagerException){
                ManagerException me = (ManagerException) ex.getCause();
                BaseRecord baseRecord = getRecord(me);
                HttpRenderKit.flushJson(response, baseRecord);
            }else{
                throw ex;
            }
        }
    }

    private BaseRecord getRecord(ManagerException me) {
        BaseRecord baseRecord = new BaseRecord();
        baseRecord.setCode(String.valueOf(me.getCode()));
        baseRecord.setMessage(me.getMessage());

        return baseRecord;
    }

}
