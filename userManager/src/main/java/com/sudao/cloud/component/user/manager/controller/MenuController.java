package com.sudao.cloud.component.user.manager.controller;

import com.sudao.cloud.component.user.manager.service.MenuService;
import com.sudao.cloud.component.user.manager.service.MenuService.Menu;
import com.sudao.framework.controller.RestPrototypeController;
import com.sudao.cloud.component.user.manager.platform.base.controller.LocalBasicController;
import com.sudao.cloud.component.user.manager.platform.base.result.Page;
import com.sudao.cloud.component.user.manager.platform.base.result.Result;
import com.sudao.cloud.component.user.manager.platform.base.result.ResultCode;
import com.sudao.cloud.component.user.manager.platform.enums.Deleted;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestPrototypeController
@RequestMapping("/cloud/component/menu")
public class MenuController extends LocalBasicController {

    @Autowired
    private MenuService menuService;

    @PostMapping("")
    public Map<String, Object> create(@RequestBody final Menu obj) {
        // create
//        obj.setOperator(getSession().getUserId());
        Long id = menuService.create(obj);

        return resultMap(ResultCode.OK, "Menu_id", id);
    }

    @PutMapping("/{id}")
    public Map<String, Object> update(
            @PathVariable("id") final Long id,
            @RequestBody final Menu obj) {
        obj.setMenuId(id);
//        obj.setOperator(getSession().getUserId());
        menuService.update(obj);
        
        return resultMap(ResultCode.OK);
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable("id") final Long id) {
        Menu obj = new Menu();
        obj.setDeleted(Deleted.DELETED);
        return update(id, obj);
    }

    @DeleteMapping("")
    public Map<String, Object> deleteMore(@RequestBody final List<Long> ids) {
    	if (!CollectionUtils.isEmpty(ids)) {
			for (Long id : ids) {
				delete(id);
			}
    	}
        return resultMap(ResultCode.OK);
    }

    @GetMapping("/{id}")
    public Menu get(@PathVariable("id") final Long id) {
        Menu obj = menuService.getById(id);
        
        return obj;
    }

    @GetMapping("")
    public Result<Page<Menu>> find(
              @RequestParam(value = "offset", required = false) Integer offset,
              @RequestParam(value = "limit", required = false) Integer limit,
              @RequestParam(value = "page", required = false) Integer pageNum
            ) {
        MenuService.MenuQuery query = new MenuService.MenuQuery();
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
		
		Page<Menu> page = menuService.find(query);
        return new Result<Page<Menu>>(ResultCode.OK, page);
    }


    @GetMapping("/structure")
    public Result<List<Menu>> findTiers() {
        Menu menu = new Menu();
        menu.setParentId(0L);
        List<Menu> menus = menuService.findByObj(menu);
        if (CollectionUtils.isNotEmpty(menus)){
            for (Menu record : menus
                    ) {
                recursiveQuery(record);
            }
        }
        return new Result<List<Menu>>(ResultCode.OK, menus);
    }

    private Menu recursiveQuery(Menu menu) {
        List<Menu> list = menuService.findByParentId(menu.getMenuId());
        if (CollectionUtils.isNotEmpty(list)) {
            menu.setChildren(list);
            for (Menu record : list) {
                  recursiveQuery(record);
            }
        }
        return menu;
    }

}
