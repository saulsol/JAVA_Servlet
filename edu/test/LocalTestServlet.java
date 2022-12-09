package com.edu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@ WebServlet("/local")
public class LocalTestServlet extends HttpServlet {
	
	
	String str;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		
		// service() 메소드에 의해서 호출되는 doGet() 메소드다. doGet() 메소드에서 선언된 지역변수는 클라이언트가 요청할때마다 값이 갱신된다.
		
		
		int number = 0;
		str = req.getParameter("msg");
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		out.print("<html><head><title>MultiThread Test</title></head>");
		out.print("<body><h2>처리 결과(지역 변수)</h2>");
		
		while(number++ < 10) {
			out.print(str + " : " + number + "<br>");
			out.flush(); 
			// out 출력 스트림의 버퍼에 있는 내용을 강제로 전송한다. 기본적으로는 버퍼의 크기만큼 내용이 채워졌을 때 실제 전송이 이루어진다.
			// 하지만 flush() 메소드에 의해 스트림에 있는 문자열을 강제로 내보내기 때문에( 버퍼의 가득참 유무에 상관없이) 바로바로 문자가 출력된다. 

			System.out.println(str + " : " + number);
			        
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		
		
		out.println("<h2>Done "+ str + " !!</h2>");
		out.println("</body></html>");
		
		out.close();
	}
	
	
	

}
