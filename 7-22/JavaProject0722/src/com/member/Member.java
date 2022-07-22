package com.member;

// 회원정보를 저장하는 클래스
public class Member {
	
	// field(data) : 클래스 내부에서만 사용 가능(private)
	// encapsulation
	private int num;
	private String name;
	private String address;
	private int age;

	// 생성자
	public Member() {}
	public Member(int num, String name, String address, int age) {
		this.num = num;
		this.name = name;
		this.address = address;
		this.age = age;
	}
	
	// getter, setter
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		if(num > 0)
			this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name.length() > 0)
			this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", address=" + address + ", age=" + age + "]";
		
	}
	
}
