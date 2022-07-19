package com.method;

public class MethodTest {
	
	// method 정의
	public static void hello() {
		System.out.println("hello!!!");
	}

	// 이릅을 parameter로 받아서 이름 뒤에 "bye!"를 연결해 리턴하는 메소드 
	public static String bye(String name) {
		return name + " bye!";
	}
	
	// sum(): int형 변수 두개를 입력 받아 그 합을 돌려주는 메소드
	public static int sum(int a, int b) {
		System.out.println("adding... " + a + " and "+ b);
		return a + b;
	}
	
	public static void sum2(int a, int b) {
		System.out.println(a + " + "+ b + " = " + (a+b));
	}

	public static int sumAll(int... a) {
		int result = 0;
		for(int i: a) {
			result += i;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// method 사용
		hello();
		hello();
		hello();
		
		String result = bye("bye");
		System.out.println(result);
		System.out.println(bye(result));
		
		System.out.println(sum(1, 2));
		sum2(10, 23);
		
		System.out.println(sumAll(1, 2, 3));
	}

}
