package com.inter;

public class SandwichUser {
	
	public static void main(String[] args) {
		Sandwich[] sandwich = new Sandwich[2];
		
		sandwich[0] = new ItalianBMT();
		sandwich[1] = new EggMayo();
		
		for(Sandwich s: sandwich) {
			s.info();
			System.out.println();
		}
	}

}
