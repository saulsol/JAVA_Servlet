package com.edu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/sessionTest")
public class SessionTestServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		

		String param = req.getParameter("p");//클라이언트로부터 전달된 질의 문자열 중에서 p 값을 추출하여 String param 변수에 저장 
		String msg = null; // msg(massage) : 처리가 끝난 다음 브라우저에 출력할 문자열을 가지는 변수.
		HttpSession session = null;
		// HttpSession 객체가 생성될 때는 요청을 보내온 클라이언트 정보, 요청 시간 정보등을 조합한 세션 ID가 부여된다.
		// 이 세션 ID는 클라이언트 측에 쿠키 기술로 저장된다. 
		
		// 클라이언트에는 세션 ID가 쿠키 기술로 저장되어 각 클라이언트에 대하여 생성되는 HttpSession 객체를 클라이언트마다 개별적으로 유지 및 관리한다. 
		
		if(param.equals("create")) {
			
			session = req.getSession();
			// 클라이언트가 가지고 있는 세션 ID와 동일한 세션 객체를 찾아서 조솟값을 반환.
			// 만일 세션 객체가 존재하지 않으면 새로운 HttpSession 객체를 생성해서 반환한다. 
			
			if(session.isNew()) {
				msg = "새로운 세션 객체가 생성됨";
			}else {
				msg = "기존의 세션 객체가 리턴됨";
			}
			
		}else if(param.equals("delete")) {
			
			session = req.getSession(false);
			// 파라미터 값이 true : getSession() 메소드와 마찬가지로 HttpSession 객체를 생성하여 반환한다. 
			// 파라미터 값이 false : 새로운 HttpSession 객체를 생성하지 않고 null을 반환한다.
			// 일단 파라미터 값에 관계없이 Session 객체의 주소를 추출하는 것은 다름이 없다.
			
			
			if(session != null) {
				session.invalidate(); // invalidate : 무효화하다
				msg = "세션 객체 삭제 작업 완료";
			}else {
				msg = "삭제할 세션 존재하지 않음";
			}
			
		}else if(param.equals("add")) {
			
			session = req.getSession(true); // 1. session 객체 추출 2. 세션 객체가 없다면 새롭게 생성
			session.setAttribute("msg", "메시지입니다");
			msg = "세션 객체에 데이터 등록 완료";
			
		}else if(param.equals("get")) {
			
			session = req.getSession(false);
			
			if(session != null) {
				
				String str = (String) session.getAttribute("msg");
				msg = str;
		
			}else {
				msg = "데이터를 추출할 세션 객체 존재하지 않음";
			}

		} else if(param.equals("remove")) {
			// remove : 세션에 등록된 데이터 삭제
			// delete : 세션 자체 삭제
			session = req.getSession(false);
			
			if(session != null) {
				session.removeAttribute("msg");
				msg = "세션 객체의 데이터 삭제 완료";
			}else {
				msg = "데이터를 삭제할 세션 객체 존재하지 않음";
			}
		
		}else if(param.equals("replace")) {
			
			session = req.getSession();
			session.setAttribute("msg", "새로운 메시지입니다");
			msg = "세션 객체에 데이터 등록 완료";
		}
		
		out.print("처리 결과 : " + msg);
		out.close();
		
	}
	
	
	
}
