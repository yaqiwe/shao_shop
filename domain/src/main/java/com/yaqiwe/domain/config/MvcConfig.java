package com.yaqiwe.domain.config;

import com.yaqiwe.domain.handler.LogInHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author yaqiwe
 * @Date 2019/12/23 18:55
 * @Version 1.0
 * 拦截器
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInHandler()).addPathPatterns("/**");
    }
}
