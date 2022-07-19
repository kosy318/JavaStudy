package com.array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayMulti2D {
	public static void main(String[] args) {
		int[][] a = {
				{1, 2, 3, 4, 5},
				{2, 3, 4, 5, 6},
				{3, 4, 5, 6, 7},
				{4, 5, 6, 7, 8},
				{5, 6, 7, 8, 9},
		};
//		System.out.println(Arrays.deepToString(a));
		
//		int z = System.in.read(); // 불편
		// 외부에서 행, 열값 입력 받기
		Scanner sc = new Scanner(System.in);
		int i, j;
		do {
			System.out.print("값 입력(5x5 matrix 행 열): ");
			i = sc.nextInt(); // 행
			j = sc.nextInt(); // 열
		} while(i<0 || j<0 || i>=5 || j>=5);
		
		if(i-1 >= 0) {
			System.out.println("상 " + a[i-1][j]);
		} else {
			System.out.println("상 없음");
		}
		if(i+1 < a.length) {
			System.out.println("하 " + a[i+1][j]);
		} else {
			System.out.println("하 없음");
		}
		if(j-1 >= 0) {
			System.out.println("좌 " + a[i][j-1]);
		} else {
			System.out.println("좌 없음");
		}
		if(j+1 < a[i].length) {
			System.out.println("우 " + a[i][j+1]);
		} else {
			System.out.println("우 없음");
		}
	}
}
