package com.abst;

public class ShapeUser {
	
	public static void main(String[] args) {
		Shape[] s = new Shape[3]; // Shape type의 객체가 들어갈 수 있는 배열을 생성; 자식은 부모 타입임; Circle은 Shape 타입임
//		Shape q = new Shape(); // err
		
		s[0] = new Circle(7);
		s[1] = new Rect(5, 6);
		s[2] = new Circle(8);
		
		for(Shape shape : s) {
			System.out.println(shape.getClass());
			System.out.println("면적: " + shape.getArea());
			System.out.println("둘레: " + shape.getCircum());
			System.out.println();
		}
	}

}
