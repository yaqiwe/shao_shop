package com.yaqiwe.domain.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Author yaqiwe
 * @Date 2019/12/26 9:21
 * @Version 1.0
 * 收货地址
 */
@Data
public class Address {

    private long addId;

    /*用户Id*/
    private long userId;

    /*地址*/
    private String userAdderss;

    /*创建时间*/
    private Timestamp createTime;

    /*更新时间*/
    private Timestamp updateTime;
}
