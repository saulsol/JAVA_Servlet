package com.edu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet ("/logProc")
public class LogInOutServlet extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	// 로그인 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		if(id.isEmpty() || pwd.isEmpty()) {
			out.print("ID 또는 비밀번호를 입력해주세요.");
			return;
		}
		
		
		HttpSession session = req.getSession();
		
		if(session.isNew() || session.getAttribute("id") == null) {
			session.setAttribute("id", id); // 로그인 작업은 세션 객체에 특정 데이터를 등록하는 것이다.
			// 왜 ID로 지정하느냐...보통 회원가입 할때 ID는 중복검사를 한다. 즉 중복되지 않겠끔 모든 회원의 아이디가 다 달라야 한다. 
			// 따라서 session ID 값으로 사용자의 아이디를 등록하는 것이다. 
			
			out.print("로그인을 완료하였습니다.");
		}else {
			out.print("현재 로그인 상태입니다.");
		}

	}
	
	
	// 로그아웃 처리
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession(false);
		
		if(session != null && session.getAttribute("id") != null) {
			
			session.invalidate();
			out.print("로그아웃 작업이 완료되었습니다.");
		}else {
			out.print("현재 로그인 상태가 아닙니다.");
		}
		
		out.close();
		
	}
	
	
	
	

}
