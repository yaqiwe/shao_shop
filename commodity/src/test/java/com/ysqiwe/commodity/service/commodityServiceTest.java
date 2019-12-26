package com.ysqiwe.commodity.service;

import com.github.pagehelper.Page;
import com.yaqiwe.domain.entity.commodity;
import com.ysqiwe.commodity.CommodityApplicationTests;
import com.ysqiwe.commodity.util.exceptioParsing;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/14 17:37
 * @description：
 */
@Component
@Slf4j
public class commodityServiceTest extends CommodityApplicationTests {
    @Autowired
    commodityService commodityS;

    @Test
    public void findComAll() {
        Page<commodity> comAll = commodityS.findComAll(0, 2);
        Assert.assertTrue(comAll.getResult().size()==2);
    }


    @Test
    public void findComAll2(){
        try {
            commodityS.findComAll(-1,-1);
        } catch (ConstraintViolationException e) {
            Assert.assertEquals(exceptioParsing.handleBindGetException(e).getMsg(),"[页条数不能小于0, 每页数据数不能小于0]");
        }
    }

    @Test
    public void findComAll13(){
        try {
            commodityS.findComAll(null,null);
        } catch (ConstraintViolationException e) {
            Assert.assertEquals(exceptioParsing.handleBindGetException(e).getMsg(),"[页数不能为空, 每页条数不能为空]");
        }
    }

    @Test
    public void testGetComInfo(){
        long id=404477633531875328L;
        commodity comInfo = commodityS.getComInfo(id);
        log.info("ComInfo : {}",comInfo);
        Assert.assertNotNull(comInfo);
    }


}