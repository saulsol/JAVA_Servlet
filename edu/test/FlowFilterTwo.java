package com.edu.test;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FlowFilterTwo implements Filter {
	
	String charset;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter init() 호출...two");
		charset = filterConfig.getInitParameter("en");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		request.setCharacterEncoding(charset);
		System.out.println("doFiter() 호출 전...two");
		response.setContentType("text/html;charset=UTF-8");
		// 필터를 통한 response 객체에게 미리 인코딩 타입을 알려주었다. 
		// 필터 내부적으로 처리하고 싶은 로직이 있다면 doFilter() 이전에 설정해야 한다.  
		chain.doFilter(request, response);
		
		// 인코딩은 내가 들어온 문자열을 알아서 변환시키는 것이 아니라 
		// 미리 문자열을 받는 객체에게 인코딩 타입을 알려줘서 문자열을 그 타입에 맞게끔 받는 것이다
	
		System.out.println("doFiter() 호출 후...two");
		
	}

	@Override
	public void destroy() {
		
		System.out.println("destroy() 호출...two");
		
	}

}
