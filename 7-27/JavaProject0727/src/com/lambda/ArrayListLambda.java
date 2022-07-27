package com.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListLambda {
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		
		list.add("tommy");
		list.add("bill");
		list.add("jane");
		list.add("roy");
		list.add("tommy");
		list.add("kim");
		
		// list 안의 내용물들에 대해 조건을 체크한 후 조건에 맞으면 삭제해줌.
		list.removeIf(name -> name.contains("y"));
		
		System.out.println(list);
		
		list.replaceAll(name -> name + "gogo");
		System.out.println(list);
		
		ArrayList<Integer> score = new ArrayList<>(Arrays.asList(22, 45, 85, 76, 25, 14));
		score.removeIf(i -> i%2==0 || i%3==0);
		System.out.println(score);
		
		score.replaceAll(i -> i*10);
		System.out.println(score);
	} 
	
}
