package com.sudao.cloud.component.user.manager.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sudao.cloud.component.user.manager.exception.ManagerUserException;
import com.sudao.cloud.component.user.manager.platform.base.result.ResultCode;
import com.sudao.framework.controller.BaseRecord;
import com.sudao.framework.core.Handler;
import com.sudao.framework.kit.HttpRenderKit;
import com.sudao.framework.kit.LoggerKit;
import org.springframework.web.util.NestedServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * platform
 * <p>
 * Description :
 * <p>
 * Creator :
 *
 * @author Sudao @ Tim Zhang
 * @email : zhanglong@kuaicto.com or solidsnake2007@gmail.com
 * @date: 2017/10/25
 * @time: 下午4:24
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2017/10/25 下午4:24
 */
public class ManagerUserComponentExceptionHandler extends Handler {
    /******* Fields Area *******/

    /******* Construction Area *******/
    public ManagerUserComponentExceptionHandler() {
    }

    @Override
    public void handle(String s, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        try {
            this.next.handle(s, httpServletRequest, httpServletResponse);
        } catch (NestedServletException e) {
            if (e.getCause() instanceof ManagerUserException) {
                ManagerUserException ex = (ManagerUserException) e.getCause();
                ResultCode resultCode = ex.getResultCode();
                BaseRecord baseRecord = new BaseRecord();
                baseRecord.setCode(resultCode.getCode());
                baseRecord.setMessage(resultCode.getMessage());
                HttpRenderKit.flushJson(httpServletResponse, baseRecord);
                LoggerKit.pushResponseData(JSON.toJSONString(baseRecord, SerializerFeature.DisableCircularReferenceDetect));
            }else {
                throw e;
            }
        }
    }
    /******* GetSet Area ******/

    /******* Method Area *******/


}
