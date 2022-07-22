package com.inherit;
// �θ� Ŭ����, super class, base class
class Parent{
	
	String name = "tom";
	String address = "seoul";
	
	Parent(){
		System.out.println("Parent ������");
	}
	
	protected String getName() {
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
	
	// getName() ������: method overriding. �θ𿡰Լ� �������� �޼ҵ带 ������
	// method overriding ����: �޼ҵ� ����Ÿ��, �޼ҵ� �̸�, �Ķ���� ����Ʈ�� �ݵ�� �����ؾ���
	// ���ľ�(����������)�� ���� ����
	@Override
	public String getName() {
		return "tomson";
	}
	
	void callSuper() {
		System.out.println(super.getName());
	}

	// �ڽ� Ÿ���� ��ü�� �����ϸ� �޸𸮿� ���� �θ� ��ü�� ������ �ǰ� �� �Ʒ� �ڽ� ��ü�� ���� ����
	public static void main(String[] args) {
		Child c = new Child();
		
		System.out.println(c.getName());
		System.out.println(c.getAddress());
		System.out.println(c.name);
	}
	
}