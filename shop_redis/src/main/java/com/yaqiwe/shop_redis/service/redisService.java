package com.yaqiwe.shop_redis.service;

import com.yaqiwe.domain.entity.user;
import com.yaqiwe.shop_redis.dto.RedisUserDto;

/**
 * @Author yaqiwe
 * @Date 2019/12/20 2:52
 * @Version 1.0
 * redis操作
 */
public interface redisService {

    /**
     * 将用户一些信息存储到redis
     * @param us
     * @return 放回token
     */
    String pullUserInfo(user us);

    RedisUserDto getUserInfo(String token);
}
