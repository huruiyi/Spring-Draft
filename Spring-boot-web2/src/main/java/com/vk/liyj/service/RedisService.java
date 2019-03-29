package com.vk.liyj.service;

public interface RedisService {

    Object findByKey(String key);

    Object cacheObject(String result);

}
