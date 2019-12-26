package com.yaqiwe.shao_buy.config;

import com.yaqiwe.shao_buy.dto.RedisUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Author yaqiwe
 * @Date 2019/12/21 20:26
 * @Version 1.0
 */
@Configuration
public class redisConfig {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public RedisTemplate<String, Object> redisdDto(){
        RedisTemplate<String, Object> redisT = new RedisTemplate<>();
        StringRedisSerializer strRedis = new StringRedisSerializer();
        redisT.setValueSerializer(new Jackson2JsonRedisSerializer<>(RedisUserDto.class));
        redisT.setKeySerializer(strRedis);
        redisT.setHashKeySerializer(strRedis);
        redisT.setHashValueSerializer(strRedis);
        redisT.setConnectionFactory(redisConnectionFactory);
        return redisT;
    }


}
