package com.array;
// 2���� �̻��� �迭: ������ �迭
public class ArrayMulti {

	public static void main(String[] args) {
		int[] a = {1, 2, 3};
		int c[];
		
		int[][] multi = new int[3][2];
		int[][] multi2 = new int[3][];
		
		multi2[0] = new int[5];
		multi2[1] = new int[2];
		multi2[2] = new int[3];
		
		int[] x[], y, z[][];
		
		int[][] score= {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9},
		};
		
		for(int i=0; i<score.length; i++) { // ��
			for(int j=0; j<score[i].length; j++) { // ��
				System.out.print(score[i][j] + " ");
			} // �� �࿡ �ִ� ��� ���� ��µ�. �ϳ��� �� ó���� �Ϸ�.
			System.out.println(); // �ٹٲ�
		}
	}

}
