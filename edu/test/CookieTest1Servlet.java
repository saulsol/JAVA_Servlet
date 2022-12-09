package com.edu.test;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;


@WebServlet("/cookie1")
public class CookieTest1Servlet extends HttpServlet  {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		
		Cookie c1 = new Cookie("id", "guest"); // 쿠키의 이름은 "id", 값은 "guest"
		c1.setPath("/"); // 경로를 루트로 지정 따라서 현재 웹 애플리케이션애 있는 모든 요청에 대하여 클라이언트 쪽의 쿠키가 전송되도록 함 
		resp.addCookie(c1); // c1 쿠키를 클라이언트 쪽으로 전송
		// c1 쿠키는 유효시간을 지정하지 않았다 --> 유효 시간을 지정하지 않으면 -1로 지정됨 
		// 따라서 음수값이므로 브라우저가 종료됨가 동시에 서버로 전송받은 쿠키도 사라진다. 
		
		Cookie c2 = new Cookie("code", "0001");
		c2.setMaxAge(60 * 60 * 3); // 60초(1분) * 60개 ==> 1시간 * 3 ==> 3시간
		c2.setPath("/");
		resp.addCookie(c2);
		
		
		Cookie c3 = new Cookie("subject", "java");
		c3.setMaxAge(60 * 60 * 24 * 10); //24시간 * 10 ==> 10일
		c3.setPath("/");
		resp.addCookie(c3);
		
		out.print("쿠키 전송 완료");
		out.close();
		
	}
	
	
	
	
	
}
