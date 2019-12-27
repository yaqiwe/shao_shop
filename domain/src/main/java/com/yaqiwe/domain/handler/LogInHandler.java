package com.yaqiwe.domain.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author yaqiwe
 * @Date 2019/12/23 16:15
 * @Version 1.0
 * 拦截所有请求
 * 获取请求头中的token
 */
@Slf4j
public class LogInHandler implements HandlerInterceptor {
    /*token名称*/
    private static final String TOKEN_NAME="tokenA";

    public static String token=null;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        token=request.getHeader(TOKEN_NAME);
        log.info("HandlerInterceptor 拦截器工作");
        return true;
    }
}
