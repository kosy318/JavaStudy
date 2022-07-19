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
		
//		int z = System.in.read(); // ����
		// �ܺο��� ��, ���� �Է� �ޱ�
		Scanner sc = new Scanner(System.in);
		int i, j;
		do {
			System.out.print("�� �Է�(5x5 matrix �� ��): ");
			i = sc.nextInt(); // ��
			j = sc.nextInt(); // ��
		} while(i<0 || j<0 || i>=5 || j>=5);
		
		if(i-1 >= 0) {
			System.out.println("�� " + a[i-1][j]);
		} else {
			System.out.println("�� ����");
		}
		if(i+1 < a.length) {
			System.out.println("�� " + a[i+1][j]);
		} else {
			System.out.println("�� ����");
		}
		if(j-1 >= 0) {
			System.out.println("�� " + a[i][j-1]);
		} else {
			System.out.println("�� ����");
		}
		if(j+1 < a[i].length) {
			System.out.println("�� " + a[i][j+1]);
		} else {
			System.out.println("�� ����");
		}
	}
}
