package com.generic;

public class GenericNumber<X extends Number> {
	
	X num;
	
	public X getNum() {
		return num;
	}

	public void setNum(X num) {
		this.num = num;
	}

	public static void main(String[] args) {
		GenericNumber<Integer> i = new GenericNumber<Integer>();
		i.setNum(4);
		System.out.println(i.getNum().getClass().getSimpleName());
		System.out.println(i.getNum());
		
		GenericNumber<Double> d = new GenericNumber<Double>();
		d.setNum(3.14);
		System.out.println(d.getNum().getClass().getSimpleName());
		System.out.println(d.getNum());
		
		/* Bound mismatch:
		 * The type String is not a valid substitute for the bounded parameter <X extends Number> of the type 
		 * GenericNumber<X> */
//		GenericNumber<String> str = new GenericNumber<String>(); 
	}

}
