package com.ysqiwe.commodity.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ComInfoVo {

    /*商品Id*/
    private long comId;
    /*商品名称*/
    private String comName;
    /*商品描述*/
    private String comDescribe;
    /*商品图片*/
    private String comSrc;
    /*商品单价*/
    private BigDecimal comPrice;
}
