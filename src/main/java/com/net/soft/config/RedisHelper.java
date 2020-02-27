package com.net.soft.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * Redis助手
 * @author caiguohua
 * @date 2020/2/27 23:26
 * @Email:cai.beyond@qq.com
 */
@Component
public class RedisHelper {

    @Value("${spring.redis.prefix}")
    private String keyPrefix;

    private final StringRedisTemplate stringRedisTemplate;
    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public RedisHelper(StringRedisTemplate stringRedisTemplate, RedisTemplate<String, Object> redisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.redisTemplate = redisTemplate;
    }

    private String formatKey(String key) {
        return keyPrefix + key;
    }

    public String get(String key){return stringRedisTemplate.opsForValue().get(formatKey(key));}

    public void set(String key,String value,Integer expirationSeconds){
        stringRedisTemplate.opsForValue().set(formatKey(key),value,expirationSeconds, TimeUnit.SECONDS);
    }

    public Object getObject(String key){
        return redisTemplate.opsForValue().get(formatKey(key));
    }

    public void setObject(String key,Object value,Integer expirationSeconds){
        redisTemplate.opsForValue().set(formatKey(key),value,expirationSeconds,TimeUnit.SECONDS);
    }

    public boolean deleteObject(String key){
        return redisTemplate.delete(formatKey(key));
    }

    public boolean delete(String key){
        return stringRedisTemplate.delete(formatKey(key));
    }

    public boolean getLock(String lockKey,String value,Integer expireTime){
        String k = formatKey(lockKey);
        boolean set = stringRedisTemplate.opsForValue().setIfAbsent(k,value);
        if(set){
            boolean expire = stringRedisTemplate.expire(k,expireTime,TimeUnit.SECONDS);
            if(!expire){
                stringRedisTemplate.delete(k);
            }
            return expire;
        }
        return set;
    }

    public boolean releaseLock(String locakKey,String value){
        String v = stringRedisTemplate.opsForValue().get(formatKey(locakKey));
        if(StringUtils.isEmpty(v)){
            return false;
        }else {
            return stringRedisTemplate.delete(formatKey(locakKey));
        }
    }
}
