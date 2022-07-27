package com.lambda;

// @FunctionalInterface : 인터페이스 안에 메소드가 하나만 존재하는 경우
@FunctionalInterface
interface Sth{
	int some(int a, int b);
}

class Robot{
	public void work(Sth s, int x, int y) {
		int result = s.some(x, y);
		System.out.println(result);
	}
}

public class LambdaTest {
	
	public static void main(String[] args) {
		// lambda식 x
		Robot robot = new Robot();
		robot.work(new Sth() { // anonymous class
			@Override
			public int some(int a, int b) {
				return a+b;
			}}, 5, 6);
		
		// lambda식 o
		Robot robot2 = new Robot();
		robot2.work((a, b) -> { // Sth 안 some overriding; 인터페이스 이름, 메소드 이름도 필요없이 추상 메소드 구현에만 집중
			return a-b;
		}, 5, 6);
		
		robot2.work((a, b) -> a*b, 3, 8);
	}
	
	/*
	// 1.
	int max(int a, int b) {
		return (a > b)? a : b;
	}
	
	// 메소드 이름, 리턴 타입x, parameter type x, 실행 문장이 1개인 경우 {} 생략 가능
//	(a, b) -> (a > b)? a : b
	
	// 2.
	void printName(String name, int i) {
		System.out.println(name + "=" + i);
	}
	
//	(name, i) -> System.out.println(name + "=" +i)
	
	// 3.
	int square(int x) {
		return x*x;
	}
	
//	x -> x*x
	
	// 4.
	int rand() {
		return (int)(Math.random()*6);
	}
	
//	() -> (int)Math.random()*6
	
	// 5.
	int sum(int[] arr) {
		int sum = 0;
		for(int i : arr) {
			sum += i;
		}
		return sum;
	}
	
//	arr -> {
//		int sum = 0;
//		for(int i : arr) {
//			sum += i;
//		}
//		return sum;
//	}
 * 
 */
	
}
