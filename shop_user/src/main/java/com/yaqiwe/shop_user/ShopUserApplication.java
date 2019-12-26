package com.yaqiwe.shop_user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.yaqiwe.domain")
public class ShopUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopUserApplication.class, args);
    }

}
