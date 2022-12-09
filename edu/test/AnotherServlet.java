package com.edu.test;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ WebServlet("/another")
public class AnotherServlet extends HttpServlet  {

	private static final long serialVersionUID = 1L ;

	
	
	
	public void init(ServletConfig config) throws ServletException {
		
		System.out.println("init called");
		super.init();
	}
	
	
	public void destroy() {
		
		System.out.println("destroy called");
		super.destroy();
	}
	
	
	
	protected void service(HttpServletRequest req, HttpServletResponse resp ) 
			throws ServletException, IOException {
		
		System.out.println("service called");
		super.service(req, resp);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		System.out.println("doGet called");
		super.doGet(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException  {
		
		System.out.println("doGet called");
		super.doPost(req, resp);
	}
	
	

	
	
}
