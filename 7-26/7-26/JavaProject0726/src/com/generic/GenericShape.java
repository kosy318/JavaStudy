package com.generic;

import com.abst.Circle;
import com.abst.Rect;
import com.abst.Shape;

public class GenericShape<X extends Shape> { // Shape 클래스를 상속하고 있는 자식 클래스만 가능
	
	private int num;
	private X what;
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public X getWhat() {
		return what;
	}

	public void setWhat(X what) {
		this.what = what;
	}

	public static void main(String[] args) {
		GenericShape<Circle> c = new GenericShape<>();
		GenericShape<Rect> r = new GenericShape<>();
//		GenericShape<String> s = new GenericShape<>(); // type err
		
		c.setWhat(new Circle(3));
		r.setWhat(new Rect(2, 4));
		
		System.out.println(c.getWhat().getArea());
		System.out.println(r.getWhat().getArea());
	}

}
