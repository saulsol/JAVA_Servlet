package com.edu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/dispatcher1")
public class DispatcherTest1Servlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.print("<h3>Dispatcher Test1의 수행결과</h3>");
		
		ServletContext sc = this.getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/dispatcher2");
		
		
		rd.include(req, resp);
		// RequestDispatcher rd 객체가 가지고 있는 path에 해당하는 페이지로 이동한다. 
		// forward() 메소드로 이동하므로 이동한 페이지에서 클라이언트 측으로 응답을 보낸다. 
		// forward() 메소드로 이동하면서 인자값으로 req, resp를 전달한다. 
		// 즉 현재 페이지가 사용하는 req,resp를 이동한 페이지에 그대로 전달한다. 
		
		// 이동한 페이지에서 사용하는 req, resp 객체는 forward()메소드에서 전달한 객체이다.
		
		out.close();
	}
	
	
	
}
