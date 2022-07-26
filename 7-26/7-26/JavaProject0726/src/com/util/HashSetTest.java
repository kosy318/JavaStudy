package com.util;

import java.util.HashSet;

// set: 중복 x, 순서 x
public class HashSetTest {
	
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>();
		set.add("one");
		set.add("two");
		set.add("three");
		set.add("one");
		set.add("four");
		set.add("five");
		
		set.remove("three");
		
		for(String s: set)
			System.out.println(s);
	}

}
