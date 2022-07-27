package com.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.abst.Circle;

// Stream : 기존의 Collection 객체들로부터 얻어낸 연속된 데이터. 데이터의 묶음.
public class StreamCreation {
	
	public static void main(String[] args) {
		// 1. 배열로부터 스트림 생성
		Double[] point = {3.1, 4.6, 6.7, 5.6, 1.9};
		Stream<Double> st1 = Arrays.stream(point);
		
		// 2. Collection으로부터 스트림 생성
		List<String> names = new ArrayList<>(Arrays.asList("joyful", "Profession", "jdk", "java"));
		Stream<String> st2 = names.stream();
		
		// 3. 스트림 직접 생성
		Stream<Integer> st3 = Stream.of(100, 200, 300);
		Stream<String> st4 = Stream.of("white", "red", "blue");
		Stream<Circle> st5 = Stream.of(new Circle(8), new Circle(12));
	}

}
