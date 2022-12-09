package com.edu.test;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "timer", urlPatterns = "/third")

// urlPatterns : 등록하는 필터의 이름을 지정
// filterName : 등록하는 필터의 이름을 지정

public class FlowFilterThree implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		long startTime = System.currentTimeMillis();
		chain.doFilter(request, response);
		
		long endTime = System.currentTimeMillis();
		
		long executeTime = endTime - startTime;
		System.out.println("수행 시간 : " + executeTime + "ms");
		
	}

	@Override
	public void destroy() {
		
		
	}
	
	

}
