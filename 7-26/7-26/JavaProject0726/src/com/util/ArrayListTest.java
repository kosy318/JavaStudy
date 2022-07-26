package com.util;

import java.util.ArrayList;

import com.abst.Circle;
import com.abst.Rect;
import com.abst.Shape;

// 중복o, 순서o
public class ArrayListTest {
	
	public static void main(String[] args) {
		ArrayList<Integer> ilist = new ArrayList<>();
		ilist.add(100);
		ilist.add(200); // auto-boxing
		ilist.add(300);
		
		for(Integer i: ilist) {
			System.out.println(i);
		}
		System.out.println();
		
		ArrayList<Shape> slist = new ArrayList<>();
		slist.add(new Rect(4,7));
		slist.add(new Circle(8));
		slist.add(new Circle(6));
		
		for(Shape s: slist) {
			System.out.println(s.getClass().getSimpleName());
			System.out.println(s.getArea());
			System.out.println(s.getCircum());
			System.out.println();
		}
	}

}
