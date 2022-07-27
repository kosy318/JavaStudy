package com.exception;
// throws: 예외가 발생한 곳에서 바로 처리하지 않고 호출자로 예외를 보내서 그곳에서 처리하도록 함.
public class ThrowsTest {
	
	public static void main(String[] args) {
		ThrowsTest t = new ThrowsTest();
		
		try {
			t.work(3, 1);
			t.work(3, 5);
			t.work(3, 3);
		} catch (MyException e) {
			System.out.println(e);
		} catch (YourException e) {
			System.out.println(e);
		}
		
//		try{
//			t.test(0);
//		} catch(MyException e) {
//			System.out.println(e); // reference를 출력하면 클래스 안의 toString()메소드가 자동 호출이 된다.
//		} catch(Exception e) {
//			System.out.println("파라미터는 양수여야합니다");
//			e.printStackTrace();
//		}
	}

	private void work(int a, int b) throws MyException, YourException {
		if(a > b) {
			System.out.println(a + ", " + b);
		} else if(a == b) {
			throw new MyException("a == b");
		} else {
			throw new YourException("a < b");
		}
	}

	private void test(int num) throws MyException, Exception {
		if(num > 0) { // 정상실행
			System.out.println(++num);
		} else if(num == 0) { // 비정상인 경우
			throw new MyException("파라미터가 0입니다. 양수를 입력해주세요.");
		} else { // 비정상인 경우. 예외를 발생 시킴
			throw new Exception(); // 예외 발생시키는 문장
		}
	}

}
