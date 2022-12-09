package com.edu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@ WebServlet ("/context1")
public class ServletContextTest1Servlet extends HttpServlet{

	
//	ServletContext sc;
//	// sc 변수는 init() 메소드와 doGet() 메소드에서 사용하기 위해 멤버 변수로 호출했다. 
//	
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		
//		sc = config.getServletContext(); 
//		// 서블릿을 실행할 때 최초 요청이면 ServletConfig 객체가 생성되며 init() 메소드의 인자값으로 전달된다. 
//		// ServletConfig 객체에서 현재 웹 어플리케이션에 할당된 ServletContext 객체의 주솟값을 추출할 수 있다.
//		
//	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		ServletContext sc = this.getServletContext();
		String location = sc.getInitParameter("contextConfig");
		out.print("location : " + location);
		
		out.close();
	}
	
	
	
}
