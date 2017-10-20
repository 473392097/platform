package com.sudao.cloud.module.category.controller;

import com.sudao.cloud.module.base.config.ResultCode;
import com.sudao.cloud.module.base.config.enums.Status;
import com.sudao.cloud.module.category.vo.req.CategoryQuery;
import com.sudao.cloud.module.category.vo.req.CategoryReq;
import com.sudao.cloud.module.category.vo.resp.CategoryResp;
import com.sudao.framework.controller.BaseRecord;
import com.sudao.framework.controller.RestPrototypeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sudao.cloud.module.category.service.CategoryService;
import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.base.controller.LocalBasicController;


@RestPrototypeController
@RequestMapping("/category")
public class CategoryController extends LocalBasicController {

    @Autowired
    private CategoryService categoryService;
    
    @PostMapping("/create")
    public BaseRecord create(@RequestBody final CategoryReq obj) {
        setOk(ResultCode.OK);

        // create
        obj.setOperatorId(getUserId());
        boolean created = categoryService.create(obj);
        if(!created){
            setFail(ResultCode.CREATE_FAIL);
        }
        return baseRecord;
    }

    @PostMapping("/update/{categoryId}")
    public BaseRecord update(@PathVariable(name = "categoryId") final Long categoryId, @RequestBody CategoryReq obj) {
        setOk(ResultCode.OK);

        obj.setOperatorId(getUserId());
        obj.setCategoryId(categoryId);
        boolean updated = categoryService.update(obj);
        if(!updated){
            setFail(ResultCode.UPDATE_FAIL);
        }
        return baseRecord;
    }

    @PostMapping("/delete/{categoryId}")
    public BaseRecord delete(@PathVariable(name = "categoryId") final Long categoryId) {
        CategoryReq obj = new CategoryReq();
        obj.setOperatorId(getUserId());
        obj.setStatus(Status.DELETED);
        return update(categoryId, obj);
    }

    @GetMapping("/{categoryId}")
    public CategoryResp get(@PathVariable(name = "categoryId") final Long categoryId) {
        CategoryResp obj = categoryService.getById(categoryId);
        return obj;
    }

    @GetMapping("")
    public BaseRecord find(CategoryQuery categoryQuery) {
        Page<CategoryResp> page = categoryService.find(categoryQuery);
        setOk(page);
        return baseRecord;
    }

}
