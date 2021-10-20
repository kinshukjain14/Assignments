package com.yash.service;

public class NumberCheck {
	private MobileCheck mobileCheck;

	public NumberCheck(MobileCheck mobileCheck) 
	{
		this.mobileCheck = mobileCheck;
	}

	public boolean check(String number) {
		return mobileCheck.checkMobileNumber(number);
	}
	
}
