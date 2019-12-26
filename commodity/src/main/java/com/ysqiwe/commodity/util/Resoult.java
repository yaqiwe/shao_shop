package com.ysqiwe.commodity.util;

import lombok.Data;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/14 17:42
 * @description：数据封装的最外层
 */
@Data
public class Resoult <T> {
    /*状态码*/
    private Integer code;
    /*信息*/
    private String Msg;

    private T data;

}
