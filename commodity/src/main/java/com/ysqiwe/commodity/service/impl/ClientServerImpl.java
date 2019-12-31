package com.ysqiwe.commodity.service.impl;

import com.yaqiwe.domain.entity.commodity;
import com.yaqiwe.domain.mapper.CommodityMapper;
import com.ysqiwe.commodity.service.ClientServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yaqiwe
 * @Date 2019/12/25 10:46
 * @Version 1.0
 */
@Service
@Slf4j
public class ClientServerImpl implements ClientServer {

    @Autowired
    CommodityMapper commodityM;

    @Override
    public List<commodity> getComByConId(List<Long> comId) {
        if(comId.size()<1){
            return new ArrayList<commodity>();
        }
        return commodityM.getComByComId(comId);
    }
}
