package com.sudao.cloud.module;

import com.sudao.framework.core.Handler;
import com.sudao.framework.core.IPlugin;
import com.sudao.framework.core.Interceptor;
import com.sudao.framework.starter.ComponentStarter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * componentTemplate
 * <p>
 * Description :
 * <p>
 * Creator :
 * Cloud @ Sudaotech
 * Email :
 * =========================================
 * <p>
 */
@Configuration
@MapperScan(basePackages = {
        "com.sudao.cloud.module.category.dao",
        "com.sudao.cloud.module.idea.dao",
        "com.sudao.cloud.module.praise.dao",
        "com.sudao.cloud.module.commons.dao"
})
public class ComponentBoot extends ComponentStarter {
    /******* Fields Area *******/

    /******* Construction Area *******/
    public ComponentBoot() {
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
        Date parse = sdf.parse("2017-10-28 00:00:00");
        System.out.println(new Date(1509170628000L));
    }

    @Override
    public void configHandler(List<Handler> list) {

    }

    @Override
    public void configInterceptor(List<Interceptor> list) {

    }

    @Override
    public void configPlugin(List<IPlugin> list) {

    }
}
