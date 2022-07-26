package com.inter;

public class ItalianBMT implements Sandwich{

	@Override
	public int getCalorie() {
		return 388000;
	}

	@Override
	public String getIngredient() {
		return "페퍼로니 3장, 살라미 3장, 햄 2장, 치즈 2장";
	}

	@Override
	public String getDescription() {
		return "페퍼로니, 살라미 그리고 햄이 만들어내는 최상의 조화!\r\n" + 
				"전세계가 사랑하는 써브웨이의 베스트셀러!\r\n" + 
				"Biggest Meatiest Tastiest, its’ B.M.T.";
	}
	
}
