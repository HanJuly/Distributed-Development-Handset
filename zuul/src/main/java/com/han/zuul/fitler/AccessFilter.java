package com.han.zuul.fitler;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.context.annotation.FilterType;

public class AccessFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return -4;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        try {
            System.out.println("Self define filter.");
//            int i = 1/0;
        } catch (Exception e) {
           throw new ZuulException(e,500,"This is test exception in access filter.");
        }
        return null;
    }
}
