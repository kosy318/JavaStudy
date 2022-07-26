package com.util;

import java.util.Vector;

public class VectorTest {
	
	public static void main(String[] args) {
		Vector v1 = new Vector(3); // 내부 배열 크기 2
		System.out.println(v1.capacity());
		
		v1.add(123);
		v1.add("hello");
		v1.add(true);
		v1.add(12.3);
		System.out.println(v1.capacity());
		v1.add("hello");
		v1.add("hello");
		v1.add(true);
		System.out.println(v1.capacity());
		v1.add(12.3);
		
		System.out.println("by (Object i : v1)");
		for(Object i : v1) {
			System.out.println(i + "\t" + i.getClass().getSimpleName());
		}
		
		System.out.println("\nby v1.get(index)");
		for(int i=0; i<v1.size(); i++) {
			System.out.println(v1.get(i));
		}
		System.out.println();
		
		Vector<String> name = new Vector<>();
		name.add("spring");
		name.add("summer");
		name.add("fall");
		name.add("winter");
		
		name.add(1, "add");
		
//		System.out.println(name.remove(0));
		
		for(String str : name) {
			System.out.println(str);
		}
	}

}
