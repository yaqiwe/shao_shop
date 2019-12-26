package com.ysqiwe.commodity.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/15 14:26
 * @description：商品列表VO
 */
@Data
public class comVo {
    /*商品Id*/
    private String comId;
    /*商品名称*/
    private String comName;
    /*商品图片*/
    private String comSrc;
    /*商品单价*/
    private BigDecimal comPrice;
}
