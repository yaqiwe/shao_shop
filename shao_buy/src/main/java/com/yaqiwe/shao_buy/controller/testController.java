package com.yaqiwe.shao_buy.controller;

import com.yaqiwe.shao_buy.dto.RedisUserDto;
import com.yaqiwe.shao_buy.handler.LogInHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yaqiwe
 * @Date 2019/12/23 16:43
 * @Version 1.0
 */
@RestController
public class testController {

    @GetMapping("testCart")
    public String getUserInfo(){
        return LogInHandler.token;
    }
}
