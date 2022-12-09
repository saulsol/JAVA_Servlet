package com.edu.beans;

public class HelloBean {


	private String name;
	private String number;
	
	public HelloBean() {
		
		this.name = "이름이 없습니다.";
		this.number = "번호가 없습니다.";
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}
	


	// 자바빈즈 멤버 변수 처리 메소드 

	// 자바빈즈 속성값에 대한 작업을 하는 getter setter 메소드를 항상 모두 선언해야 하는것은 아니다. 만일 
	// 자바빈즈 속성값을 읽기 전용으로 사용하고 싶다면, getter 메소드만 정의하면 되고, 쓰기도 가능하게 하고 싶다면
	// setter 메소드를 정의하면 된다.

}
