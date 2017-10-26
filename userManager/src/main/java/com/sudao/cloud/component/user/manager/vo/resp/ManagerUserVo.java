package com.sudao.cloud.component.user.manager.vo.resp;

import com.sudao.cloud.component.user.manager.platform.common.utils.BeanUtils;
import com.sudao.cloud.component.user.manager.service.ManagerUserService;

/**
 * 响应模型
 *
 * @author chen
 * @create 2017-09-25 11:45
 **/
public interface ManagerUserVo {


    class SimpleUserInfo {

        private Long managerUserId;

        private String image;

        private String loginName;

        private String userName;

        private Integer gender;

        private String email;

        private String telephone;

        private String remark;

        private String nikeName;

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

        public String getImage() {
            return image;
        }

        public SimpleUserInfo setImage(String image) {
            this.image = image == null ? null : image.trim();
            return this;
        }

        public String getNikeName() {
            return nikeName;
        }

        public SimpleUserInfo setNikeName(String nikeName) {
            this.nikeName = nikeName == null ? null : nikeName.trim();
            return this;
        }

        public static SimpleUserInfo parse(ManagerUserService.ManagerUser managerUser) {
            SimpleUserInfo target = BeanUtils.copyProperties(managerUser, SimpleUserInfo.class);
            return target;
        }
    }
}
