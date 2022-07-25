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
	
	// getName 재정의: method overriding
	// overriding 조건 : 메소드 리턴타입, 메소드 이름, 파라미터 리스트가 반드시 동일해야함
	// 수식어(접근 지정자)는 변경 가능하지만 조건이 있다.
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
		
		// 메소드 오버라이딩의 경우 무조건 자식 메소드가 호출됨.
		System.out.println(c.getName());
		
		// static method 안에서는 this, super를 사용할 수 없음, static 생성 시점 때문에?
//		System.out.println(super.getName());
		c.callSuper();
		
		System.out.println(c.getAddress());
		System.out.println(c.name);
		
		System.out.println();
		
		// 다형성
		Object o = new Child();
		Child c2 = new Child();
		Parent p = new Child(); // 가능, 부모가 타입이 더 큼
		System.out.println(p.getName()); // tomson
		// The method callSuper() is undefined for the type Parent
//		System.out.println(p.callSuper());
	}
	
}
