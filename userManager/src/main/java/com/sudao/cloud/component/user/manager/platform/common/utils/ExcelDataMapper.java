package com.sudao.cloud.component.user.manager.platform.common.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Administrator on 2017/7/5.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelDataMapper {
    String title();   // 标题名称
    int order();      // 标题顺序
    int width() default 16;   // 单元格宽度
}
