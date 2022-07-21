package com.array;

public class ArrayTest2 {
	// 클래스 실행시키면서 args 배열에 값 전달하기

	public static void main(String[] args) {
		System.out.println(args[0]);
		System.out.println(args[1]);
		
		int[] score = {20, 55, 70, 66, 90}; // 선언, 생성, 초기화까지 한번에
		
		//  배열의 값 출력
		for(int i=0; i<score.length; i++) {
			System.out.print(score[i] + "\t");
		}
		
		System.out.println();
		for(int i: score) {
			System.out.print(i + "\t");
		}
	}

}
