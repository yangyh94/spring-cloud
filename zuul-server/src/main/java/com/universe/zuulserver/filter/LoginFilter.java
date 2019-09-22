package com.universe.zuulserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @author ：yanghuanyu
 * @date ：Created in 2019-09-21 21:31
 * @description：登录过滤器
 * @modified By：
 * @version:
 */
@Component
public class LoginFilter extends ZuulFilter {
    /**
     * 过滤类型 前置过滤
     */
    @Override
    public String filterType() {

        return PRE_TYPE;
    }

    /**
     * 过滤器顺序 ，越小越先执行
     */
    @Override
    public int filterOrder() {
        return 4;
    }

    /**
     * 过滤器是否生效
     */
    @Override
    public boolean shouldFilter() {

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        System.out.println(request.getRequestURI());//不带域名
        System.out.println(request.getRequestURL());//带域名

        return true;
    }

    /**
     * 业务逻辑的处理
     * shouldFilter() 返回 TRUE 就会被拦截
     * Guava 限流（谷歌开源框架）
     */
    @Override
    public Object run() throws ZuulException {

        /**
         * 获取上下文对象
         */
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();


        return null;
    }
}
