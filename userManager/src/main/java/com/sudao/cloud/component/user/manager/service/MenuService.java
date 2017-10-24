package com.sudao.cloud.component.user.manager.service;

import com.sudao.cloud.component.user.manager.dao.MenuEntity;
import com.sudao.cloud.component.user.manager.platform.base.result.Page;
import com.sudao.cloud.component.user.manager.platform.base.result.Pagination;
import com.sudao.cloud.component.user.manager.platform.base.service.BaseService;

import java.util.List;
import java.util.Map;

public interface MenuService extends BaseService {

    public Menu getById(Long menuId);

    public Long create(Menu obj);

    public void update(Menu obj);

    public Long save(Menu obj);

    public Page<Menu> find(MenuQuery query);

    public  List<Menu> findByObj(Menu obj);

    public  List<Menu> findByParentId(Long parentId);

    /**
     * 通过用户Id获取用户权限菜单,功能点
     * @param userId
     * @return
     */
    public List<Menu> findRoleMenusByUserId(Long userId);

    public Map<String,Object> findPermissionsByUserId(Long userId);
    
    public static class MenuQuery extends Pagination {
        private Long parentId;

        public Long getParentId() {
            return parentId;
        }

        public void setParentId(Long parentId) {
            this.parentId = parentId;
        }
    }
    
    public static class Menu extends MenuEntity {

        private List<Long> menuIds;

        private List<Menu> children ;

        public List<Menu> getChildren() {
            return children;
        }

        public List<Long> getMenuIds() {
            return menuIds;
        }

        public void setMenuIds(List<Long> menuIds) {
            this.menuIds = menuIds;
        }

        public void setChildren(List<Menu> children) {
            this.children = children;
        }
    }
}
