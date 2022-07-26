package com.generic;

class RedBean{

	@Override
	public String toString() {
		return "단팥입니다.";
	}
	
}

class CreamCheese{

	@Override
	public String toString() {
		return "크림치즈입니다.";
	}
	
}

public class FishBread<X> {
	
	private X filled; // 붕어빵 안에 들어가는 내용물의 타입
	
	public X getFilled() {
		return filled;
	}

	public void setFilled(X filled) {
		this.filled = filled;
	}

	public static void main(String[] args) {
		FishBread<RedBean> bean = new FishBread<>();
		FishBread<CreamCheese> cream = new FishBread<>();

		bean.setFilled(new RedBean());
		cream.setFilled(new CreamCheese());
		
		System.out.println(bean.getFilled());
		System.out.println(cream.getFilled());
	}

}
