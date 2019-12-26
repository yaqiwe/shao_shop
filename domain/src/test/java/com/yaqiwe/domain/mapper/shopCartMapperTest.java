package com.yaqiwe.domain.mapper;

import com.yaqiwe.domain.DomainApplicationTests;
import com.yaqiwe.domain.dto.CatrDto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author yaqiwe
 * @Date 2019/12/24 9:56
 * @Version 1.0
 */
@Component
class shopCartMapperTest extends DomainApplicationTests {

    @Autowired
    shopCartMapper shopCartM;

    @Test
    void insertCart() {
        List<CatrDto> lis=new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            CatrDto dto=new CatrDto();
            dto.setComId(12345689);
            dto.setComNumber(i);
            lis.add(dto);
        }
        int i = shopCartM.insertCart(lis, 405220819019640832L);
        Assert.assertTrue(i>0);
    }

    @Test
    void testGetCartCom(){
        long cartId=405220819019640832L;
        List<CatrDto> cartCom = shopCartM.getCartCom(cartId);
        Assert.assertTrue(cartCom.size()!=0);
    }
}