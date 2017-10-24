package com.sudao.cloud.component.user.manager;
import com.sudao.cloud.component.user.manager.platform.base.interceptor.AuthTokenHandler;
import com.sudao.framework.config.IComponentConfig;
import com.sudao.framework.core.Constant;
import com.sudao.framework.core.Handlers;
import com.sudao.framework.core.Interceptors;
import com.sudao.framework.core.Plugins;
import com.sudao.framework.starter.ApplicationStarter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
@SpringBootApplication
public class Boot extends ApplicationStarter {
    /******* Fields Area *******/
    /******* Construction Area *******/
    public Boot() {

    }

    @Override
    public void configConsts(Constant constant) {
    }

    @Override
    public void configHandler(Handlers handlers) {
    }

    @Override
    public void configInterceptor(Interceptors interceptors) {
    }

    @Override
    public void configPlugin(Plugins plugins) {
    }

    @Override
    public void configComponent(List<IComponentConfig> list) {
        list.add(new com.sudao.cloud.component.user.manager.ComponentBoot());

    }

    public static void main(String[] args) {
        new Boot().runApplication(args);
    }
}