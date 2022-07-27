package com.exception;

// 사용자 정의 예외 클래스. Exception 클래스를 상속 받아야함.
// 부모인 Exception이 만들어지면서 Exception이 발생하게됨
public class MyException extends Exception{
	
	String message;

	public MyException(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "MyException [message=" + message + "]";
	}
	
}
