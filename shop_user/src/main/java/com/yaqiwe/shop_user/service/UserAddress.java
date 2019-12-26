package com.yaqiwe.shop_user.service;

import com.yaqiwe.domain.entity.Address;

import java.util.List;

/**
 * @Author yaqiwe
 * @Date 2019/12/26 16:22
 * @Version 1.0
 * 用户收货地址
 */
public interface UserAddress {

    /**
     * 获取用户的收货地址
     * @param userId
     * @return
     */
    public List<Address> getAddress(Long userId);
}
