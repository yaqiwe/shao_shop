package com.yaqiwe.shop_user.service.impl;

import com.yaqiwe.domain.entity.Address;
import com.yaqiwe.domain.mapper.AddressMapper;
import com.yaqiwe.domain.util.UserIdUtil;
import com.yaqiwe.shop_user.enums.exceptionEnum;
import com.yaqiwe.shop_user.exception.shopException;
import com.yaqiwe.shop_user.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author yaqiwe
 * @Date 2019/12/26 19:57
 * @Version 1.0
 */
@Service
public class UserAddressServiceImpl implements UserAddressService {

    @Autowired
    AddressMapper addressM;

    @Override
    public List<Address> getAddress(Long userId) {
        List<Address> address = addressM.getAddress(userId);
        return address;
    }

    @Override
    public void addAddress(String address, Long userId) {
        long addId = UserIdUtil.getAddId();
        Address ad = new Address();
        ad.setAddId(addId);
        ad.setUserAdderss(address);
        ad.setUserId(userId);
        int i = addressM.insertAddress(ad);
        if (i != 1) {
            throw new shopException(exceptionEnum.ADDRESS_ADD_ERROR);
        }
    }

    @Override
    public void deleteAddress(Long addId, Long userId) {
        int i = addressM.deleteAddress(addId, userId);
        if (i!=1){
            throw new shopException(exceptionEnum.ADDRESS_DELETE_ERROR);
        }
    }
}
