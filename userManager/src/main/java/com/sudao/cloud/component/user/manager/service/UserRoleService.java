package com.sudao.cloud.component.user.manager.service;

import com.sudao.cloud.component.user.manager.dao.UserRoleEntity;
import com.sudao.cloud.component.user.manager.platform.base.result.Page;
import com.sudao.cloud.component.user.manager.platform.base.result.Pagination;
import com.sudao.cloud.component.user.manager.platform.base.service.BaseService;

import java.util.List;

public interface UserRoleService extends BaseService {

    public UserRole getById(Long userRoleId);

    public Long create(UserRole obj);

    public void update(UserRole obj);

    /**
     * 通过条件物理删除
     * @param obj
     */
    public void deleteByObj(UserRole obj);

    public Long save(UserRole obj);

    public Page<UserRole> find(UserRoleQuery query);

    public List<UserRole> findByObj(UserRole obj);

    public List<UserRole> findByUserId(Long userId);
    
    public static class UserRoleQuery extends Pagination {
    }
    
    public static class UserRole extends UserRoleEntity {
    }
}
