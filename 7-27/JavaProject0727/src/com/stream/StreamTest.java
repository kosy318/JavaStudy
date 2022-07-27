package com.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamTest {
	
	public static void main(String[] args) {
		List<String> names = new ArrayList<>(Arrays.asList("joyful", "Profession", "jdk", "java"));
		
		// 1. Stream x
		long count = 0;
		for(String name : names) {
			if(name.contains("j")) {
				count += 1;
			}
		}
		System.out.println(count);
		
		// 2. Stream o
		count = 0;
		
		// filter() : 중간연산, count() : 최종연산
		count = names.stream().filter(name -> name.contains("j")).count();
		System.out.println(count);
		
		names.stream().filter(name -> name.contains("o")).forEach(name -> System.out.println(name));
		
		// map() : 스트림 내의 요소들을 하나씩 특정 값으로 변환해 줌
		names.stream()
			 .map(name -> name.concat(" o"))
			 .forEach(name -> System.out.println(name));
		
		List<Integer> ilist = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		ilist.stream()
			 .filter(i -> i > 3) // 3보다 큰 숫자 중
			 .limit(3)			 // 3개까지만; 여기까지 중간연산
			 .forEach(i -> System.out.print(i + " ")); // 최종연산
	}

}
