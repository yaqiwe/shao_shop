package com.yaqiwe.shop_user.service.impl;

import com.yaqiwe.domain.entity.Address;
import com.yaqiwe.shop_user.ShopUserApplicationTests;
import com.yaqiwe.shop_user.service.UserAddressService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author yaqiwe
 * @Date 2019/12/27 22:06
 * @Version 1.0
 */
@Component
public class UserAddressServiceImplTest extends ShopUserApplicationTests {

    @Autowired
    UserAddressService userAddressS;

    private Long userId=405220819019636736L;

    @Test
    public void getAddress() {
        List<Address> address = userAddressS.getAddress(userId);
        Assert.assertTrue(address.size()>0);
    }

    @Test
    @Transactional
    public void addAddress() {
        String address="地址1008611";
        userAddressS.addAddress(address,userId);
    }
}
