package com.edu.test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
// 어노테이션을 통해 web.xml에 등록하지 않아도 바로 리스너 객체로서 사용할 수 있다. 
public class TestServletContextListener implements ServletContextListener{
	
	public TestServletContextListener() {
		
		System.out.println("TestServletContextListener 객체 생성");
	}
	

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		System.out.println("ServletContext 객체 초기화");
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		System.out.println("ServletContext 객체 해제");
		
	}

}
