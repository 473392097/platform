package com.sudao.cloud.component.user.manager.service;

import com.sudao.cloud.component.user.manager.dao.RoleEntity;
import com.sudao.cloud.component.user.manager.platform.base.result.Page;
import com.sudao.cloud.component.user.manager.platform.base.result.Pagination;
import com.sudao.cloud.component.user.manager.platform.base.service.BaseService;

import java.util.List;

public interface RoleService extends BaseService {

    public Role getById(Long roleId);

    public Long create(Role obj);

    public void update(Role obj);

    public Long save(Role obj);

    public Page<Role> find(RoleQuery query);
    
    public static class RoleQuery extends Pagination {
    }
    
    public static class Role extends RoleEntity {

        private List<Long> menuIds;


        public List<Long> getMenuIds() {
            return menuIds;
        }

        public void setMenuIds(List<Long> menuIds) {
            this.menuIds = menuIds;
        }
    }
}
