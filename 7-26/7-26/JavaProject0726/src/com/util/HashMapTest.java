package com.util;

import java.util.HashMap;
import java.util.Set;

// map: (key, value)의 쌍으로 이루어진 자료구조. key는 중복되면 안됨.
public class HashMapTest {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("key", "value");
		map.put("name", "harry potter");
		map.put("num", "address");
		
		System.out.println(map);
		
		Set<String> set = map.keySet();
		for(String str : set) {
			System.out.println(map.get(str));
		}
	}
	
}
