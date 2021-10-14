package com.yash.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInputValidation 
{
	
	public boolean validateContactNumber(Long contactNo) 
	{
		String regex = "[6-9][0-9]{9}";
		return validate(contactNo.toString(),regex);
	}
	public boolean validateEmail(String emailId) 
	{
		String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		return validate(emailId,regex);
	}
	public boolean validateName(String name) 
	{
		String regex = "[a-zA-Z]\\s*";
		return validate(name,regex);
	}
	
	public boolean validate(String string, String regex) 
	{
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(string);
		if(matcher.find()) {
			return true;
		}
		return false;
	}
	
}