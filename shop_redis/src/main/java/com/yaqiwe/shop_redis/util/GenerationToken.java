package com.yaqiwe.shop_redis.util;

import java.util.UUID;

/**
 * @Author yaqiwe
 * @Date 2019/12/20 2:44
 * @Version 1.0
 * 生成token
 */
public class GenerationToken {

    public static String getToken(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
