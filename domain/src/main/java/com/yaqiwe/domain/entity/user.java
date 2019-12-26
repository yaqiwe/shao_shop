package com.yaqiwe.domain.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/15 15:33
 * @description：用户实体类
 */
@Data
public class user {
    /*用户Id*/
    private long userId;

    /*用户名*/
    private String userName;

    /*用户密码*/
    private String passWord;

    /*性别1男性0女性2未设置*/
    private Integer save=2;

    /*生日*/
    private Timestamp dataOfBirth;

    /*购物车Id*/
    private long shopCartId;

    /*注册时间*/
    private Timestamp createTime;

    /*修改时间*/
    private Timestamp updateTime;
}
