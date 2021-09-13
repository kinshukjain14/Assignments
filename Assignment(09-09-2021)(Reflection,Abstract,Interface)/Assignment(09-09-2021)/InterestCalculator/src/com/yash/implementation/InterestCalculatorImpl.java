package com.yash.implementation;

import com.yash.specification.InterestCalculator;

public class InterestCalculatorImpl implements InterestCalculator
{

	@Override
	public double getSimpleInterest(double principalAmount, double rateOfInterest, double timeInYears) {
		double interest = principalAmount * rateOfInterest * timeInYears;
		interest /=100;
		return interest;
	}

	@Override
	public double getCompoundInterest(double principalAmount, double rateOfInterest, double timeInYears) {
		double factor = 1+rateOfInterest/100;
		double interest = (principalAmount * Math.pow(factor,timeInYears)) - principalAmount;
		return interest;
	}
	
}
