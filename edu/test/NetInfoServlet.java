package com.edu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/netInfo")

public class NetInfoServlet extends HttpServlet {
	
	// HttpServletRequest 인터페이스에서 제공하는 메소드 중에서 서버와 클라이언트의 네트워크 정보를 추출하는 메소드들을 실행한 후 
	// 결과값을 확인하는 예제를 작성해보겠다 
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		out.print("<html>");
		out.print("<head><title>Request 정보 출력</title></head>");
		
		out.print("<body>");
		out.print("<h3>네트워크 관련 요청정보</h3>");
		out.print("Request Scheme : " + req.getScheme()+"<br/>"); // 클라이언트가 사용한 프로토콜 반환 
		out.print("Server Name : " + req.getServerName()+"<br/>"); // 서버의 호스트 이름 반환, 별도의 호스트 이름이 없으면 IP 주소 반환 
		out.print("Server Address : " + req.getLocalAddr()+"<br/>"); // 서비를 요청받은 서버의 IP주소 반환  
		out.print("Server Port : " + req.getServerPort()+"<br/>"); // 서비스를 요청받은 서버의 포트 번호 반환 
		out.print("Client Address : " + req.getRemoteAddr()+"<br/>"); // 서비스를 요청한 클라이언트의 IP 반환 
		out.print("Client Host : " + req.getRemoteHost()+"<br/>"); //  서비스를 요청한 클라이언트의 Host 이름 반환  
		out.print("Client Port : " + req.getRemotePort()); // 클라이언트의 소스 포트 번호 반환

		
		// 127:0:0:1 는 루프백 호스트명으로, 자신의 컴퓨터를 의미한다. 

		out.print("</body>");
		
		
		out.print("</html>");
		
		out.close();
		
	}
	
	

}
