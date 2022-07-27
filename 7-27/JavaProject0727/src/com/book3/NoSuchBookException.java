package com.book3;

public class NoSuchBookException extends Exception {
	private String isbn;

	public NoSuchBookException(String isbn) {
		super();
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "NoSuchBookException [isbn=" + isbn + "]";
	}
	
}
