package com.yaqiwe.shop_redis.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author yaqiwe
 * @Date 2019/12/20 3:10
 * @Version 1.0
 * 存储到redis里面的user信息
 */
@Data
public class RedisUserDto implements Serializable {

    private static final long serialVersionUID = -4035754716493701436L;

    /*用户Id*/
    private long userId;

    /*用户名*/
    private String userName;

    /*购物车Id*/
    private long shopCartId;
}
