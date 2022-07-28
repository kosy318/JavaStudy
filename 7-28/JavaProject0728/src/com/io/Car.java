package com.io;

// 직렬화: 객체를(객체의 필드만 해당)연속된 바이트 단위로 변환하여 이동이 가능한 형태로 만들어주는 것
// 스트림으로 이동이 가능해짐
import java.io.Serializable;

public class Car implements Serializable {
	
	private int num;
	private String model;
	private String owner;
	
	Car(int num, String model, String owner) {
		this.num = num;
		this.model = model;
		this.owner = owner;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
}
