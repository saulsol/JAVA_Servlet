package com.edu.test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet ("/second") // uri 맵핑
public class SecondServlet extends HttpServlet {
	
	// 클라이언트가 /second로 요청하면 SecondServlet의 init()메서드가 실행되어야 하는데, 재정의하지 않아서 GenericServlet 클래스의 init() 메소드가 톰캣에 의해 
	// 실행된다. init() 실행 후, service() 메소드가 실행되어야 하는데 역시 재정의하지 않아서 실행되지 않는다. 
		
	// 기본적으로 주소 줄에 URL을 입력한 후, 요청하는 상황은 GET 방식으로 요청된다. 하이퍼링크로 연결된 문자열을 실행하는 상황도 GET 방식이다. 

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("SecondServlet!");
		
		// out 객체 ---> 결국 클라이언트 브라우저에게 html 코드를 적어주는 역할
		
		
		PrintWriter out = resp.getWriter(); 
		// 클라이언트가 주는 정보 : HttpResponse 객체를 사용해서 클라이언트에게 보내는 객체를 꾸며주는 역할을 하는 객체
		
		out.print("<html><head><title>Test</title></head>");
		out.print("<body><h1>have a nice day ~!</h1></body>");
		out.print("</html>");
		
		// 우리사 JSP 에서 사용하는 out 객체는 전부 스트림이었다. 
		// 즉 출력 스트림을 말하는 것이다. 
		
		out.close(); 
		//이른바 '자원 해제'
		
		// 웹 어플리케이션은 여러 사용자로부터 요청을 전달받는다. 이러한 동시 요청을 빠르게 응답하는 방법 중 하나가 
		// '자원 해제'다. 생성했던 자원을 더 이상 사용하지 않는다면 메모리에서 해제해주는 것이 메모리 관라 면에서 효율적이다. 
		// 프로그램을 구현할 때 자원을 해제하는 습관을 들이면 여러모로 도움이 될 것이다. 
	}
	
	
}
