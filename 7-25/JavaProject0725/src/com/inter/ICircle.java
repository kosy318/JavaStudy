package com.inter;

public class ICircle implements IShape{
	
	int radius;
	
	public ICircle(int radius) {
		super();
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public double getCircum() {
		return 2 * Math.PI * radius;
	}

}
