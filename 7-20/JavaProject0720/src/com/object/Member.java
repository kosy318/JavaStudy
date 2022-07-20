package com.object;

public class Member {
	
	int num;

	// constructor
	Member() {} // default 생성자
	Member(int num){ // parameter가 있는 생성자가 있으면, default 생성자를 따로 적어줘야함
		this.num = num;
	}
	
	public static void main(String[] args) {
		Member m = new Member(); // 생성자가 아예 없어도 가능 (default 생성자)
	}
	
}
