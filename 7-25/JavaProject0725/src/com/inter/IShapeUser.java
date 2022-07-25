package com.inter;

public class IShapeUser {
	
	public static void main(String[] args) {
		IShape[] s = new IShape[3]; // Shape type의 객체가 들어갈 수 있는 배열을 생성; 자식은 부모 타입임; Circle은 Shape 타입임
		
		s[0] = new ICircle(7);
		s[1] = new IRect(5, 6);
		s[2] = new ICircle(8);
		
		for(IShape shape : s) {
			System.out.println(shape.getClass().getSimpleName());
			System.out.println("면적: " + shape.getArea());
			System.out.println("둘레: " + shape.getCircum());
			System.out.println();
		}
	}

}
