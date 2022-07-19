package com.array;
// 2차원 이상의 배열: 다차원 배열
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
		
		for(int i=0; i<score.length; i++) { // 행
			for(int j=0; j<score[i].length; j++) { // 열
				System.out.print(score[i][j] + " ");
			} // 한 행에 있는 모든 열이 출력됨. 하나의 행 처리가 완료.
			System.out.println(); // 줄바꿈
		}
	}

}
