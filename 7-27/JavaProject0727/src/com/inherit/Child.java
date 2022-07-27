package com.inherit;
class Parent{
	
	String name = "tom";
	String address = "seoul";
	
	Parent(){
		System.out.println("Parent 생성자");
	}
	
	protected String getName() {
		return name;
	}
	public String getAddress() throws Exception{
		return address;
	}
	
}

public class Child extends Parent{
	
	String email;
	
	Child(){
		System.out.println("Child 생성자");
	}
	
	@Override
	public String getName() {
		return "tomson";
	}
	
	void callSuper() {
		System.out.println(super.getName());
	}

	@Override
	public String getAddress() throws Exception {
		if(address.equals("")) {
			throw new Exception();
		}
		return "london";
	}

	public static void main(String[] args) {
		Child c = new Child();
		
		System.out.println(c.getName());
		try {
			System.out.println(c.getAddress());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(c.name);
	}
	
}