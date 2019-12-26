package com.ysqiwe.commodity.controller;

import com.github.pagehelper.Page;
import com.yaqiwe.domain.entity.commodity;
import com.ysqiwe.commodity.service.commodityService;
import com.ysqiwe.commodity.util.Resoult;
import com.ysqiwe.commodity.util.ResoultUtil;
import com.ysqiwe.commodity.vo.ComInfoVo;
import com.ysqiwe.commodity.vo.comVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/14 17:53
 * @description：商品信息controller
 */
@RestController
public class CommodityController {

    @Autowired
    commodityService commodityS;

    /*商品列表*/
    @GetMapping("/getComList")
    public Resoult getComList(Integer Page, Integer limit){
        Page<commodity> comAll = commodityS.findComAll(Page, limit);
        List<commodity> result = comAll.getResult();
        List<comVo> voList=new ArrayList<>();
        for (int i = 0,j=result.size(); i < j; i++) {
            comVo vo=new comVo();
            BeanUtils.copyProperties(result.get(i),vo);
            vo.setComId(result.get(i).getComId()+"");
            voList.add(vo);
        }
        Map<String, Object> map=new HashMap<>();
        map.put("totalPage",comAll.getPages());
        map.put("commodityList",voList);
        return ResoultUtil.success(map);
    }

    /*商品详情*/
    @GetMapping("/details")
    public Resoult details(long comId){
        commodity comInfo = commodityS.getComInfo(comId);
        //TODO 添加浏览记录
        ComInfoVo vo=new ComInfoVo();
        BeanUtils.copyProperties(comInfo,vo);
        return ResoultUtil.success(vo);
    }
}
