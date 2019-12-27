package com.yaqiwe.shop_user.service;

import com.yaqiwe.domain.entity.Address;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author yaqiwe
 * @Date 2019/12/26 16:22
 * @Version 1.0
 * 用户收货地址
 */
@Validated
public interface UserAddressService {

    /**
     * 获取用户的收货地址
     * @param userId
     * @return
     */
    public List<Address> getAddress(Long userId);

    /**
     * 添加收货地址
     * @param address
     */
    public void addAddress(@NotBlank(message = "地址不能为空") String address,
                           @NotNull(message = "用户Id不能为空") Long userId);

    public void deleteAddress(@NotNull(message = "地址Id不能为空") Long addId,
                              @NotNull(message = "用户Id不能为空") Long userId);
}
