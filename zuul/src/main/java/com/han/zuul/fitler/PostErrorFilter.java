package com.han.zuul.fitler;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PostErrorFilter extends SendErrorFilter {
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return -1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        return ctx.getThrowable() != null;
    }

    @Override
    public Object run() {
        try {
            RequestContext ctx = RequestContext.getCurrentContext();
            SendErrorFilter.ExceptionHolder exception = this.findZuulException(ctx.getThrowable());
            HttpServletResponse response = ctx.getResponse();
            System.out.println(exception.getThrowable().getMessage());
            response.getWriter().write("Test a error json!");

        } catch (Exception var5) {
            ReflectionUtils.rethrowRuntimeException(var5);
            var5.printStackTrace();
        }

        return null;
    }

}
