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
		
		// 상, 하, 좌, 우 접근 시 인덱스 변화량
		int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우 접근시 x좌표 변화량
		int[] dy = {0, 0, -1, 1}; // 상, 하, 좌, 우 접근시 y좌표 변화량
		int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		char[] dir = {'상', '하', '좌', '우'};
		
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				int x = a[i][j]; // 현재 접근한 값
				System.out.println("(" + i + ", " + j + ") = " + x);
				
				// i, j위치에 대해서 4방 접근
				for(int k=0; k<4; k++) {
					// nx, ny: 이동하려고 하는 새로운 x, y좌표
					int nx = i+dx[k];
					int ny = j+dy[k];
					
					// 배열 안쪽의 위치인지 체크
					if(nx>=0 && ny>=0 && nx<a.length && ny<a[i].length) {
						System.out.println(dir[k] + " " + a[nx][ny]);
					}
				} // end for : 4방 탐색
				System.out.println();
			}
		}
	}
}
