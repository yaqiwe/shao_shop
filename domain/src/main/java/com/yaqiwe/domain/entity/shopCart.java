package com.yaqiwe.domain.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Author yaqiwe
 * @Date 2019/12/23 21:42
 * @Version 1.0
 * 购物车表
 */
@Data
public class shopCart {
    /*购物车ID*/
    private long cartId;
    /*商品ID*/
    private long comId;
    /*商品数量*/
    private Integer comNumber;
    /*添加时间*/
    private Timestamp createTime;
    /*更新时间*/
    private Timestamp updateTime;
}
