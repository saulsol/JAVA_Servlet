package com.edu.test;

import javax.servlet.http.*;

public class TestSessionAttributeListener implements HttpSessionAttributeListener {

	public TestSessionAttributeListener() {
		System.out.println("TestSessionAttributeListener 객체 생성");
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("세션 객체에 속성 추가");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("세션 객체에 추가된 속성 삭제");
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("세션 객체에 추가된 속성 대체");
		
	}
	
	
}
