package com.book3;

public class DuplicatedISBNException extends Exception {
	private String isbn;

	public DuplicatedISBNException(String isbn) {
		super();
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "DuplicatedISBNException [isbn=" + isbn + "]";
	}
	
}
