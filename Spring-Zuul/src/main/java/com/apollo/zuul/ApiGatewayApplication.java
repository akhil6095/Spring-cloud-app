package com.apollo.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Akhil.Chaurasia on 28-11-2016.
 */
public class ApiGatewayApplication extends ZuulFilter {


    @Override
    public String filterType() {
        System.out.print("pre");
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        System.out.print(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        return null;
    }
}
