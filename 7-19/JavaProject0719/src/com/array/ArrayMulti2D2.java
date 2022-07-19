package com.array;

public class ArrayMulti2D2 {
	public static void main(String[] args) {
		int[][] a = {
				{1, 2, 3, 4, 5},
				{2, 3, 4, 5, 6},
				{3, 4, 5, 6, 7},
				{4, 5, 6, 7, 8},
				{5, 6, 7, 8, 9},
		};
		
		// ��, ��, ��, �� ���� �� �ε��� ��ȭ��
		int[] dx = {-1, 1, 0, 0}; // ��, ��, ��, �� ���ٽ� x��ǥ ��ȭ��
		int[] dy = {0, 0, -1, 1}; // ��, ��, ��, �� ���ٽ� y��ǥ ��ȭ��
		int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		char[] dir = {'��', '��', '��', '��'};
		
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				int x = a[i][j]; // ���� ������ ��
				System.out.println("(" + i + ", " + j + ") = " + x);
				
				// i, j��ġ�� ���ؼ� 4�� ����
				for(int k=0; k<4; k++) {
					// nx, ny: �̵��Ϸ��� �ϴ� ���ο� x, y��ǥ
					int nx = i+dx[k];
					int ny = j+dy[k];
					
					// �迭 ������ ��ġ���� üũ
					if(nx>=0 && ny>=0 && nx<a.length && ny<a[i].length) {
						System.out.println(dir[k] + " " + a[nx][ny]);
					}
				} // end for : 4�� Ž��
				System.out.println();
			}
		}
	}
}
