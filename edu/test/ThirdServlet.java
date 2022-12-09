package com.edu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/third")
public class ThirdServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		
		
		
		PrintWriter out = resp.getWriter(); // 출력 스트림 
		
		int i = 1;
		
		while(i <= 10) {
			
			out.print("<br>number : " + i);
			i++;
			
			
			try {
				Thread.sleep(100);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		
		out.print("<h1>실행 완료! 전방에 외쳐!! 아좌아좌!!!</h1>");
		out.close();
		
		
		//서버가 문자셋 정보를 클라이언트 브라우저에게 전달하지 않으면 브라우저는 이를 기본값으로 처리한다. 
		// 즉, 문서타입은 test/html, 인코딩 문자셋은 8859_1 으로 처리한다. 아쉽게도 한글은 처리해주지 못한다. 
		// 이처럼 한글이 깨지는 것을 방지하려면 서버가 클라이언트로 보내는 데이터의 문자타입과 한글을 지원하는 문자셋을 응답정보 헤더에 설정해서 보내야 한다. 
		
	}
	
	
	
	
}
