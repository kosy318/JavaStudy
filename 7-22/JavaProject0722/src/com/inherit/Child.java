package com.inherit;
// 부모 클래스, super class, base class
class Parent{
	
	String name = "tom";
	String address = "seoul";
	
	Parent(){
		System.out.println("Parent 생성자");
	}
	
	protected String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	
}

// 자식 클래스, sub class, derived class
public class Child extends Parent{
	
	String email;
	
	Child(){
		System.out.println("Child 생성자");
	}
	
	// getName() 재정의: method overriding. 부모에게서 물려받은 메소드를 재정의
	// method overriding 조건: 메소드 리턴타입, 메소드 이름, 파라미터 리스트가 반드시 동일해야함
	// 수식어(접근지정자)는 변경 가능
	@Override
	public String getName() {
		return "tomson";
	}
	
	void callSuper() {
		System.out.println(super.getName());
	}

	// 자식 타입의 객체를 생성하면 메모리에 먼저 부모 객체가 생성이 되고 그 아래 자식 객체가 따라 붙음
	public static void main(String[] args) {
		Child c = new Child();
		
		System.out.println(c.getName());
		System.out.println(c.getAddress());
		System.out.println(c.name);
	}
	
}