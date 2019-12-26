package com.ysqiwe.commodity.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yaqiwe.domain.entity.commodity;
import com.yaqiwe.domain.mapper.CommodityMapper;
import com.ysqiwe.commodity.enums.exceptionEnum;
import com.ysqiwe.commodity.exception.shopException;
import com.ysqiwe.commodity.service.commodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/14 17:27
 * @description：
 */
@Service
public class commodityServiceImpl implements commodityService {


    CommodityMapper commodityM;
    @Autowired
    public void setCommodityM(CommodityMapper commodityM) {
        this.commodityM = commodityM;
    }

    @Override
    public Page<commodity> findComAll(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        return commodityM.fandAll();
    }

    @Override
    public commodity getComInfo(long comId) {
        commodity com = commodityM.findById(comId);
        if(com==null){
            throw new shopException(exceptionEnum.COMMODITY_NULL);
        }
        return com;
    }
}
