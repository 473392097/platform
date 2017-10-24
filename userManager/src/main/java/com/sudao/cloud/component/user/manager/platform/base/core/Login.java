package com.sudao.cloud.component.user.manager.platform.base.core;

/**
 * Created by fuqinqin on 2017/7/31.
 */
public class Login {
    private Long userId;
    private String loginname;
    private String password;
    private String newPassword1;
    private String newPassword2;
    private String ip;
    //用户类型(0-平台用户，1-客户端)
    private Long userType;
    //是否记住我
    private boolean remenber = false;
    private String verifyCode;

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getUserType() {
        return userType;
    }

    public void setUserType(Long userType) {
        this.userType = userType;
    }

    public boolean isRemenber() {
        return remenber;
    }

    public void setRemenber(boolean remenber) {
        this.remenber = remenber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNewPassword1() {
        return newPassword1;
    }

    public void setNewPassword1(String newPassword1) {
        this.newPassword1 = newPassword1;
    }

    public String getNewPassword2() {
        return newPassword2;
    }

    public void setNewPassword2(String newPassword2) {
        this.newPassword2 = newPassword2;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    @Override
    public String toString() {
        return "Login{" +
                "userId=" + userId +
                ", loginname='" + loginname + '\'' +
                ", password='" + password + '\'' +
                ", newPassword1='" + newPassword1 + '\'' +
                ", newPassword2='" + newPassword2 + '\'' +
                ", ip='" + ip + '\'' +
                ", userType=" + userType +
                ", remenber=" + remenber +
                ", verifyCode='" + verifyCode + '\'' +
                '}';
    }
}
