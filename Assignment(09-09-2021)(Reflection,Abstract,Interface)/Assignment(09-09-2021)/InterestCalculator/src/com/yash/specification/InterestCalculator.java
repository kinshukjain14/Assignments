package com.yash.specification;

public interface InterestCalculator {
	public double getSimpleInterest(double principalAmount,double rateOfInterest,double timeInYears);
	public double getCompoundInterest(double principalAmount,double rateOfInterest,double timeInYears);
}
