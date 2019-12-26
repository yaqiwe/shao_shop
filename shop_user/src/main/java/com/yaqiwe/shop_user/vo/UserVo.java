package com.yaqiwe.shop_user.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserVo {

    /*用户Id*/
    private long userId;

    /*用户名*/
    private String userName;

    /*性别1男性0女性2未设置*/
    private Integer save=2;

    /*生日*/
    private Timestamp dataOfBirth;

    /*注册时间*/
    private Timestamp createTime;

    /*登录状态码*/
    private String token;

}
