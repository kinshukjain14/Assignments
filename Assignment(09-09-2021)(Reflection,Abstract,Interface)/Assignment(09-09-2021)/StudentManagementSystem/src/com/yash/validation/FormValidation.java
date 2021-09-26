package com.yash.validation;

import java.util.regex.Pattern;

import com.yash.exception.InvalidInputException;

public class FormValidation {
	public static void validateContactNo(Long contact) 
	{
		String str = contact.toString();
		if(Pattern.matches("[6-9][0-9]{9}",str)) {
			return;
		}
		else {
			throw new InvalidInputException("Invalid Contact Number : must be of 10 digits and start with [6-9]");
		}
	}
	
	public static boolean validateName(String name) 
	{
		if(Pattern.matches("[a-zA-Z]*", name)) {
			return true;
		}
		return false;
	}
}
