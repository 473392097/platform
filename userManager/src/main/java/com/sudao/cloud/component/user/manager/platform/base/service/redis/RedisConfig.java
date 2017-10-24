package com.sudao.cloud.component.user.manager.platform.base.service.redis;

import com.sudao.cloud.component.user.manager.platform.base.core.config.ConfigLoader;

public class RedisConfig {
    
    private static final RedisConfig instance = ConfigLoader.loadYamlAs("redis.yaml", RedisConfig.class);

    private int maxTotal = 10;
    private int maxIdle = 0;
    private long maxWaitMillis = -1L;
    private int minIdle = 0;

    public static RedisConfig getInstance() {
        return instance;
    }
    
    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public long getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public void setMaxWaitMillis(long maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }
}
