package com.yaqiwe.shao_buy.service;

import com.yaqiwe.domain.dto.CatrDto;

import java.util.List;

/**
 * @Author yaqiwe
 * @Date 2019/12/23 21:25
 * @Version 1.0
 * 商品购物车操作
 */
public interface ShopCartService {

    /**
     * 添加商品到购物车
     * @param dto
     * @return
     */
    public void addCom(List<CatrDto> dto,long cartId);


    /**
     * 查询购物车所有的商品列表
     * @param cartId
     * @return
     */
    public List<CatrDto> getComList(long cartId);
}
