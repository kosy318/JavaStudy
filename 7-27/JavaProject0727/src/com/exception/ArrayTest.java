package com.exception;

import com.object.Car;

public class ArrayTest {
	
	public static void main(String[] args) {
		int[] num = {1, 2, 3, 4, 5};
		
		for(int i=0; i<=num.length; i++) {
			try {
				System.out.println(num[i]); // 문제의 줄				
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("잘못된 인덱스 번호 : " + e.getMessage());
				System.out.println("oops... sorry!!");
			} finally { // 예외 발생 여부와 관계없이 매번 실행되는 부분
				System.out.println("finally...");
			}
		}
		System.out.println("done...\n");
		
		int a = 0, b = 8, result = 0;
		Car c = null; // 지역변수, 사용전에 초기화 시켜줘야함.
		int age;
		
		try {
			c.info();
			result = b / a;	// 나눗셈에서 분모에 0이 들어오면 예외 발생. ArithmeticException
		} catch(ArithmeticException e) {
			System.out.println("message : " + e.getMessage());
			result = 100; // 예외 발생 시 설정할 값
		} catch(NullPointerException w) {
			w.printStackTrace();
		} catch(Exception e) {
			System.out.println("other exception....");
		}
		System.out.println(result);
	}

}
