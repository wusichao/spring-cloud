package com.wusc.apigateway;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class ApiGagewayFilter extends ZuulFilter{

	@Override
	public Object run() {
		System.out.println("请求进入网关过滤器");
		RequestContext rct = RequestContext.getCurrentContext();
		HttpServletRequest request=rct.getRequest();
		String token=request.getHeader("token");
			if(!"wusc".equals(token)){
				rct.setSendZuulResponse(false);
				rct.setResponseStatusCode(401);
				rct.setResponseBody("请登录");
				return null;
			}
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
