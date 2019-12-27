package com.yaqiwe.domain.mapper;

import com.yaqiwe.domain.DomainApplicationTests;
import com.yaqiwe.domain.entity.Address;
import com.yaqiwe.domain.util.UserIdUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author yaqiwe
 * @Date 2019/12/26 9:34
 * @Version 1.0
 */
@Component
class AddressMapperTest extends DomainApplicationTests {

    @Autowired
    AddressMapper addressM;

    long userId=405220819019636736L;

    @Test
    @Transactional
    void insertAddress() {
        Address address=new Address();
        address.setUserId(userId);
        address.setAddId(UserIdUtil.getAddId());
        address.setUserAdderss("第一地狱");
        int i = addressM.insertAddress(address);
        Assert.assertTrue(i>0);
    }

    @Test
    void testGetAddress(){
        List<Address> address = addressM.getAddress(userId);
        Assert.assertTrue(address.size()>0);
    }

    @Test
    @Transactional
    void testDeleteAddress(){
        Long addId=407510645379174400L;
        int i = addressM.deleteAddress(addId, userId);
        Assert.assertTrue(i==1);
    }
}