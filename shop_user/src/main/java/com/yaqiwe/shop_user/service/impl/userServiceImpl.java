package com.yaqiwe.shop_user.service.impl;

import com.yaqiwe.domain.entity.user;
import com.yaqiwe.domain.mapper.userMapper;
import com.yaqiwe.domain.util.UserIdUtil;
import com.yaqiwe.shop_user.enums.exceptionEnum;
import com.yaqiwe.shop_user.exception.shopException;
import com.yaqiwe.shop_user.service.userService;
import com.yaqiwe.shop_user.util.encryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/15 16:14
 * @description：
 */
@Service
public class userServiceImpl implements userService {
    @Autowired
    userMapper userM;


    @Override
    public void registered(String userName, String passWord) {
        if(userName.length()<6 || userName.length()>18)
            throw new shopException(exceptionEnum.USER_NAME_LONG_ERROR);
        if(passWord.length()<6 || passWord.length()>18)
            throw new shopException(exceptionEnum.USER_PASSOWRD_LONG_ERROR);
        user us = userM.findByUserName(userName);
        if(us!=null)
            throw new shopException(exceptionEnum.USER_REPEAT);
        //创建用户
        us=new user();
        us.setUserName(userName);
        us.setUserId(UserIdUtil.getUserId());
        us.setShopCartId(UserIdUtil.getCartId());
        //存入加密的密码
        us.setPassWord(encryptionUtil.encryption(passWord,String.valueOf(us.getUserId())));
        int inserSql = userM.insertUser(us);
        if(inserSql!=1)
            throw new shopException(exceptionEnum.USER_REPEAT);
    }

    @Override
    public user logIn(String userName, String passWord) {
        user us = userM.findByUserName(userName);
        if(us!=null){
            //加密后的密码
            String encPassWord=encryptionUtil.encryption(passWord,String.valueOf(us.getUserId()));
            if(encPassWord.equals(us.getPassWord())){
                //登录成功返回用户信息
                return us;
            }
        }
        throw new shopException(exceptionEnum.USER_LOG_IN_ERROR);

    }

}
