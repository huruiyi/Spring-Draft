package com.vk.liyj.service.impl;

import com.vk.liyj.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private KeyGenerator keyGenerator;

    public Object findByKey(String key) {

        return redisTemplate.opsForValue().get(key);
    }

    public Object cacheObject(String result) {
        try {
            Object keyObj = keyGenerator.generate(this, this.getClass().
                    getMethod("cacheObject", new Class<?>[]{String.class}), "xxx");

            if (!redisTemplate.hasKey(keyObj)) {
                redisTemplate.opsForValue().set("jack", result);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return null;
    }

}
