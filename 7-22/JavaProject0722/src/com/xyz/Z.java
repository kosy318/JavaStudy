package com.xyz;

public class Z extends Y{
	
	void print() {
		System.out.println("Z print");
	}
	
	void play() {
		System.out.println("Z play");
	}
	
	void go() {
		System.out.println("Z go");
	}
	
	void superPlay() {
		super.play();
	}
	
	void superPrint() {
		super.print();
	}
	
	void super2Play() {
		// Syntax error on token "super", Identifier expected
//		super.super.play();
	}
	
	public static void main(String[] args) {
		
		Z z = new Z();
		Y y = z;
		X x = z;
		
		z.print();
		z.play();
		y.play();
		y.print();
		x.play();
		x.print();
		z.superPlay(); // Y
		z.superPrint(); // X
//		z.super2Play();
		// The method go() is undefined for the type Y
//		y.go();
		// The method go() is undefined for the type X
//		x.go();
	}
	
}
