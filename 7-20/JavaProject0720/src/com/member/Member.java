package com.member;

// ȸ�������� �����ϴ� Ŭ����
public class Member {
	
	// field(data)
	int num;
	String name;
	String address;
	int age;

	// ������
	public Member() {}
	public Member(int num, String name, String address, int age) {
		this.num = num;
		this.name = name;
		this.address = address;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", address=" + address + ", age=" + age + "]";
		
	}
	
}
