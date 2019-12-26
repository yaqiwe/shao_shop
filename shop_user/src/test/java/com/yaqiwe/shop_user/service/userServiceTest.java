package com.yaqiwe.shop_user.service;

import com.yaqiwe.shop_user.ShopUserApplicationTests;
import com.yaqiwe.shop_user.enums.exceptionEnum;
import com.yaqiwe.shop_user.exception.shopException;
import com.yaqiwe.shop_user.util.exceptioParsing;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/15 16:56
 * @description：
 */
@Component
public class userServiceTest extends ShopUserApplicationTests {
    @Autowired
    userService userS;

    @Test
    @Transactional
    public void registered() {
        String passWoord="123456";
        String userName="yaqiwe2";
        userS.registered(userName,passWoord);

        try {
            userS.registered("",passWoord);
        } catch (ConstraintViolationException e) {
            Assert.assertEquals(exceptioParsing.handleBindGetException(e).getMsg(),"[用户名不能为空]");
        }

        try {
            userS.registered("1234",passWoord);
        } catch (shopException e) {
            Assert.assertEquals("用户名长度不符合要求",e.getMessage());
        }

        try {
            userS.registered(userName,passWoord);
        } catch (shopException e) {
            Assert.assertEquals("用户名已存在",e.getMessage());
        }
    }

    @Test
    public void testLonIn(){
        String userName="yaqiwe";
        String passWord="123456";
        userS.logIn(userName,passWord);

        try {
            userS.logIn(userName,"123");
        } catch (shopException e) {
            Assert.assertEquals(e.getMessage(), exceptionEnum.USER_LOG_IN_ERROR.getMsg());
        }

        try {
            userS.logIn("ya",passWord);
        } catch (shopException e) {
            Assert.assertEquals(e.getMessage(), exceptionEnum.USER_LOG_IN_ERROR.getMsg());
        }

        try {
            userS.logIn("",passWord);
        } catch (ConstraintViolationException e) {
            Assert.assertEquals(exceptioParsing.handleBindGetException(e).getMsg(),"[用户名不能为空]");
        }
    }
}