package com.sudao.cloud.component.user.manager.vo.resp;

import com.sudao.cloud.component.user.manager.service.ManagerUserService;
import com.sudao.cloud.component.user.manager.vo.resp.ManagerUserVo;

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
 * @time: 下午3:59
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2017/10/25 下午3:59
 */
public class LoginResp {
    /******* Fields Area *******/

    private String token;
    private ManagerUserVo.SimpleUserInfo user;
    /******* Construction Area *******/
    public LoginResp() {
    }
    /******* GetSet Area ******/
    public String getToken() {
        return token;
    }

    public LoginResp setToken(String token) {
        this.token = token == null ? null : token.trim();
        return this;
    }

    public ManagerUserVo.SimpleUserInfo getUser() {
        return user;
    }

    public LoginResp setUser(ManagerUserVo.SimpleUserInfo user) {
        this.user = user;
        return this;
    }

    public LoginResp setUser(ManagerUserService.ManagerUser user) {
        return this.setUser(ManagerUserVo.SimpleUserInfo.parse(user));
    }
    /******* Method Area *******/


}
