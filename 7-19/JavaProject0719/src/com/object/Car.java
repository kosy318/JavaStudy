package com.object;

public class Car {
	
	// member, field, data, attribute
	int num;
	String model;
	String owner;
	boolean running = false;
	
	// constructor
	Car() {
		System.out.println("Car 持失");
	}
	Car(int num, String model, String owner) {
		this.num = num;
		this.model = model;
		this.owner = owner;
		
		System.out.println("Car 持失--------");
		this.info();
		System.out.println("---------------");
	}
	
	public void info() {
		System.out.println("num : " + num);
		System.out.println("model : " + model);
		System.out.println("owner : " + owner);
	}
	
	public void run() {
		if(!running) System.out.println("running...");
		running = true;
	}
	
	public void stop() {
		if(running) System.out.println("stop!!!");
		running = false;
	}
	
	public static void main(String[] args) {
		Car newCar = new Car(1234, "m5", "tommy");

		newCar.owner = "sssss";
		
		newCar.info();
		newCar.run();
		newCar.run();
		newCar.stop();		
	}
	
}
