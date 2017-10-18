package com.sudao.cloud.module;

import com.sudao.framework.core.Handler;
import com.sudao.framework.core.IPlugin;
import com.sudao.framework.core.Interceptor;
import com.sudao.framework.starter.ComponentStarter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

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
@MapperScan(basePackages = {"com.sudao.cloud.module"})
public class ComponentBoot extends ComponentStarter {
    /******* Fields Area *******/

    /******* Construction Area *******/
    public ComponentBoot() {
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
