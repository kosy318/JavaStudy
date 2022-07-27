package com.inner;

// 1. static inner class: 외부 클래스를 생성하지 않고도 내부 클래스 생성해서 사용 가능
public class OuterClass { // outer class; top-level class
	
	static int num = 256;
	
	static class Inner{ // Inner class - Static Class
		
		public void go() {
			System.out.println(num);
		}
		
	}
	
	public static void main(String[] args) {
		Inner i = new Inner();
		i.go();
		System.out.println(i.getClass().getName());
	}

}
