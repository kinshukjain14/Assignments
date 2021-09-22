package com.yash.validation;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.yash.exception.InvalidInputException;

public class InputValidator
{
	private static Scanner sc = new Scanner(System.in);
	public int takeIntegerInput()
	{
		int input=0;
		try{
			if(sc.hasNextInt()) {
				input=sc.nextInt();
			}
			else {
				throw new InvalidInputException("Invalid input : expected integer value");
			}
		}
		catch(InvalidInputException e) 
		{
			System.err.println(e.getMessage());
		}
		return input;
	}
	
	public String takeStringInput() {
		String input="";
		try{
			input = sc.next();
			if(Pattern.matches("[a-zA-Z]", input)) {
				return input;
			}
			else {
				throw new InvalidInputException("Invalid input : expected string value");
			}
		}
		catch(InvalidInputException e) {
			System.err.println(e.getMessage());
			return "";
		}
	}
}
