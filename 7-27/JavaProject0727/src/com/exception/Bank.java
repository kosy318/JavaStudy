package com.exception;

public class Bank {
	
	public static void main(String[] args) {
		Bank b = new Bank();
		b.transfer(); // 이체 method 호출
	}

	private void transfer() {
		withdraw(); // 출금 method
		try {
			deposit(); // 입금 method
		} catch (MyException e) {
			System.out.println(e);
			System.out.println("출금 취소"); // 예외 발생 후 뒷처리
		}
	}

	private void deposit() throws MyException {
		throw new MyException("입금 예외");
	}

	private void withdraw() {
		System.out.println("출금 성공");
	}

}
