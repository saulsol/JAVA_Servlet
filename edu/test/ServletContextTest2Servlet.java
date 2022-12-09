package com.edu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@ WebServlet("/context2")
public class ServletContextTest2Servlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		ServletContext sc = this.getServletContext(); // 컨텍스트 객체 주소 추출 
		
		out.print("서블릿 버전 : " + sc.getMajorVersion() + "." + sc.getMinorVersion() + "<br>");
		out.print("서버 정보 : " + sc.getServerInfo() + "<br>"); // 현재 사용 중인 서블릿 컨테이너의 이름과 버전정보를 반환 즉 톰캣 정보
		out.print("웹 어플리케이션 경로 : " + sc.getContextPath() + "<br>"); // 웹 어플리케이션을 찾아가기 위해 사용하는 경로를 반환
		out.print("웹 어플리케이션 이름 : " + sc.getServletContextName() + "<br>");
		// web.xml 파일에 <display-name></display-name> 태그에 저장되어 있는 이름 추출
		
		out.print("파일 실제 경로 : " + sc.getRealPath("/name.html") + "<br>");
		// 인자값으로 지정한 URI의 실제 물리적인 경로를 확인하고자 할 때 사용하는 메소드 
		
		sc.log("로그 기록!!");
		
		out.close();
	}
	
	
	
	
	
}
