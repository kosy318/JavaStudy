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
		System.out.println(t.age); // overriding�� method���� ����
		
		LittleTom little = new LittleTom();
		little.hello();
		little.test();
		
		if(little instanceof LittleTom) { // �ش� Ÿ���� ��ü�ΰ�?
			System.out.println("instance of LittleTom");
		}
		
		if(little instanceof Tom) { // �ڽ��� �θ� Ÿ���̴�.
			System.out.println("instance of Tom");
		}
		
		if(little instanceof Object) {
			System.out.println("instance of Object");
		}
		
//		if(little instanceof Bill) { // false�� �����ϴ°��� �ƴ϶� error�� ���
//			System.out.println("instance of Bill");
//		}
	}

}
