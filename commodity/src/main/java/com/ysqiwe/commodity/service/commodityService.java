package com.ysqiwe.commodity.service;

import com.github.pagehelper.Page;
import com.yaqiwe.domain.entity.commodity;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/14 17:05
 * @description：商品表操作
 */
@Validated
public interface commodityService {

    /**
     * 查询商品信息列表
     * @param page
     * @param limit
     * @return
     */
    Page<commodity> findComAll(@NotNull(message = "页数不能为空") @Min(message = "每页数据数不能小于0", value = 0) Integer page,
                               @NotNull(message = "每页条数不能为空") @Min(message = "页条数不能小于0", value = 0) Integer limit);


    /**
     * 查询商品详细信息
     * @param comId
     * @return
     */
    commodity getComInfo(long comId);
}
