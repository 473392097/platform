package com.sudao.cloud.module.commons.controller;

import com.sudao.cloud.component.user.manager.exception.ManagerUserException;
import com.sudao.cloud.component.user.manager.platform.base.crypt.AuthToken;
import com.sudao.cloud.component.user.manager.platform.common.cons.Constants;
import com.sudao.cloud.component.user.manager.platform.common.utils.BeanUtils;
import com.sudao.cloud.component.user.manager.platform.common.utils.CookieUtils;
import com.sudao.cloud.component.user.manager.platform.common.utils.RandUtil;
import com.sudao.cloud.component.user.manager.vo.resp.LoginResp;
import com.sudao.cloud.component.user.manager.vo.resp.ManagerUserVo;
import com.sudao.cloud.module.base.config.ResultCode;
import com.sudao.cloud.module.base.config.enums.Deleted;
import com.sudao.cloud.module.base.controller.LocalBasicController;
import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.commons.service.UserService;
import com.sudao.cloud.module.commons.vo.req.UserQuery;
import com.sudao.cloud.module.commons.vo.req.UserReq;
import com.sudao.cloud.module.idea.vo.req.biz.LoginForTelephoneReq;
import com.sudao.cloud.module.idea.vo.req.biz.UpdatePasswordReq;
import com.sudao.cloud.module.idea.vo.req.biz.UserRegistryReq;
import com.sudao.cloud.module.commons.vo.resp.UserResp;
import com.sudao.framework.controller.BaseRecord;
import com.sudao.framework.controller.RestPrototypeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestPrototypeController
@RequestMapping("cloud/component/user")
public class UserController extends LocalBasicController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     *
     * @param param LoginForTelephoneReq
     * @return LoginResp
     */
    @PostMapping("/login")
    public LoginResp login(@RequestBody final LoginForTelephoneReq param) throws ManagerUserException {

        UserResp user = this.userService.login(param);
        AuthToken authToken = new AuthToken(user.getUserId(), Constants.UserType.ADMIN, RandUtil.rand(), false);
        super.setCookie(Constants.AUTH_TOKEN_NAME, authToken.token(), "/", CookieUtils.getCookieDomain(), Constants.AUTH_TOKEN_AGE_MAX);

        ManagerUserVo.SimpleUserInfo simpleUserInfo = BeanUtils.copyProperties(user, ManagerUserVo.SimpleUserInfo.class);
        return new LoginResp().setToken(authToken.token()).setUser(simpleUserInfo);
    }


    @PostMapping("/newPassword")
    public void updatePass(@RequestBody final UpdatePasswordReq param) throws ManagerUserException {
        //当前登录的用户ID
        Long userId = super.sessionTokenResolver.getSessionQuietly(super.request).getUserId();
        this.userService.updatePassword(userId, param);
    }

    /**
     * 注销
     *
     * @return
     */
    @GetMapping("/logout")
    public void logout() {
        this.clearSession();
        setCookie(Constants.AUTH_TOKEN_NAME, "", "/", CookieUtils.getCookieDomain(), 0);
    }

    @PostMapping("/registry")
    public LoginResp registry(@RequestBody final UserRegistryReq param) throws Exception {
        this.userService.registry(param);

        // 注册后自动登录
        LoginForTelephoneReq loginParam = new LoginForTelephoneReq();
        loginParam.setPassword(param.getPassword());
        loginParam.setTelephone(param.getTelephone());
        return this.login(loginParam);
    }

    @PostMapping("/update/{id}")
    public BaseRecord update(@PathVariable(name = "id") final Long id, @RequestBody UserReq obj) {
        setOk(ResultCode.OK);

        obj.setOperatorId(getUserId());
        obj.setUserId(id);
        boolean updated = userService.update(obj);
        if (!updated) {
            setFail(ResultCode.UPDATE_FAIL);
        }
        return baseRecord;
    }

    @PostMapping("/delete/{id}")
    public BaseRecord delete(@PathVariable(name = "id") final Long id) {
        UserReq obj = new UserReq();
        obj.setOperatorId(getUserId());
        obj.setDeleted(Deleted.DELETED.code());
        return update(id, obj);
    }

    @GetMapping("/{id}")
    public UserResp get(@PathVariable(name = "id") final Long id) {
        UserResp obj = userService.getById(id);
        return obj;
    }

    @GetMapping("")
    public BaseRecord find(UserQuery userQuery) {
        Page<UserResp> page = userService.find(userQuery);
        setOk(page);
        return baseRecord;
    }

}
