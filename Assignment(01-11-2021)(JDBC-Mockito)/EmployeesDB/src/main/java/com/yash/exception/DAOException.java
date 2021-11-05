package com.yash.exception;

public class DAOException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public DAOException(Throwable throwable,String message) {
		super(throwable);
		this.message=message;
	}

	public String getMessage() {
		return message;
	}
	
	

}
