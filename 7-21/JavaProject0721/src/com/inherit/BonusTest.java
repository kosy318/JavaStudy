package com.inherit;

public class BonusTest {

	void printBonus(Employee who) {
		System.out.println(who.getBonus());
	}
	
	public static void main(String[] args) {
		Employee tom = new Employee(100, "tom cruise", 3000);
		BonusTest bt = new BonusTest();
		bt.printBonus(tom);
		
		Manager bill = new Manager(200, "bill", 5000, 111);
		bt.printBonus(bill);
	}
	
}
