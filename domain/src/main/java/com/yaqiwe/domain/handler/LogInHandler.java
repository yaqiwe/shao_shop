package com.yaqiwe.domain.handler;

import com.yaqiwe.domain.service.redisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
public class LogInHandler implements HandlerInterceptor {
    /*token名称*/
    private static final String TOKEN_NAME="tokenA";

    public static String token=null;

    @Autowired
    private redisService redisS;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        token=request.getHeader(TOKEN_NAME);
        return true;
    }
}
