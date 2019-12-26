package com.eyaqiwe.get_api.filter;

import com.eyaqiwe.get_api.dto.RedisUserDto;
import com.eyaqiwe.get_api.service.redisService;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @Author yaqiwe
 * @Date 2019/12/19 23:23
 * @Version 1.0
 * 登录token拦截
 */
@Component
@Slf4j
public class TokenFilter extends ZuulFilter {
    /*token名称*/
    private static final String TOKEN_NAME="tokenA";

    @Autowired
    redisService redisS;

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        String[] noIntercept={"/user/createUser", "/user/logIn"
                ,"/commodity/getComList","/commodity/details"};
        String reqUrI= RequestContext.getCurrentContext().getRequest().getRequestURI();
        log.info("shouldFilter URI {}",reqUrI);
        for (String url : noIntercept) {
            if(url.equals(reqUrI)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request=requestContext.getRequest();
        //从请求头中获取token
        String token=request.getHeader(TOKEN_NAME);
        log.info("TokenFilter TOKEN : {}",token);
        if (StringUtils.isEmpty(token)){
            //过滤该请求
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseBody("no logIn");
            return null;
        }
        RedisUserDto d = redisS.getUserInfo(token);
        log.info("TokenFilter RedisUserDto : {}",d);
        if(d==null){
            //过滤该请求
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseBody("no logIn");
        }

        return null;
    }
}
