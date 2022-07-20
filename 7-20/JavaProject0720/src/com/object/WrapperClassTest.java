package com.object;

import java.util.Arrays;

// wrapper class: 기본형 데이터를 참조형으로 변환시켜주는 클래스들
public class WrapperClassTest {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(args));
		System.out.println(Integer.parseInt(args[0]) + Integer.parseInt(args[1]));

		System.out.println();
		
		// 문자열->int로 변환시켜줌
		int no = Integer.parseInt("234");
		System.out.println(no);
		double nod = Double.parseDouble("123.12");
		System.out.println(no + nod);
		
		int num = 88;
		Integer num2 = new Integer(num); // boxing
		int val = num2.intValue(); // unboxing
		
		System.out.println(num2 + 10); // auto-unboxing : 참조형->기본형으로 변환이 돼서 연산이 일어남
		
		Integer i = 99; // auto-boxing
		Double d = 3.14;
		Float f = 12.3f;
	}

}
