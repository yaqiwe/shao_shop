package com.yaqiwe.shao_buy.service;

import com.yaqiwe.shao_buy.dto.RedisUserDto;

/**
 * @Author yaqiwe
 * @Date 2019/12/20 2:52
 * @Version 1.0
 * redis操作
 */
public interface redisService {


    RedisUserDto getUserInfo(String token);
}
