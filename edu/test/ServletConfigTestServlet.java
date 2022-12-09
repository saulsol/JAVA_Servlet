package com.edu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletConfigTestServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
	
		
		String env = this.getInitParameter("charset");
		req.setCharacterEncoding(env); // setCharacterEncoding("UTF-8");
		
		// 소스코드를 수정하지 않고도 소스코드 외부에서 값을 지정후 수정할 수 있는 방법
		// 프로그램 유지 보수에 훨씬 효과적이다 
		
		out.print("<h3> 이름 : " + req.getParameter("name"));
		
		out.close();
		
		
	}
}
