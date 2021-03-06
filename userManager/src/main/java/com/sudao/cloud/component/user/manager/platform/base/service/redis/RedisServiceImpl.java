package com.sudao.cloud.component.user.manager.platform.base.service.redis;

import com.sudao.cloud.component.user.manager.platform.base.service.BaseServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RedisServiceImpl extends BaseServiceImpl implements RedisService {

    private static final int TIMEOUT = 5 * 60; // 5 min
    
    private JedisPool jedisPool;

    public RedisServiceImpl() {
        String host = envProperties.get("redis.host");
        int port = Integer.parseInt(envProperties.get("redis.port"));
        this.logger.info("Redis: host={}, port={}", host, port);
        
        this.jedisPool = new JedisPool(RedisHelper.getJedisPoolConfig(), host, port, 3000); // timeout: 3s
    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            this.jedisPool.destroy();
        } catch (Exception e) {
            this.logger.error("Caught Redis Exception: {}", e.getMessage(), e);
        }
    }
    
    @Override
    public List<String> get(List<String> keys) {
        this.logger.debug("START get, keys={}", keys);
        
        List<String> result = null;
        
        if (!CollectionUtils.isEmpty(keys)) {
            Jedis jedis = null;
            try {
                jedis = this.jedisPool.getResource();
                result = jedis.mget(keys.toArray(new String[0]));
                this.jedisPool.returnResource(jedis);
            } catch (Exception e) {
                this.logger.error("Caught Redis Exception: {}", e.getMessage(), e);
                returnBrokenResource(jedis);
            }
        }
        
        this.logger.debug("END get, result={}", result);
        
        if (result == null) {
            result = Collections.emptyList();
        }
        
        return result;
    }

    @Override
    public Map<String, String> getMap(List<String> keys) {
        this.logger.debug("START getMap, keys: {}", keys);

        List<String> list = this.get(keys);
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = list.get(i);
            map.put(key, value);
        }

        this.logger.debug("END mgetMap, result: {}", map);

        return map;
    }


    @Override
    public Long hincr(String key, String field, long increment) {
        this.logger.debug("start redis hincr: key={}, field={}, increment={}", key, field, increment);
        Jedis jedis = null;
        try {
            jedis = this.jedisPool.getResource();
            Long value = jedis.hincrBy(key, field, increment);
            this.jedisPool.returnResource(jedis);
            this.logger.info("redis hset: key={}, field={}, value={}", key, field, value);
            return value;
        } catch (Exception e) {
            this.logger.error("Caught Redis Exception: {}", e.getMessage(), e);
            returnBrokenResource(jedis);
        }
        return null;
    }

    @Override
    public Map<String, String> hgetAll(String key) {
        Jedis jedis = null;
        try {
            jedis = this.jedisPool.getResource();
            Map<String, String> map = jedis.hgetAll(key);
            this.jedisPool.returnResource(jedis);
            return map;
        } catch (Exception e) {
            this.logger.error("Caught Redis Exception: {}", e.getMessage(), e);
            returnBrokenResource(jedis);
        }
        return null;
    }

    @Override
    public boolean exists(String key) throws Exception{
        this.logger.debug("start: exists in redis cache. key={}", key);
        Jedis jedis = null;
        try {
            jedis = this.jedisPool.getResource();
            Boolean isExisted = jedis.exists(key);
            this.jedisPool.returnResource(jedis);
            
            this.logger.debug("end: key={}, exists={}", key, isExisted);
            return isExisted;
        } catch (Exception e) {
            this.logger.error("Caught Redis Exception: {}", e.getMessage(), e);
            returnBrokenResource(jedis);
            throw new Exception(e.getMessage());
        }
    }


    @Override
    public String get(String key) {
        this.logger.debug("start: get redis cache. key={}", key);
        Jedis jedis = null;
        try {
            jedis = this.jedisPool.getResource();
            String value = jedis.get(key);
            this.jedisPool.returnResource(jedis);
            this.logger.debug("end: key={}, value={}", key, value);
            return value;
        } catch (Exception e) {
            this.logger.error("Caught Redis Exception: {}", e.getMessage(), e);
            returnBrokenResource(jedis);
        }
        return null;
    }

    @Override
    public void del(String key) {
        this.logger.debug("start: del redis cache. key={}", key);
        Jedis jedis = null;
        try {
            jedis = this.jedisPool.getResource();
            Long del = jedis.del(key);
            this.jedisPool.returnResource(jedis);
            this.logger.debug("end: key={}, return={}", key, del);
        } catch (Exception e) {
            this.logger.error("Caught Redis Exception: {}", e.getMessage(), e);
            returnBrokenResource(jedis);
        }
    }

    @Override
    public void set(String key, String value) {
        this.logger.debug("start: set redis cache. key={}, value={}", key, value);
        Jedis jedis = null;
        try {
            jedis = this.jedisPool.getResource();
            jedis.set(key, value);
            this.jedisPool.returnResource(jedis);
        } catch (Exception e) {
            this.logger.error("Redis exception: {}", e.getMessage(), e);
            returnBrokenResource(jedis);
        }
    }

    @Override
    public void set(String key, String value, int seconds) throws Exception{
        this.logger.debug("start: set redis cache. key={}, value={}, expire={}", key, value, seconds);
        Jedis jedis = null;
        try {
            jedis = this.jedisPool.getResource();
            jedis.set(key, value);
            jedis.expire(key, seconds);
            this.jedisPool.returnResource(jedis);
        } catch (Exception e) {
            this.logger.error("Redis exception: {}", e.getMessage(), e);
            returnBrokenResource(jedis);
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void expire(String key, int seconds) {
        this.logger.debug("start: expire key={}, expire={}", key, seconds);
        
        Jedis jedis = null;
        try {
            jedis = this.jedisPool.getResource();
            jedis.expire(key, seconds);
            this.jedisPool.returnResource(jedis);
        } catch (Exception e) {
            this.logger.error("Redis exception: {}", e.getMessage(), e);
            returnBrokenResource(jedis);
        }
    }

    @Override
    public Map<String, String> blpop(String... keys) {
        this.logger.debug("start: blpop redis. keys={}", (Object[])keys);
        Jedis jedis = null;
        Map<String, String> map = new HashMap<String, String>();
        do {
            try {
                jedis = this.jedisPool.getResource();
                List<String> list = jedis.brpop(TIMEOUT, keys);
                this.jedisPool.returnResource(jedis);
                
                if (CollectionUtils.isEmpty(list)) {
                    continue;
                }
                
                for (int i = 1; i < list.size(); i+=2) {
                    String key = list.get(i-1);
                    String value = list.get(i);
                    map.put(key, value);
                }
                
            } catch (Exception e) {
                this.logger.error("Redis exception: {}", e.getMessage(), e);
                returnBrokenResource(jedis);
            }
        } while (map.isEmpty());
        
        return map;
    }

    @Override
    public void rpush(String key, String...values) {
        this.logger.debug("start: rpush redis. key={}, values={}", key, values);
        Jedis jedis = null;
        try {
            jedis = this.jedisPool.getResource();
            jedis.rpush(key, values);
            this.jedisPool.returnResource(jedis);
        } catch (Exception e) {
            this.logger.error("Redis exception: {}", e.getMessage(), e);
            returnBrokenResource(jedis);
        }
    }

    private void returnBrokenResource(Jedis jedis) {
        if (jedis != null) {
            try {
                this.jedisPool.returnBrokenResource(jedis);
            } catch (Exception e) {
                this.logger.error("Caught Redis Exception when returnBrokenResource: {}", e.getMessage(), e);
            }
        }
    }
}
