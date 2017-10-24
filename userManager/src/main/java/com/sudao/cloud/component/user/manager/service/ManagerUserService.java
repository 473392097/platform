package com.sudao.cloud.component.user.manager.service;

import com.sudao.cloud.component.user.manager.dao.ManagerUserEntity;
import com.sudao.cloud.component.user.manager.platform.base.result.Page;
import com.sudao.cloud.component.user.manager.platform.base.result.Pagination;
import com.sudao.cloud.component.user.manager.platform.base.service.BaseService;

import java.util.List;

public interface ManagerUserService extends BaseService {

    public ManagerUser getById(Long managerUserId);

    public  ManagerUser getByLoginName(String loginName);

    public List<ManagerUser> findByObj(ManagerUser obj);

    public Long create(ManagerUser obj);

    public void update(ManagerUser obj);

    public Long save(ManagerUser obj);

    public Page<ManagerUser> find(ManagerUserQuery query);
    
    public static class ManagerUserQuery extends Pagination {


    }
    
    public static class ManagerUser extends ManagerUserEntity {

        private List<Long> roleIds;

        public List<Long> getRoleIds() {
            return roleIds;
        }

        public void setRoleIds(List<Long> roleIds) {
            this.roleIds = roleIds;
        }
    }

    public static class LoginUser{

        private String loginName;

        private String loginPwd;

        private  boolean remenber;

        public String getLoginName() {
            return loginName;
        }

        public void setLoginName(String loginName) {
            this.loginName = loginName;
        }

        public String getLoginPwd() {
            return loginPwd;
        }

        public void setLoginPwd(String loginPwd) {
            this.loginPwd = loginPwd;
        }

        public boolean isRemenber() {
            return remenber;
        }

        public void setRemenber(boolean remenber) {
            this.remenber = remenber;
        }
    }

    public static  class UpdatePassword{

        private Long userId;
        private String oldPassword;
        private String newPassword;

        public String getOldPassword() {
            return oldPassword;
        }

        public void setOldPassword(String oldPassword) {
            this.oldPassword = oldPassword;
        }

        public String getNewPassword() {
            return newPassword;
        }

        public void setNewPassword(String newPassword) {
            this.newPassword = newPassword;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

    }



}
