package com.edu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@ WebServlet("/bookPeg")
public class BookTest1Servlet extends HttpServlet {

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		req.setCharacterEncoding("UTF-8");
		
		String title = req.getParameter("title");		
		String author = req.getParameter("author");
		String publisher = req.getParameter("publisher");
		
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublisher(publisher);
		
		
		req.setAttribute("book", book);
		
		// request 객체에 book 객체 주소값 저장(이름과 함께)
		RequestDispatcher rd = req.getRequestDispatcher("bookOutput");
		rd.forward(req, resp);
		
		out.close();
	}
	
	
	
}
