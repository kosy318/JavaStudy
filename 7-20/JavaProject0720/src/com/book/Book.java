package com.book;

public class Book {
	
	String isbn;
	String title;
	String author;
	String publisher;
	int price;
	String desc;
	
	Book(){}

	public Book(String isbn, String title, String author, String publisher, int price, String desc) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}

	@Override
	public String toString() {
		return isbn + "\t | " + title + "\t | " + author + " | " + publisher + "\t | " + price + " | " + desc;
	}
	
}
