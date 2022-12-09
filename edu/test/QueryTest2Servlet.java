package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@ WebServlet("/queryTest2")
public class QueryTest2Servlet extends HttpServlet {


		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out = resp.getWriter();

			out.print("<html><head><title>질의 문자열 테스트</title></head>");
			out.print("<body>");

			out.print("<h3>POST 방식으로 요청되었습니다</h3>");

//			String id = req.getParameter("id");
//			String pwd = req.getParameter("pwd");
//			String name = req.getParameter("name");
//			
//			String [] hobbies = req.getParameterValues("hobby");
//			
//			String gender = req.getParameter("gender");
//			String religion = req.getParameter("religion");
//			
//			String introduction = req.getParameter("introduction");
//			
//			out.print("ID : " + id + "<br/>");
//			out.print("PASSWORD : " + pwd + "<br/>");
//			out.print("NAME : " + name + "<br/>");
//			out.print("HOBBY : ");
//			for(int i=0; i<hobbies.length; i++) {
//				out.print(hobbies[i]+ " ");
//			}
//			
//			out.print("<br/>");
//			
//			
//			out.print("SEX : " + gender + "<br/>");
//			out.print("RELIGION : " + religion + "<br/>" );
//			out.print("INTRODUCTION : " + introduction + "<br/>" );
//			//out.print("QUERY STRING : " + req.getQueryString());
			
			

			// POST 방식 QUERY 문자열 추출
			ServletInputStream input = req.getInputStream();
			int len = req.getContentLength();
			byte[] buf = new byte[len];
			input.readLine(buf, 0, len); // 읽어 들인 후 바이트 배열에 저장
			
			for(int i=0; i<buf.length; i++) 
				System.out.print(buf[i]);
			
			
			String s = new String(buf);
			
			out.print("QUERY STRING : <br/>" + s);
			
			
			
			out.print("</body></html>");
			out.close();

		

	}

}
