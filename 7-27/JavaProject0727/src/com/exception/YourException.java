package com.exception;

public class YourException extends Exception {
	
	String message;

	public YourException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "YourException [message=" + message + "]";
	}

}
