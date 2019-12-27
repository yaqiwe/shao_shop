package com.yaqiwe.shop_user.service.impl;

import com.yaqiwe.domain.dto.RedisUserDto;
import com.yaqiwe.domain.entity.user;
import com.yaqiwe.domain.service.redisService;
import com.yaqiwe.shop_user.ShopUserApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.Transient;

/**
 * @Author yaqiwe
 * @Date 2019/12/20 3:09
 * @Version 1.0
 */
@Component
public class redisServiceImplTest extends ShopUserApplicationTests {
    @Autowired
    redisService redisS;

    @Test
    @Transient
    public void pullUserInfo() {
        user us=new user();
        us.setUserId(1234567890L);
        us.setShopCartId(1234567890L);
        us.setUserName("yaqiwe");
        String token = redisS.pullUserInfo(us);

        RedisUserDto userInfo = redisS.getUserInfo(token);
        Assert.assertEquals(userInfo.getShopCartId(),1234567890L);
    }
}
