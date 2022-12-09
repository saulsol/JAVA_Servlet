package com.edu.test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;

@WebServlet("/headerInfo")
public class HeaderInfoServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();

		out.print("<html>");
		out.print("<head><title>Request 정보 출력</title></head>");

		out.print("<body>");
		out.print("<h3>요청 헤더 정보</h3>");
		
		Enumeration<String> em = req.getHeaderNames();
		
		
		
		while(em.hasMoreElements()) {
			String s = em.nextElement();
			out.println(s + " : " + req.getHeader(s) + "<br/>"  );
		}
		
		// Enumeration 객체도 java.util 패키지에 있으며, 배열처럼 데이터 그룹으로 구성된 Collection 객체이다.

		out.print("</body>");


		out.print("</html>");

		out.close();

	}
}
