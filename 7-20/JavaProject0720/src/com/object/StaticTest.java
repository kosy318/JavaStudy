package com.object;

public class StaticTest {
	
	// field
	int count;
	static int scount; // 객체 생성 하지 않고 클래스 이름으로 사용 가능
	
	static { // static block
		System.out.println("static-1");
	}
	
	public static void hello() {
		System.out.println("hello~~~");
	}
	
	public void test() {
		System.out.println(this.count);
	}
	
	public static void main(String[] args) {
//		System.out.println(this.count);
		
		// 객체 생성을 하지 않아도 이미 만들어져 있음
		System.out.println(++StaticTest.scount);
		StaticTest.hello();
		
//		StaticTest s1 = new StaticTest();
//		StaticTest s2 = new StaticTest();
//		StaticTest s3 = new StaticTest();
//		
//		System.out.println(++s1.count + ", " + ++s2.count + ", " + ++s3.count);
//		System.out.println(++s1.scount + ", " + ++s2.scount + ", " + ++s3.scount);
		
		System.out.println(Math.pow(2, 3));
	}
	
	static { // static block
		System.out.println("static-2");
	}

}
