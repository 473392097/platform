package com.sudao.cloud.component.user.manager.controller.vo;

/**
 * 响应模型
 *
 * @author chen
 * @create 2017-09-25 11:45
 **/
public interface ManagerUserVo {


    class SimpleUserInfo {

        private Long managerUserId;

        private String loginName;

        private String userName;

        private Integer gender;

        private String email;

        private String telephone;

        private String remark;

        public Long getManagerUserId() {
            return managerUserId;
        }

        public void setManagerUserId(Long managerUserId) {
            this.managerUserId = managerUserId;
        }

        public String getLoginName() {
            return loginName;
        }

        public void setLoginName(String loginName) {
            this.loginName = loginName;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Integer getGender() {
            return gender;
        }

        public void setGender(Integer gender) {
            this.gender = gender;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }
}
