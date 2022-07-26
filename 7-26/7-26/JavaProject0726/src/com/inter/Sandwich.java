package com.inter;

public interface Sandwich {
	
	int getCalorie(); // Sandwich 칼로리
	String getIngredient(); // Sandwich 재료
	String getDescription(); // Sandwich 설명
	
	default void info() {
		System.out.println(getClass().getSimpleName());
		System.out.println("칼로리 : " + getCalorie()/1000 + "Kcal");
		System.out.println("재료 : " + getIngredient());
		System.out.println("설명 : " + getDescription());
	}

}
