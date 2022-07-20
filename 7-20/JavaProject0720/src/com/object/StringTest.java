package com.object;

public class StringTest {
	
	public static void main(String[] args) {
		System.out.println(StaticTest.scount);
		StaticTest.hello();
		
		// s는 heap에 생기지x
		String s = "mylimeorange";
		// t는 heap에 생김
		String t = new String("mylimeorange");
		String x = "mylimeorange";
		
		if(s == t) // s 주소랑 t 주소가 같음?
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
		System.out.println("s : " + s); // 원본은 수정 안됨
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
