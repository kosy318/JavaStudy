package com.abst;

// 도형 클래스
public abstract class Shape {
	
	// 면적 구하는 메소드
	public abstract double getArea();
	
	// 둘레 구하는 메소드
	public abstract double getCircum();
	
	public void hello() {
		System.out.println("hello!");
	}

}
