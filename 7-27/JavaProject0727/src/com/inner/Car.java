package com.inner;

// 2. member class : 내부 클래스를 사용(생성)하기 전에 먼저 외부 클래스가 생성되어 있어야함.

// top-level class는 하나만 public이어야함
// top-level class에 붙일 수 있는 수식어: public, abstract, final
//public class Boat{} 
//private class Boat{}

public class Car {
	
	int num = 1234;
	
	private class Engine{ // inner class: public, private, protected,
		public void go() {
			System.out.println(num);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new Car().num);
		
		Engine e = new Car().new Engine();
		e.go();
		System.out.println(e.getClass().getName());
	}

}
