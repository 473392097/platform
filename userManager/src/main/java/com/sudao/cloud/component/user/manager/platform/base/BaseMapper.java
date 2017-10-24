package com.sudao.cloud.component.user.manager.platform.base;

import java.util.List;

/**
 * Created by Administrator on 2017/7/14.
 */
public interface BaseMapper<T> {
    int insert(T entity);

    int update(T entity);

    int delete(Long id);

    T loadById(Long id);

    List<T> findAll();
}
