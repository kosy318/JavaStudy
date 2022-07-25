package com.inherit;

class Employee{
	
	int num; // 사번
	String name; // 이름
	int salary; // 연봉
	
	public Employee(int num, String name, int salary) {
		super();
		this.num = num;
		this.name = name;
		this.salary = salary;
	}
	
	double getBonus() {
		return salary * 0.3;
	}
	
}

public class Manager extends Employee{

	int mCode; // 매니저 코드
	
	public Manager(int num, String name, int salary, int mCode) {
		super(num, name, salary); // 부모의 생성자를 호출
		this.mCode = mCode;
	}

	@Override
	double getBonus() {
		return salary * 0.5;
	}

	public static void main(String[] args) {
		
	}
	
}
