package com.yaqiwe.shao_buy.service.impl;

import com.yaqiwe.domain.dto.CatrDto;
import com.yaqiwe.domain.mapper.shopCartMapper;
import com.yaqiwe.shao_buy.enums.exceptionEnum;
import com.yaqiwe.shao_buy.exception.shopException;
import com.yaqiwe.shao_buy.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author yaqiwe
 * @Date 2019/12/23 21:34
 * @Version 1.0
 */
@Service
public class ShopCartServiceImpl implements ShopCartService {

    @Autowired
    shopCartMapper shopCartM;

    @Override
    public void addCom(List<CatrDto> dto, long cartId) {
        if (dto.size()<0){
            throw new shopException(exceptionEnum.COMMODITY_LIST_NULL);
        }
        for (CatrDto ca : dto) {
            if(ca.getComNumber()<=0){
                throw new shopException(exceptionEnum.COMMODITY_NUMBER_ERROR);
            }
        }
        int i = shopCartM.insertCart(dto, cartId);
    }

    @Override
    public List<CatrDto> getComList(long cartId) {
        return shopCartM.getCartCom(cartId);
    }

    @Override
    public void deleteCom(Long[] comId, Long cartId) {
        if(comId.length<1){
            return;
        }
        shopCartM.deleteComm(comId,cartId);
    }

}
