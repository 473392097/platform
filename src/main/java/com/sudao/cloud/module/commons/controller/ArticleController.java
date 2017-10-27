package com.sudao.cloud.module.commons.controller;

import com.sudao.cloud.module.base.config.ResultCode;
import com.sudao.cloud.module.base.config.enums.Deleted;
import com.sudao.cloud.module.base.controller.LocalBasicController;
import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.commons.service.ArticleService;
import com.sudao.cloud.module.commons.vo.req.ArticleQuery;
import com.sudao.cloud.module.commons.vo.req.ArticleReq;
import com.sudao.cloud.module.commons.vo.resp.ArticleResp;
import com.sudao.framework.controller.BaseRecord;
import com.sudao.framework.controller.RestPrototypeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestPrototypeController
@RequestMapping("/article")
public class ArticleController extends LocalBasicController {

    @Autowired
    private ArticleService articleService;
    
    @PostMapping("/create")
    public BaseRecord create(@RequestBody final ArticleReq obj) {
        setOk(ResultCode.OK);

        // create
        obj.setOperatorId(getUserId());
        boolean created = articleService.create(obj);
        if(!created){
            setFail(ResultCode.CREATE_FAIL);
        }
        return baseRecord;
    }

    @PostMapping("/update/{article_id}")
    public BaseRecord update(@PathVariable(name = "article_id") final Long article_id, @RequestBody ArticleReq obj) {
        setOk(ResultCode.OK);

        obj.setOperatorId(getUserId());
        obj.setArticleId(article_id);
        boolean updated = articleService.update(obj);
        if(!updated){
            setFail(ResultCode.UPDATE_FAIL);
        }
        return baseRecord;
    }

    @PostMapping("/delete/{article_id}")
    public BaseRecord delete(@PathVariable(name = "article_id") final Long article_id) {
        ArticleReq obj = new ArticleReq();
        obj.setOperatorId(getUserId());
        obj.setDeleted(Deleted.DELETED.code());
        return update(article_id, obj);
    }

    @GetMapping("/{article_id}")
    public ArticleResp get(@PathVariable(name = "article_id") final Long article_id) {
        ArticleResp obj = articleService.getById(article_id);
        return obj;
    }

    @GetMapping("")
    public BaseRecord find(ArticleQuery articleQuery) {
        Page<ArticleResp> page = articleService.find(articleQuery);
        setOk(page);
        return baseRecord;
    }

}
