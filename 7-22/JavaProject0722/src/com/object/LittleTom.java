package com.object;

class Tom{
	
	int age = 50;
	
	protected void hello() {
		System.out.println("Tom-hello()");
	}
	
}

class Bill{
	
}

public class LittleTom extends Tom{
	
	int age = 20;
	
	@Override
	protected void hello() {
		System.out.println("LittleTom-hello");
	}

	public void test() {
		System.out.println("--------test-------");
		System.out.println(age); // 20
		System.out.println(this.age); // 20
		System.out.println(super.age); // 50
		System.out.println("-------------------");
	}
	
	public static void main(String[] args) {
		Tom t = new LittleTom();
		t.hello(); // LittleTom-hello; overriding
		System.out.println(t.age); // overriding은 method에만 적용
		
		LittleTom little = new LittleTom();
		little.hello();
		little.test();
		
		if(little instanceof LittleTom) { // 해당 타입의 객체인가?
			System.out.println("instance of LittleTom");
		}
		
		if(little instanceof Tom) { // 자식은 부모 타입이다.
			System.out.println("instance of Tom");
		}
		
		if(little instanceof Object) {
			System.out.println("instance of Object");
		}
		
//		if(little instanceof Bill) { // false를 리턴하는것이 아니라 error를 띄움
//			System.out.println("instance of Bill");
//		}
	}

}
