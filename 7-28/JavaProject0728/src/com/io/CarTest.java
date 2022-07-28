package com.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CarTest {
	
	public static void main(String[] args) throws Exception{
		Car c = new Car(1234, "x5", "tommy");
		
		// file에 저장
		FileOutputStream fos = new FileOutputStream("src\\com\\io\\car.txt"); // node stream; 직접 객체를 읽어서 저장시킬 수 없음
		ObjectOutputStream oos = new ObjectOutputStream(fos); // process stream; file이랑 바로 연결될 수는 없음, 객체를 읽어올 수 있음
		
		oos.writeObject(c); // 객체가 파일에 저장이 됨.
		System.out.println("saved...");
		
		// file에서 불러오기
		FileInputStream fis = new FileInputStream("src\\com\\io\\car.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Car c2 = (Car) ois.readObject();
		System.out.println(c2.getNum());
		System.out.println(c2.getModel());
		System.out.println(c2.getOwner());
	}

}
