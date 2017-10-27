package com.sudao.cloud.module.base.service;

import com.sudao.cloud.module.base.dao.page.Pagination;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public abstract class BaseServiceImpl<T, C> implements BaseService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());


    protected RowBounds toRowBounds(Pagination pagination){
        return new RowBounds(pagination.getOffset(), pagination.getLimit());
    }

}
