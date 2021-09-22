package com.yash.exception;

public class InvalidInputException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	String message;
	public InvalidInputException(String message) {
		super(message);
		this.message=message;
	}
	
	public String getMessage() {
		return message;
	}
}
