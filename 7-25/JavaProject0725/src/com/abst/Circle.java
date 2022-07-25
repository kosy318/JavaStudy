package com.abst;

public class Circle extends Shape{
	
	int radius;

	public Circle(int radius) {
		super();
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public double getCircum() {
		return Math.PI * 2 * radius;
	}

}
