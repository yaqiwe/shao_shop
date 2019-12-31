package com.yaqiwe.domain.mapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yaqiwe.domain.DomainApplicationTests;
import com.yaqiwe.domain.entity.commodity;
import com.yaqiwe.domain.util.generationIdUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/14 15:18
 * @description：
 */
@Component
@Slf4j
class commodityMapperTest extends DomainApplicationTests {

    @Autowired
    CommodityMapper commodityM;


    @Test
    @Transactional
    void insertCom() {
        commodity com=new commodity();
        com.setComPrice(new BigDecimal("50.25"));
        com.setComStock(200);
        com.setComSrc("https://img.alicdn.com/top/i1/TB1bTtALNjaK1RjSZKzSutVwXXa.jpg");
        String[] showSrcList={
                "https://img.alicdn.com/imgextra/i2/2926218234/O1CN01LzEQhX2AhDlnctegz_!!2926218234.jpg",
                "https://img.alicdn.com/imgextra/i1/2926218234/O1CN01GFwzil2AhDlncuf1U_!!2926218234.jpg",
                "https://img.alicdn.com/imgextra/i4/2926218234/O1CN019dUoKq2AhDkduV3QQ_!!2926218234.jpg",
        };
        String[] detailsSrcList={
                "https://img.alicdn.com/imgextra/i1/2926218234/O1CN01lTUgxN2AhDklXWT5m_!!2926218234.jpg",
                "https://img.alicdn.com/imgextra/i1/2926218234/O1CN0156158g2AhDko34Clc_!!2926218234.jpg",
                "https://img.alicdn.com/imgextra/i4/2926218234/O1CN01vZ1oWv2AhDklXVjNI_!!2926218234.jpg",
                "https://img.alicdn.com/imgextra/i1/2926218234/O1CN01lTUgxN2AhDklXWT5m_!!2926218234.jpg",
                "https://img.alicdn.com/imgextra/i2/2926218234/O1CN01qEpNFY2AhDkmGTpHA_!!2926218234.jpg",
        };
        String showSrc="";
        for (int i = 0,j=showSrcList.length; i < j; i++) {
            showSrc+=showSrcList[i];
            if(i<j-1){
                showSrc+="%#06#%";
            }
        }
        String detailsSrc="";
        for (int i = 0,j=detailsSrcList.length; i < j; i++) {
            detailsSrc+=detailsSrcList[i];
            if(i<j-1){
                detailsSrc+="%#06#%";
            }
        }
        for (int i = 0; i < 100; i++) {
            com.setComId(generationIdUtil.getId());
            com.setComName("商品"+i);
            com.setComDescribe("商品描述"+i);
            com.setShowSrc(showSrc);
            com.setDetailsSrc(detailsSrc);
            int i1 = commodityM.insertCom(com);
            Assert.assertTrue(i1==1);
        }
    }

    @Test
    void testFindAll(){
        PageHelper.startPage(0,10);
        Page<commodity> comPage = commodityM.fandAll();
        Assert.assertTrue(comPage.getResult().size()==10);
        log.info("comPage : {}" ,comPage.toString());
    }

    @Test
    void testGetComByComId(){
        List<Long> list=new ArrayList<>();
        list.add(404477633531875328L);
        list.add(404477634542702592L);
        list.add(404477634559479808L);
        list.add(404477634576257024L);
        list.add(404477634593034240L);
        List<commodity> comByComId = commodityM.getComByComId(list);
        Assert.assertTrue(comByComId.size()==list.size());
    }
}