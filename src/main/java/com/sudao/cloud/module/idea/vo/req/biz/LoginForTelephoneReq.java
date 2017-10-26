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
 * @date: 2017/10/25
 * @time: 下午11:24
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2017/10/25 下午11:24
 */
public class LoginForTelephoneReq {
    /******* Fields Area *******/
    private String telephone;
    private String password;

    /******* Construction Area *******/
    public LoginForTelephoneReq() {
    }
    /******* GetSet Area ******/

    /******* Method Area *******/


    public String getTelephone() {
        return telephone;
    }

    public LoginForTelephoneReq setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginForTelephoneReq setPassword(String password) {
        this.password = password == null ? null : password.trim();
        return this;
    }
}
