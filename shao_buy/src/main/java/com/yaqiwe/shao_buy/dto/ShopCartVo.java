package com.yaqiwe.shao_buy.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @Author yaqiwe
 * @Date 2019/12/25 12:58
 * @Version 1.0
 * 购物车信息vo
 */
@Data
public class ShopCartVo {

    private long comId;

    private String comName;

    private String comDescribe;

    private String comSrc;

    private BigDecimal comPrice;

    private Integer comStock;

    private Integer number;

    private Timestamp createTime;
}
