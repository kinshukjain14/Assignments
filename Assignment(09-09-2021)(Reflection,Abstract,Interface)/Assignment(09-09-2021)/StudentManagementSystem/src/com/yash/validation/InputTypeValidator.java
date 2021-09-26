package com.yash.validation;

import java.util.Scanner;
import com.yash.exception.InvalidInputException;

public class InputTypeValidator
{
	private Scanner sc = new Scanner(System.in);
	public int takeIntegerInput()
	{
		int input=0;
			if(sc.hasNextInt()) {
				input=sc.nextInt();
			}
			else {
				input=0;
				throw new InvalidInputException("Invalid input : expected integer value");
			}
		
		return input;
	}
	
	public long takeLongInput()
	{
		long input=0;
			if(sc.hasNextLong()) {
				input=sc.nextLong();
				FormValidation.validateContactNo(input);
			}
			else {
				throw new InvalidInputException("Invalid input : expected integer value");
			}
		
		return input;
	}
	
	public String takeStringInput() {
		String input="";
			input = sc.next();
			if(FormValidation.validateName(input)) {
				return input;
			}
			else {
				throw new InvalidInputException("Invalid input : Name cannot contains numbers and special characters");
			}
		
	}
}
