package com.inter;

interface Seoul{}
class Boat{}

// interface IShape를 상속 받아 추상 메소드를 완성시켜놔야됨
public class ICircle extends Boat implements IShape, Seoul{
	
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