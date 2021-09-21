package com.yash.exception;

public class DataModelException extends Exception {
	String message;
	public DataModelException(String message){
		this.message = message;
	}
}
