package com.ysqiwe.commodity.service;

import com.yaqiwe.domain.entity.commodity;

import java.util.List;

/**
 * @Author yaqiwe
 * @Date 2019/12/25 10:39
 * @Version 1.0
 * 提供微服务调用的接口
 */
public interface ClientServer {

    /**
     * 根据商品Id列表获取商品信息列表
     * @param comId 商品Id列表
     * @return
     */
    public List<commodity> getComByConId(List<Long> comId);
}
