package com.edu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class InitParamServlet extends HttpServlet{

	// init() 메소드를 재정의하여 ServletConfig 갹체를 init() 메소드의 인자로 받아서 
	// web.xml 파일에 <servlet> 태그로 설정한 서블릿 정보를 추출하여 확인하는 예제이다.
	private static final long serialVersionUID = 1L;
	
	String id, password;
	
	
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		id = config.getInitParameter("id");
		password = config.getInitParameter("password");
		
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print("<h2>서블릿 초기 변수</h2>");
		out.print("<h3>ID : "+ id + "</h3>");
		out.print("<h3>PASSWORD : "+ password + "</h3>");
		out.close();
		
	}
	
	
	
	

}
