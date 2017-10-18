package com.sudao.cloud.module.base.service;

import com.sudao.cloud.module.base.dao.page.Pagination;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseServiceImpl implements BaseService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected RowBounds toRowBounds(Pagination pagination){
        return new RowBounds(pagination.getOffset(), pagination.getLimit());
    }
}
