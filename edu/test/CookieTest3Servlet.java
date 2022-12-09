package com.edu.test;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/cookie3")
public class CookieTest3Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int cnt = 0; 
		
		Cookie [] list = req.getCookies();
		
		for(int i=0; list != null && i < list.length; i++ ) {
			
			if(list[i].getName().equals("count")) {
				cnt = Integer.parseInt(list[i].getValue()); //문자열로 저장했기 때문에 int 값으로 변환했다. 
			}
		}
		
		cnt++;
		// 최초 요청일 경우에는 상단에 있는 for문은 실행되지 않고(count 쿠키가 아직 없으니까) cnt 는 1이 올라간다. 
		
		Cookie c = new Cookie("count", cnt+""); // 쿠키 값을 갱신
		// 쿠키는 String 타입의 값만 허용하기 때문에 문자열로 변형시켰다.
		c.setMaxAge(60*60*24*10);
		resp.addCookie(c);
		
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.print("<h1>방문 횟수 :"+cnt+" </h1>");
	}
	

}
