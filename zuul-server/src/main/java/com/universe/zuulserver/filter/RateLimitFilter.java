package com.universe.zuulserver.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @author ：yanghuanyu
 * @date ：Created in 2019-09-21 22:42
 * @description： 谷歌guava 限流接口
 * @modified By：
 * @version:
 */
@Component
public class RateLimitFilter extends ZuulFilter {


    //每秒产生1000个令牌
    private static final RateLimiter rateLimiter = RateLimiter.create(1000);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return -4;
    }

    @Override
    public boolean shouldFilter() {

        /**
         *  处理你要限流的接口 ngix lvs + keepalive负载均衡
         */

        return false;
    }

    @Override
    public Object run() throws ZuulException {

        /**
         * 获取上下文对象
         */
        RequestContext currentContext = RequestContext.getCurrentContext();

        //获取令牌
        if(!rateLimiter.tryAcquire()){
            //该方法是是否继续往下走
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());
        }
        return null;
    }
}
