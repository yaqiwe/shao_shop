package com.yaqiwe.shop_user.controller;

import com.yaqiwe.domain.dto.RedisUserDto;
import com.yaqiwe.domain.entity.Address;
import com.yaqiwe.domain.handler.LogInHandler;
import com.yaqiwe.domain.service.redisService;
import com.yaqiwe.shop_user.enums.exceptionEnum;
import com.yaqiwe.shop_user.exception.shopException;
import com.yaqiwe.shop_user.service.UserAddressService;
import com.yaqiwe.shop_user.util.Resoult;
import com.yaqiwe.shop_user.util.ResoultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author yaqiwe
 * @Date 2019/12/27 16:53
 * @Version 1.0
 * 用户收货地址
 */
@RestController
@Slf4j
public class AddressController {

    @Autowired
    UserAddressService userAddressS;

    @Autowired
    redisService redisS;


    @PostMapping("/getAddress")
    public Resoult getAddress() {
        RedisUserDto userInfo = redisS.getThisUserInfo();
        List<Address> address = userAddressS.getAddress(userInfo.getUserId());
        return ResoultUtil.success(address);
    }

    @PostMapping("/addAddress")
    public Resoult addAddress(@RequestParam("address") String address) {
        RedisUserDto userInfo = redisS.getThisUserInfo();
        userAddressS.addAddress(address, userInfo.getUserId());
        List<Address> ad = userAddressS.getAddress(userInfo.getUserId());
        return ResoultUtil.success(ad);
    }

    @PostMapping("/deleteAddress")
    public Resoult deleteAddress(@RequestParam("addressId") Long addId) {
        RedisUserDto userInfo = redisS.getThisUserInfo();
        userAddressS.deleteAddress(addId, userInfo.getUserId());
        List<Address> ad = userAddressS.getAddress(userInfo.getUserId());
        return ResoultUtil.success(ad);
    }
}
