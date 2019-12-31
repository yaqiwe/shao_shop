package com.yaqiwe.shao_buy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.yaqiwe")
@EnableDiscoveryClient
@MapperScan(basePackages = "com.yaqiwe.domain")
@EnableFeignClients(basePackages = "com.ysqiwe.commodity")
public class ShaoBuyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShaoBuyApplication.class, args);
    }

}
