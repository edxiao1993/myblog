package org.kevin.demo0212.repository;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author Kevin.Z
 * @version 2020-04-15
 */
@Repository
public class MyRedisRepository {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void setWithExpireTime(String key, Object value, int expire) {
        this.setWithExpireTimeAndUnit(key, value, expire, TimeUnit.SECONDS);
    }

    public void setWithExpireTimeAndUnit(String key, Object value, int expire, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, expire, unit);
    }

    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public <T> T get(String key, Class<T> clazz) {
        return (T) redisTemplate.opsForValue().get(key);
    }

    public boolean delete(String key) {
        return redisTemplate.delete(key);
    }

    public boolean checkExist(String key) {
        return redisTemplate.hasKey(key);
    }
}
