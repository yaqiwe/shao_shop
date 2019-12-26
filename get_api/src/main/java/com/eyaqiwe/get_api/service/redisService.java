package com.eyaqiwe.get_api.service;

import com.eyaqiwe.get_api.dto.RedisUserDto;

/**
 * @Author yaqiwe
 * @Date 2019/12/20 2:52
 * @Version 1.0
 * redis操作
 */
public interface redisService {


    RedisUserDto getUserInfo(String token);
}
