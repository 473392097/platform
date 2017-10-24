package com.sudao.cloud.component.user.manager.controller;

import com.sudao.cloud.component.user.manager.service.ManagerUserService;
import com.sudao.cloud.component.user.manager.service.ManagerUserService.LoginUser;
import com.sudao.cloud.component.user.manager.service.ManagerUserService.ManagerUser;
import com.sudao.framework.controller.RestPrototypeController;
import com.sudao.cloud.component.user.manager.platform.base.controller.LocalBasicController;
import com.sudao.cloud.component.user.manager.platform.base.crypt.AuthToken;
import com.sudao.cloud.component.user.manager.platform.base.crypt.PasswordCrypt;
import com.sudao.cloud.component.user.manager.platform.base.result.ResultCode;
import com.sudao.cloud.component.user.manager.platform.common.cons.Constants;
import com.sudao.cloud.component.user.manager.platform.common.utils.CookieUtils;
import com.sudao.cloud.component.user.manager.platform.common.utils.RandUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


@RestPrototypeController
@RequestMapping("/cloud/component/user")
public class UserController extends LocalBasicController {

    @Autowired
    private ManagerUserService managerUserService;

    @PostMapping("/login")
    public Map<String, Object> create(@RequestBody final LoginUser loginUser) {

        ManagerUser user = null;
        // login by username
        if (loginUser != null && !StringUtils.isBlank(loginUser.getLoginName())) {
            user = this.managerUserService.getByLoginName(loginUser.getLoginName());
          /*  if (user == null) {
                // 手机号作为username传递
                user = this.userService.getByCellphone(login.getUsername());
            }*/
        }
        if (user == null || ! PasswordCrypt.encrypt(loginUser.getLoginPwd()).equals(user.getPassword())) {
            logger.warn("password incorrect");
            return resultMap(ResultCode.AUTH_FAILED);
        }
        AuthToken authToken = new AuthToken(user.getManagerUserId(), Constants.UserType.ADMIN, RandUtil.rand() ,loginUser.isRemenber());

        setCookie(Constants.AUTH_TOKEN_NAME, authToken.token(), "/", CookieUtils.getCookieDomain(),Constants.AUTH_TOKEN_AGE_MAX);

        return resultMap(ResultCode.OK,Constants.AUTH_TOKEN_NAME_DEFAULT,authToken.token());
    }

    /**
     * 退出
     */
    @GetMapping("/logout")
    public Map<String, Object> logout() {
        this.clearSession();
        setCookie(Constants.AUTH_TOKEN_NAME, "", "/", CookieUtils.getCookieDomain(),0);
        return resultMap(ResultCode.OK);
    }



}
