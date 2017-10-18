package com.sudao.cloud.module.base.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Spector on 2017/6/28.
 */
@Component
public class SelfConfig {
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String passwd;

    @Value("${sudao.cloud.component.constant.mysqlExecSqlHost}")
    private String mysqlExecSqlHost;

    @Value("${sudao.cloud.systemCode}")
    private String systemCode;

    public String getDriverClassName() {
        return driverClassName;
    }

    public SelfConfig setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public SelfConfig setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public SelfConfig setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPasswd() {
        return passwd;
    }

    public SelfConfig setPasswd(String passwd) {
        this.passwd = passwd;
        return this;
    }

    public String getMysqlExecSqlHost() {
        return mysqlExecSqlHost;
    }

    public SelfConfig setMysqlExecSqlHost(String mysqlExecSqlHost) {
        this.mysqlExecSqlHost = mysqlExecSqlHost;
        return this;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public SelfConfig setSystemCode(String systemCode) {
        this.systemCode = systemCode;
        return this;
    }
}
