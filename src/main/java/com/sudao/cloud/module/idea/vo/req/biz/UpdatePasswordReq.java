package com.sudao.cloud.module.idea.vo.req.biz;

/**
 * platform
 * <p>
 * Description :
 * <p>
 * Creator :
 *
 * @author Sudao @ Tim Zhang
 * @email : zhanglong@kuaicto.com or solidsnake2007@gmail.com
 * @date: 2017/10/26
 * @time: 上午9:24
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2017/10/26 上午9:24
 */
public class UpdatePasswordReq {
    /******* Fields Area *******/
    private String oldPassword;
    private String newPassword;

    /******* Construction Area *******/
    public UpdatePasswordReq() {
    }
    /******* GetSet Area ******/

    /******* Method Area *******/

    public String getOldPassword() {
        return oldPassword;
    }

    public UpdatePasswordReq setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword == null ? null : oldPassword.trim();
        return this;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public UpdatePasswordReq setNewPassword(String newPassword) {
        this.newPassword = newPassword == null ? null : newPassword.trim();
        return this;
    }
}
