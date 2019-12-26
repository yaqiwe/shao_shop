package com.yaqiwe.domain.mapper;

import com.yaqiwe.domain.DomainApplicationTests;
import com.yaqiwe.domain.entity.user;
import com.yaqiwe.domain.util.UserIdUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/15 15:54
 * @description：
 */
@Component
class userMapperTest extends DomainApplicationTests {

    @Autowired
    userMapper userM;


    @Test
    @Transactional
    void insertUser() {
        user us=new user();
        us.setUserId(UserIdUtil.getUserId());
        us.setUserName("yaqiwe56");
        us.setPassWord("123456");
        us.setShopCartId(UserIdUtil.getCartId());
        int i = userM.insertUser(us);
        Assert.assertTrue(i==1);
    }

    @Test
    void findByUserNameTest(){
        String userName="yaqiwe";
        user us = userM.findByUserName(userName);
        Assert.assertEquals(us.getUserName(),userName);
    }

    @Test
    void findByUserNameTest1(){
        String userName="aaaaaa";
        user us = userM.findByUserName(userName);
        Assert.assertNull(us);
    }
}