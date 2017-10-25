package com.sudao.cloud.component.user.manager.exception;

import com.sudao.cloud.component.user.manager.platform.base.result.ResultCode;

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
 * @time: 下午4:23
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2017/10/25 下午4:23
 */
public class ManagerUserException extends Exception {
    /******* Fields Area *******/

    private ResultCode resultCode;

    /******* Construction Area *******/
    public ManagerUserException() {
    }

    public ManagerUserException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
    /******* GetSet Area ******/
    public ResultCode getResultCode() {
        return resultCode;
    }

    public ManagerUserException setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    /******* Method Area *******/


}
