package com.edu.test;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/queryTest3")

public class QueryTest3Servlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.print("<html><head><title>문자열 테스트</title><head>");
		out.print("<body>");
		out.print("<h1>GET 방식으로 요청되었습니다</h1>");
		
		String name = req.getParameter("name");
		out.print("이름 : " + name + "<br/>" );
		
		out.print("</body></html>");
		
		out.close();
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//POST 방식으로 전달된 질의 문자열들은 GET 방식으로 전달될 때와 달리 인코딩/디코딩 작업이 필요하다.
		
		resp.setContentType("text/html;charset=UTF-8");//resp 객체에 담아 브라우저로 보내는 경우 인코딩 방식 지정 
		PrintWriter out = resp.getWriter();
		
		out.print("<html><head><title>문자열 테스트</title><head>");
		out.print("<body>");
		out.print("<h1>POST 방식으로 요청되었습니다</h1>");
		
		
		req.setCharacterEncoding("UTF-8"); // req객체에서 데이터를 꺼내는 경우 인코딩 방식 지정 
		String name = req.getParameter("name");
		out.print("이름 : " + name + "<br/>" );
		
		out.print("</body></html>");
		
		out.close();
		
	}
	
	
	
	
	
}
