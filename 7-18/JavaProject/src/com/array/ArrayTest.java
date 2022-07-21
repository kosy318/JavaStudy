package com.array;

import java.util.Arrays;

public class ArrayTest {
	// 모든 배열들은 생성을 하면 기본값을 가지고 있음.
	// 정수형 배열 => 0, 실수형 배열 => 0.0, 논리형 배열 => false, 객체형 배열 => null
	
	public static void main(String[] args) {
		int a = 9; // 기본형. 선언만 해도 사용 가능
		int[] score; // 1. 배열의 선언, int score[]로 선언해도 됨
		// 아직 사용 불가
		
		score = new int[3]; // 2. 배열의 생성(*) 필수
		System.out.println(Arrays.toString(score)); // 사용
		
		score[0] = 90; // 3. 배열의 사용
		score[1] = 50;
		score[2] = 68;
		
		System.out.println(Arrays.toString(score)); // 사용
		
		double[] point = new double[2]; // 선언&생성 한꺼번에
		System.out.println(Arrays.toString(point)); // 0.0 default value
		
		String[] names = new String[3];
		System.out.println(Arrays.toString(names));
	}

}
