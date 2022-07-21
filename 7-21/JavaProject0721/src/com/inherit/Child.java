package com.inherit;
// 부모 클래스, super class, base class
class Parent{
	
	String name = "tom";
	String address = "seoul";
	
	Parent(){
		System.out.println("Parent 생성자");
	}
	
	public String getName() {
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
	
	// 자식 타입의 객체를 생성하면 메모리에 먼저 부모 객체가 생성이 되고 그 아래 자식 객체가 따라 붙음
	public static void main(String[] args) {
		Child c = new Child();
		
		System.out.println(c.getName());
		System.out.println(c.getAddress());
		System.out.println(c.name);
	}
	
}
