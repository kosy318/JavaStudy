package com.object;

public class Car {
	
	// member, field, data, attribute
	int num;
	String model;
	String owner;
	boolean running = false;
	
	// constructor
	Car() { // default constructor
		this(0); // 积己磊 郴 积己磊 荤侩
	}
	// constructor with parameters
	Car(int num) {
		this(num, null);
	}
	Car(int num, String model){
		this(num, model, null);
	}
	Car(int num, String model, String owner) {
		this.num = num;
		this.model = model;
		this.owner = owner;
		
		System.out.println("Car 积己--------");
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
		else System.out.println("already running...");
		running = true;
	}
	
	public void stop() {
		if(running) System.out.println("stop!!!");
		else System.out.println("already stopped.");
		running = false;
	}
	
	public static void main(String[] args) {
		Car c1 = new Car();
		Car c2 = new Car(1234);
		Car c3 = new Car(4567, "k5");
		
		Car newCar = new Car(7891, "k3", "Tom");

		newCar.owner = "Jerry";
		
		newCar.info();
		newCar.run();
		newCar.run();
		newCar.stop();
	}
	
}
