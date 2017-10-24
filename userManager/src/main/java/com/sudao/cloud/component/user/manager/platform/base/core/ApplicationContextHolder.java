package com.sudao.cloud.component.user.manager.platform.base.core;

import org.springframework.context.ApplicationContext;

/**
 * Created by fuqinqin on 2017/7/28.
 */
public class ApplicationContextHolder {
    public static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext context){
        applicationContext = context;
    }

    /**
     * 从spring容器中获取bean
     * */
    public static Object getBean(String id){
        Object obj = null;
        if(applicationContext != null){
            obj = applicationContext.getBean(id);
        }
        return obj;
    }
}
