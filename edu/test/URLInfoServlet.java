package com.edu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet ("/urlInfo")
public class URLInfoServlet extends HttpServlet {
	// 클라이언트가 서비스를 요청했을 때 HTTP프로토콜에 의해 요청정보가 웹 서버에 전달된다. 
	// 요청정보 헤더의 첫번째 줄에는 요청방식, URI, HTTP 버젼정보 이렇게 3개의 정보가 들어간다 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();

		out.print("<html>");
		out.print("<head><title>Request 정보 출력</title></head>");

		out.print("<body>");
		out.print("<h3>네트워크 관련 요청정보</h3>");
		out.print("Request URI : " + req.getRequestURI()+"<br/>"); // 요청정보 헤더에서 URI 추출 
		out.print("Request URL : " + req.getRequestURL()+"<br/>"); // 요청정보 헤더에서 URL 추출
		out.print("Context Path : " + req.getContextPath()+"<br/>"); // 웹 어플리케이션의 경로 정보 추출 
		out.print("Request Protocol : " + req.getProtocol()+"<br/>"); // 
		out.print("Servlet Path : " + req.getServletPath()+"<br/>"); // 
		


		// 127:0:0:1 는 루프백 호스트명으로, 자신의 컴퓨터를 의미한다. 

		out.print("</body>");


		out.print("</html>");

		out.close();

	}

}
