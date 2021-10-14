package com.yash.exception;

public class UserDataNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	public UserDataNotFoundException(String message) {
		super(message);
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
	
	
}
