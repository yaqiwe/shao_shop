package com.yaqiwe.domain.service.impl;


import com.yaqiwe.domain.dto.RedisUserDto;
import com.yaqiwe.domain.entity.user;
import com.yaqiwe.domain.service.redisService;
import com.yaqiwe.domain.util.GenerationToken;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

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


    /*过期时间*/
    Integer EXPIRED_TIME=7200;


    @Override
    public String pullUserInfo(user us) {
        //生成token
        String token= GenerationToken.getToken();
        RedisUserDto dto=new RedisUserDto();
        BeanUtils.copyProperties(us,dto);
        redisTemplate.opsForValue().set(token,dto,EXPIRED_TIME, TimeUnit.SECONDS);
        return token;
    }

    @Override
    public RedisUserDto getUserInfo(String token) {
        Object o = redisTemplate.opsForValue().get(token);
        if (o instanceof RedisUserDto)
            return (RedisUserDto) o;
        return null;
    }
}
