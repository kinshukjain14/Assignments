package com.yash.helper;

import com.yash.implementation.InterestCalculatorImpl;

	public class InterestCalculatorFactory {
	
		public static InterestCalculatorImpl getInstance() {
		return new InterestCalculatorImpl();
	}	
}
