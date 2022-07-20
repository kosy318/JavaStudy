package com.object;

public class StringTest {
	
	public static void main(String[] args) {
		System.out.println(StaticTest.scount);
		StaticTest.hello();
		
		// s�� heap�� ������x
		String s = "mylimeorange";
		// t�� heap�� ����
		String t = new String("mylimeorange");
		String x = "mylimeorange";
		
		if(s == t) // s �ּҶ� t �ּҰ� ����?
			System.out.println("s == t");
		
		if(s.equals(t))
			System.out.println("s.equals(t)");
		
		System.out.println();
		
		if(s == x)
			System.out.println("s == x");
		
		if(s.equals(x))
			System.out.println("s.equals(x)");
		
		System.out.println();
		
		String k = s.concat("hello");
		System.out.println("s : " + s); // ������ ���� �ȵ�
		System.out.println("k : " + k);
		
		k = s.toUpperCase();
		System.out.println("s : " + s);
		System.out.println("k : " + k);
		
		s = s + "gogo";
		System.out.println("s : " + s);
		
		StringBuilder sb = new StringBuilder("mylimeorange");
		sb.append("hello");
		System.out.println("sb : " + sb);
	}

}
