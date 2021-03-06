package com.sudao.cloud.component.user.manager;

import com.sudao.cloud.component.user.manager.core.ManagerUserComponentExceptionHandler;
import com.sudao.cloud.component.user.manager.platform.base.interceptor.AuthTokenHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import com.sudao.framework.core.Handler;
import com.sudao.framework.core.IPlugin;
import com.sudao.framework.core.Interceptor;
import com.sudao.framework.starter.ComponentStarter;

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
@Configuration("com.sudao.cloud.component.user.manager.ComponentBoot")
@MapperScan({"com.sudao.cloud.component.user.manager.dao"})
public class ComponentBoot extends ComponentStarter {
    /******* Fields Area *******/

    /******* Construction Area *******/
    public ComponentBoot() {
    }

    @Override
    public void configHandler(List<Handler> list) {
        list.add(new AuthTokenHandler());
        list.add(new ManagerUserComponentExceptionHandler());

    }

    @Override
    public void configInterceptor(List<Interceptor> list) {

    }

    @Override
    public void configPlugin(List<IPlugin> list) {

    }
}
