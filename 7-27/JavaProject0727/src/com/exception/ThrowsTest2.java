package com.exception;
// throws: 예외가 발생한 곳에서 바로 처리하지 않고 호출자로 예외를 보내서 그곳에서 처리하도록 함.
public class ThrowsTest2 {
	
	public static void main(String[] args) {
		ThrowsTest2 t = new ThrowsTest2();
		t.test(-3);
	}

	private void test(int num) {
		if(num >= 0) { // 정상실행
			System.out.println(++num);
		}else { // 비정상인 경우. 예외를 발생 시킴
			try{
				throw new Exception(); // 예외 발생시키는 문장
			}catch(Exception q) {
				q.printStackTrace();
			}
		}
	}

}
