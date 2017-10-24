package com.sudao.cloud.component.user.manager.service;

import com.sudao.cloud.component.user.manager.dao.RoleMenuEntity;
import com.sudao.cloud.component.user.manager.platform.base.result.Page;
import com.sudao.cloud.component.user.manager.platform.base.result.Pagination;
import com.sudao.cloud.component.user.manager.platform.base.service.BaseService;

import java.util.List;

public interface RoleMenuService extends BaseService {

    public RoleMenu getById(Long roleMenuId);

    public Long create(RoleMenu obj);

    public void update(RoleMenu obj);

    public void updateByObj(RoleMenu obj);

    public void deleteByObj(RoleMenu obj);

    public Long save(RoleMenu obj);

    public Page<RoleMenu> find(RoleMenuQuery query);

    public List<RoleMenu> findByObj(RoleMenu obj);

    public List<RoleMenu> findByRoleId(Long roleId);

    public List<RoleMenu> findByRoleIds(List<Long> roleIds);

    public static class RoleMenuQuery extends Pagination {
    }
    
    public static class RoleMenu extends RoleMenuEntity {

        public  List<Long> roleIds;

        public List<Long> getRoleIds() {
            return roleIds;
        }

        public void setRoleIds(List<Long> roleIds) {
            this.roleIds = roleIds;
        }
    }
}
