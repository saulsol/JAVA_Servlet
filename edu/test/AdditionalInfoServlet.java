package com.edu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

//@WebServlet ("/addInfo")
public class AdditionalInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();

		out.print("<html>");
		out.print("<head><title>Request 정보 출력</title></head>");

		out.print("<body>");
		out.print("<h3>추가적인 요청 정보</h3>");
		out.print("Request Method : " + req.getMethod()+"<br/>"); //
		out.print("Path Info : " + req.getPathInfo()+"<br/>"); // 
		out.print("Path Translated: " + req.getPathTranslated()+"<br/>"); // 
		out.print("Query String : " + req.getQueryString()+"<br/>"); // 메소드 요청 URL에서 ? 기호를 찾아서 기호 다음에 있는 문자열 전체를 추출하여 반환 
		out.print("Content Length : " + req.getContentLength()+"<br/>"); // 요청정보 몸체에 있는 데이터의 길이를 추출 
		out.print("Content Type : " + req.getContentType()+"<br/>"); // 요청정보 몸체에 있는 데이터의 문서타입을 추출 
		

		// 127:0:0:1 는 루프백 호스트명으로, 자신의 컴퓨터를 의미한다. 

		out.print("</body>");


		out.print("</html>");

		out.close();

	}
	

	
}
