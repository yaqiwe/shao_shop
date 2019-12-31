package com.yaqiwe.domain.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/14 14:45
 * @description：商品信息表类
 */
@Data
public class commodity {
    /*商品Id*/
    private long comId;

    /*商品名称*/
    private String comName;

    /*商品描述*/
    private String comDescribe;

    /*商品图片*/
    private String comSrc;

    /*轮播图的图片,以^%!^分隔*/
    private String showSrc;

    /*详情图片,以^%!^分隔*/
    private String detailsSrc;

    /*商品单价*/
    private BigDecimal comPrice;

    /*商品库存*/
    private Integer comStock;

    /*创建时间*/
    private Timestamp createTime;

    /*更新时间*/
    private Timestamp updateTime;
}
