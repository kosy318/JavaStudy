package com.object;

public class Member {
	
	int num;

	// constructor
	Member() {} // default ������
	Member(int num){ // parameter�� �ִ� �����ڰ� ������, default �����ڸ� ���� ���������
		this.num = num;
	}
	
	public static void main(String[] args) {
		Member m = new Member(); // �����ڰ� �ƿ� ��� ���� (default ������)
	}
	
}
