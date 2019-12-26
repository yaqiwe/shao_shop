package com.yaqiwe.shop_user.controller;

import com.yaqiwe.domain.entity.user;
import com.yaqiwe.shop_user.service.userService;
import com.yaqiwe.shop_user.util.Resoult;
import com.yaqiwe.shop_user.util.ResoultUtil;
import com.yaqiwe.shop_user.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/15 17:19
 * @description：用户操作Controller
 */
@RestController
public class userController {

    @Autowired
    private userService userS;
    @Autowired
    private redisService redisS;


    @PostMapping("/createUser")
    public Resoult createUser(String userName, String passWord){
        userS.registered(userName,passWord);
        return ResoultUtil.success("注册成功");
    }

    @PostMapping("/logIn")
    public Resoult logIn(String userName, String passWord){
        //登录信息校验
        user us = userS.logIn(userName, passWord);
        UserVo vo=new UserVo();
        //存储信息到redis,用token作为key
        String token = redisS.pullUserInfo(us);
        //返回前端的数据
        BeanUtils.copyProperties(us,vo);
        vo.setToken(token);
        return ResoultUtil.success(vo);
    }

}
