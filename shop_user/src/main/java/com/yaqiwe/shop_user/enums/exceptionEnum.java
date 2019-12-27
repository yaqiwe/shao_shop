package com.yaqiwe.shop_user.enums;

import lombok.Getter;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/14 17:46
 * @description：错误类型枚举类
 */
@Getter
public enum exceptionEnum {
    UNKNOWN_ERROR(500,"未知错误"),
    PARAMETER_ERROR(501,"参数校验错误"),

    USER_NAME_LONG_ERROR(1001,"用户名长度不符合要求"),
    USER_PASSOWRD_LONG_ERROR(1002,"密码不符合要求"),
    USER_REPEAT(1003,"用户名已存在"),
    USER_REGISTERED(1004,"注册失败请稍后重试"),
    USER_LOG_IN_ERROR(1005,"用户名或密码错误"),
    USER_NO_LOG_IN(1006,"用户未登录"),

    COMMODITY_NULL(2001,"查找的商品不存在"),

    ADDRESS_ADD_ERROR(3001,"添加地址失败"),
    ADDRESS_DELETE_ERROR(3002,"删除地址失败"),
    ;

    private Integer code;
    private String msg;

     exceptionEnum(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }
}
