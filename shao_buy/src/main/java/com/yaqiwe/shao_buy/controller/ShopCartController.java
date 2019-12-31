package com.yaqiwe.shao_buy.controller;

import com.yaqiwe.domain.dto.CatrDto;
import com.yaqiwe.domain.dto.RedisUserDto;
import com.yaqiwe.domain.entity.commodity;
import com.yaqiwe.domain.handler.LogInHandler;
import com.yaqiwe.domain.service.redisService;
import com.yaqiwe.shao_buy.dto.ShopCartVo;
import com.yaqiwe.shao_buy.service.ShopCartService;
import com.yaqiwe.shao_buy.util.Resoult;
import com.yaqiwe.shao_buy.util.ResoultUtil;
import com.ysqiwe.commodity.feignClient.CommodityFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author yaqiwe
 * @Date 2019/12/24 12:58
 * @Version 1.0
 */
@RestController
@Slf4j
public class ShopCartController {

    @Autowired
    private redisService redisS;

    @Autowired
    private ShopCartService shopCartS;

    @Autowired
    private CommodityFeign commodityF;

    @PostMapping("/addCom")
    public Resoult addComm(@RequestBody List<CatrDto> comList){
        RedisUserDto userInfo = redisS.getUserInfo(LogInHandler.token);
        Long cartId=userInfo.getShopCartId();
        shopCartS.addCom(comList, cartId);
        return getShopList();
    }

    /*查询购物车的所有商品*/
    @PostMapping("/getShopList")
    public Resoult getShopList(){
        RedisUserDto userInfo = redisS.getUserInfo(LogInHandler.token);
        List<CatrDto> catrDtos = shopCartS.getComList(userInfo.getShopCartId());
        //查询相应商品的信息
        List<Long> comId = catrDtos.stream().map(i -> i.getComId()).collect(Collectors.toList());
        List<commodity> comList = commodityF.getComByComId(comId);

        List<ShopCartVo> comVo=new ArrayList<>();
        for (commodity com : comList) {
            ShopCartVo vo=new ShopCartVo();
            BeanUtils.copyProperties(com,vo);
            vo.setComId(com.getComId()+"");
            for (CatrDto Dto : catrDtos) {
                if(vo.getComId().equals(Dto.getComId()+"")){
                    vo.setNumber(Dto.getComNumber());
                    break;
                }
            }
            comVo.add(vo);
        }

        return ResoultUtil.success(comVo);
    }

    /*删除购物车中的商品*/
    @PostMapping("/deleteCom")
    public Resoult deleteCom(@RequestBody Long[] comId){
        RedisUserDto userInfo = redisS.getUserInfo(LogInHandler.token);
        shopCartS.deleteCom(comId,userInfo.getShopCartId());
        return getShopList();
    }
}
