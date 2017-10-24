package com.sudao.cloud.component.user.manager.platform.base.service.redis;

import com.sudao.cloud.component.user.manager.platform.common.utils.BeanUtils;
import redis.clients.jedis.JedisPoolConfig;


public class RedisHelper {
    private static JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
    static {
        RedisConfig redisConfig = RedisConfig.getInstance();
        BeanUtils.copyProperties(redisConfig, jedisPoolConfig, true);
    }

    public static JedisPoolConfig getJedisPoolConfig() {
        return jedisPoolConfig;
    }
}
