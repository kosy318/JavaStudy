package com.object;

import java.util.Arrays;

// wrapper class: �⺻�� �����͸� ���������� ��ȯ�����ִ� Ŭ������
public class WrapperClassTest {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(args));
		System.out.println(Integer.parseInt(args[0]) + Integer.parseInt(args[1]));

		System.out.println();
		
		// ���ڿ�->int�� ��ȯ������
		int no = Integer.parseInt("234");
		System.out.println(no);
		double nod = Double.parseDouble("123.12");
		System.out.println(no + nod);
		
		int num = 88;
		Integer num2 = new Integer(num); // boxing
		int val = num2.intValue(); // unboxing
		
		System.out.println(num2 + 10); // auto-unboxing : ������->�⺻������ ��ȯ�� �ż� ������ �Ͼ
		
		Integer i = 99; // auto-boxing
		Double d = 3.14;
		Float f = 12.3f;
	}

}
