package com.edu.test;

import javax.servlet.*;


public class TestRequestListener implements ServletRequestListener{
	
	
	public TestRequestListener() {
		
		System.out.println("TestRequestListener 객체 생성");
	}
	
	

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		
		System.out.println("HttpServletRequest 객체 해제");
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		
		System.out.println("HttpServletRequest 객체 초기화");
		
	}

}
