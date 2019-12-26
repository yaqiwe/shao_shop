package com.yaqiwe.shao_buy.service.impl;

import com.yaqiwe.domain.dto.CatrDto;
import com.yaqiwe.domain.mapper.shopCartMapper;
import com.yaqiwe.shao_buy.ShaoBuyApplicationTests;
import com.yaqiwe.shao_buy.service.ShopCartService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yaqiwe
 * @Date 2019/12/24 11:03
 * @Version 1.0
 */
@Component
class ShopCartImplTest extends ShaoBuyApplicationTests {

    @Autowired
    ShopCartService shopCartS;


    @Test
    @Transactional
    void addCom() {
        List<CatrDto> lis=new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            CatrDto dto=new CatrDto();
            dto.setComId(12345689+i);
            dto.setComNumber(i);
            lis.add(dto);
        }
        shopCartS.addCom(lis, 405220819019640832L);
    }
}