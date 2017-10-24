package com.sudao.cloud.component.user.manager.platform.base.filters;

import com.sudao.cloud.component.user.manager.platform.base.core.config.ConfigLoader;

import java.util.List;

/**
 * Created by fuqinqin on 2017/7/28.
 */
public class FilterParamsConfig {
    private static final FilterParamsConfig instance
            = ConfigLoader.loadYamlAs("filter.yaml", FilterParamsConfig.class);
    private FilterParamsConfig(){}
    public static FilterParamsConfig getInstance(){
        return instance;
    }

    /**
     * 登录认证
     * */
    //免登陆路径
    private List<String> authExcludes;

    public List<String> getAuthExcludes() {
        return authExcludes;
    }

    public void setAuthExcludes(List<String> authExcludes) {
        this.authExcludes = authExcludes;
    }

    @Override
    public String toString() {
        return "FilterConfig{" +
                "authExcludes='" + authExcludes + '\'' +
                '}';
    }
}
