package com.yaqiwe.shao_buy.handler;

import com.yaqiwe.shao_buy.dto.RedisUserDto;
import com.yaqiwe.shao_buy.service.redisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author yaqiwe
 * @Date 2019/12/23 16:15
 * @Version 1.0
 * 登录拦截器，判断是否登录
 * 已登录则获取登录的用户信息
 * 未登录则返回未登录提示
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
        if (!StringUtils.isEmpty(token)) {
            return true;
        }
        return false;
    }
}
