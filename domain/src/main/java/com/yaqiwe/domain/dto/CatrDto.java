package com.yaqiwe.domain.dto;

import lombok.Data;

/**
 * @Author yaqiwe
 * @Date 2019/12/23 21:27
 * @Version 1.0
 * 添加购物车的dto
 */
@Data
public class CatrDto {
    /*商品Id*/
    private long comId;

    /*商品数量*/
    private Integer comNumber;
}
