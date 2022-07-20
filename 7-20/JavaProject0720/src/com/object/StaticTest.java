package com.object;

public class StaticTest {
	
	// field
	int count;
	static int scount; // ��ü ���� ���� �ʰ� Ŭ���� �̸����� ��� ����
	
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
		
		// ��ü ������ ���� �ʾƵ� �̹� ������� ����
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
