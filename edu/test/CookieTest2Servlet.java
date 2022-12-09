package com.edu.test;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;


@WebServlet("/cookie2")
public class CookieTest2Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		Cookie [] list = req.getCookies(); 
		// 쿨라이언트로 전송된 쿠키를 서버 쪽에서 읽어 들이려면 HttpServletRequst 객체의 getCookies() 메소드를 이용해야 한다. 
		
		for(int i=0; list!=null && i<list.length; i++) 
			out.println(list[i].getName() + " : " + list[i].getValue() + "<br>" );
		
		
		out.close();
	}
	
	
	
}
