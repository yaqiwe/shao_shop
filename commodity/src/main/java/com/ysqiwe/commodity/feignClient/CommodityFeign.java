package com.ysqiwe.commodity.feignClient;

import com.yaqiwe.domain.entity.commodity;
import com.ysqiwe.commodity.util.Resoult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Author yaqiwe
 * @Date 2019/12/25 11:27
 * @Version 1.0
 * 提供其他微服务调用的Feign
 */
@FeignClient(name = "shopCommodity")
public interface CommodityFeign {

    @PostMapping("/getComByComId")
    public List<commodity> getComByComId(@RequestBody List<Long> comId);
}
