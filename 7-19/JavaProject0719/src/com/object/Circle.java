package com.object;

public class Circle {

	int radius;
	
	// ������
	Circle(){ // default ������
		this(0);
	}	
	Circle(int radius) { // constructor with parameters
		this.radius = radius;
	}
	
	public double getArea() {
		return (double)(radius*radius)*3.14;
	}

	public double getCircum() {
		return (double)(2*radius)*3.14;
	}
	
	public static void main(String[] args) {
		Circle c = new Circle(3);
		System.out.println(c.getArea());
		
		Circle c2 = new Circle();
		System.out.println(c2.getCircum());
	}	
	
}
