package com.ysqiwe.commodity.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yaqiwe.domain.entity.commodity;
import com.yaqiwe.domain.mapper.CommodityMapper;
import com.ysqiwe.commodity.enums.exceptionEnum;
import com.ysqiwe.commodity.exception.shopException;
import com.ysqiwe.commodity.service.commodityService;
import com.ysqiwe.commodity.vo.ComInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/14 17:27
 * @description：
 */
@Service
public class commodityServiceImpl implements commodityService {

    /*切割图片地址，获得图片地址的列表*/
    private static String imageSplit="%#06#%";


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
    public ComInfoVo getComInfo(long comId) {
        commodity com = commodityM.findById(comId);
        if(com==null){
            throw new shopException(exceptionEnum.COMMODITY_NULL);
        }
        ComInfoVo vo=new ComInfoVo();
        BeanUtils.copyProperties(com,vo);
        //将图片地址转化为列表
        vo.setShowSrc(com.getShowSrc().split(imageSplit));
        vo.setDetailsSrc(com.getDetailsSrc().split(imageSplit));
        return vo;
    }
}
