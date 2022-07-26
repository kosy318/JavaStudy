package com.inter;

public class EggMayo implements Sandwich{

	@Override
	public int getCalorie() {
		return 416000;
	}

	@Override
	public String getIngredient() {
		return "에그마요 2스쿱, 치즈 2장";
	}

	@Override
	public String getDescription() {
		return "부드러운 달걀과 고소한 마요네즈가 만나 더 부드러운 스테디셀러";
	}

}
