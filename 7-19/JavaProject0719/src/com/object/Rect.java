package com.object;

public class Rect {

	int width;
	int height;
	
	// »ý¼ºÀÚ
	Rect(){}
	Rect(int w, int h){
		width = w;
		height = h;
	}
	
	public int getArea() {
		return width*height;
	}
	
	public int getCircum() {
		return 2 * (width+height);
	}
	
	public static void main(String[] args) {
		Rect r = new Rect(3, 4);
		
		System.out.println("area : " + r.getArea());
		System.out.println("circumstance : " + r.getCircum());
	}
	
}
