package com.singleton;

// singleton pattern class : 객체 생성을 한 번만 수행하고 그 이후로는 생성된 객체 공유해서 사용
public class SingletonObject {
	// 싱글톤 패턴 객체 조건
	// 1. field : private static 
	// 2. constructor : private
	// 3. method : public static : 객체를 생성하거나 생성된 객체를 리턴해 줌
	
	private static SingletonObject instance;
	private SingletonObject() {}
	
	public static SingletonObject getInstance() {
		if(instance == null)
			instance = new SingletonObject(); // 1번 객체가 생성됨
		
		return instance;
	}
	
}
