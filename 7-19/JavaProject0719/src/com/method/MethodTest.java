package com.method;

public class MethodTest {
	
	// method ����
	public static void hello() {
		System.out.println("hello!!!");
	}

	// �̸��� parameter�� �޾Ƽ� �̸� �ڿ� "bye!"�� ������ �����ϴ� �޼ҵ� 
	public static String bye(String name) {
		return name + " bye!";
	}
	
	// sum(): int�� ���� �ΰ��� �Է� �޾� �� ���� �����ִ� �޼ҵ�
	public static int sum(int a, int b) {
		System.out.println("adding... " + a + " and "+ b);
		return a + b;
	}
	
	public static void sum2(int a, int b) {
		System.out.println(a + " + "+ b + " = " + (a+b));
	}

	public static int sumAll(int... a) {
		int result = 0;
		for(int i: a) {
			result += i;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// method ���
		hello();
		hello();
		hello();
		
		String result = bye("bye");
		System.out.println(result);
		System.out.println(bye(result));
		
		System.out.println(sum(1, 2));
		sum2(10, 23);
		
		System.out.println(sumAll(1, 2, 3));
	}

}
