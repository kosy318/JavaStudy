package com.inter;

public class IRect implements IShape{
	
	int width, height;

	public IRect(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		return width * height;
	}

	@Override
	public double getCircum() {
		return 2*width + 2*height;
	}

}
