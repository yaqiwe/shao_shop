package com.yaqiwe.shao_buy.enums;

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

    COMMODITY_LIST_NULL(2002,"商品信息不能为空"),
    COMMODITY_NUMBER_ERROR(2003,"商品信数量错误"),
    ;

    private Integer code;
    private String msg;

     exceptionEnum(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }
}
