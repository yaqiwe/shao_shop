package com.eyaqiwe.get_api.service.impl;


import com.eyaqiwe.get_api.dto.RedisUserDto;
import com.eyaqiwe.get_api.service.redisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author yaqiwe
 * @Date 2019/12/20 2:54
 * @Version 1.0
 * redis操作实现类
 */
@Service
public class redisServiceImpl implements redisService {

    @Resource(name = "redisdDto")
    RedisTemplate<String,Object> redisTemplate;


    @Override
    public RedisUserDto getUserInfo(String token) {
        Object o = redisTemplate.opsForValue().get(token);
        if (o instanceof RedisUserDto)
            return (RedisUserDto) o;
        return null;
    }
}
