package com.yash.service;

public class CountPrimeNumbers {

	public int getCount(int[] inputArr) 
	{
		int count =0;
		if(inputArr.length == 0) {
			throw new RuntimeException("Array Length cannot be zero");
		}
		for (int i = 0; i < inputArr.length; i++) {
			if(checkPrime(inputArr[i])) {
				count++;
			}
		}
		
		return count;
	}
	
	boolean checkPrime(int number) 
	{
		int flag=0;
		if(number == 1 || number == 0) 
		{
			return false;
		}
		
		for(int i=2; i <= Math.sqrt(number) ; i++) 
		{
			if(number%i == 0) 
			{
				flag=1;
				break;
			}
		}
		
		if(flag == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
