package com.singleton;

// singleton pattern class : ��ü ������ �� ���� �����ϰ� �� ���ķδ� ������ ��ü �����ؼ� ���
public class SingletonObject {
	// �̱��� ���� ��ü ����
	// 1. field : private static 
	// 2. constructor : private
	// 3. method : public static : ��ü�� �����ϰų� ������ ��ü�� ������ ��
	
	private static SingletonObject instance;
	private SingletonObject() {}
	
	public static SingletonObject getInstance() {
		if(instance == null)
			instance = new SingletonObject(); // 1�� ��ü�� ������
		
		return instance;
	}
	
}
