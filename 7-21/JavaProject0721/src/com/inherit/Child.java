package com.inherit;
// �θ� Ŭ����, super class, base class
class Parent{
	
	String name = "tom";
	String address = "seoul";
	
	Parent(){
		System.out.println("Parent ������");
	}
	
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	
}

// �ڽ� Ŭ����, sub class, derived class
public class Child extends Parent{
	
	String email;
	
	Child(){
		System.out.println("Child ������");
	}
	
	// �ڽ� Ÿ���� ��ü�� �����ϸ� �޸𸮿� ���� �θ� ��ü�� ������ �ǰ� �� �Ʒ� �ڽ� ��ü�� ���� ����
	public static void main(String[] args) {
		Child c = new Child();
		
		System.out.println(c.getName());
		System.out.println(c.getAddress());
		System.out.println(c.name);
	}
	
}
