package com.inner;

// 3. local class : 메소드 안에 선언되어 있음. 메소드 안에서만 사용 가능.
public class Mountain {
	
	int height = 1950;

	public void hello() {
//		Gold g = new Gold(); /// error
	}
	
	public void work() {
		class Gold{ // local class
			void dig() {
				System.out.println(height);
			}
		}
		
		Gold g = new Gold();
		g.dig();
		System.out.println(g.getClass().getName());
	}
	
	public static void main(String[] args) {
		Mountain m = new Mountain();
		m.work();
	}

}
