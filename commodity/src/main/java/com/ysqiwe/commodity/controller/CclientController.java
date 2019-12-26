package com.ysqiwe.commodity.controller;

import com.yaqiwe.domain.entity.commodity;
import com.ysqiwe.commodity.service.ClientServer;
import com.ysqiwe.commodity.util.Resoult;
import com.ysqiwe.commodity.util.ResoultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author yaqiwe
 * @Date 2019/12/25 0:11
 * @Version 1.0
 * 提供给微服务调用的接口
 */
@RestController
public class CclientController {
    @Autowired
    ClientServer clientS;

    /*根据商品id获取商品信息*/
    @PostMapping("/getComByComId")
    public List<commodity> getComByComId(@RequestBody List<Long> comId){
        List<commodity> comByConId = clientS.getComByConId(comId);
        return comByConId;
    }
}
