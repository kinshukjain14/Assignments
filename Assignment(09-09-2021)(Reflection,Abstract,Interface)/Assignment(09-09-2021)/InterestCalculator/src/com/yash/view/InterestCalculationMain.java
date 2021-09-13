package com.yash.view;

import java.util.Scanner;
import com.yash.helper.InterestCalculatorFactory;
import com.yash.specification.InterestCalculator;

public class InterestCalculationMain 
{
	
	public static void main(String[] args) 
	{
		System.out.println("------------ Welcome to Interest Calculator ------------");
		InterestCalculator calculate = InterestCalculatorFactory.getInstance();
		Scanner sc = new Scanner(System.in);
		while(true) 
		{
			System.out.println("** Select the desired menu option **");
			System.out.println("1. Calculate Simple Interest");
			System.out.println("2. Calculate Coumpound Interest");
			System.out.println("3. Exit");
			
			System.out.println("\n Enter your choice : ");
			int choice = sc.nextInt();	
			
			if(choice == 3) 
			{
				System.out.println("\n*********** Thank you ***********\n");
				break;
			}
			
			System.out.print("\nEnter Principal Amount : ");
			double principalAmount = sc.nextDouble();
			System.out.print("\nEnter Rate of Interest : ");
			double rateOfInterest=sc.nextDouble();
			System.out.print("\nEnter Time (in years) : ");
			double timeInYears = sc.nextDouble();
			
			switch(choice)
			{
				case 1:
					double interest = calculate.getSimpleInterest(principalAmount, rateOfInterest, timeInYears);
					System.out.println("\nSimple Interest : "+interest);
					System.out.println("Amount : "+(principalAmount+interest));
					System.out.println();
					break;
				case 2:
					interest=calculate.getCompoundInterest(principalAmount, rateOfInterest, timeInYears);
					System.out.println("\nCompound Interest : "+interest);
					System.out.println("Amount : "+(principalAmount+interest));
					System.out.println();
					break;
				default:
					System.out.println("Enter valid choice");
					break;
			}
			
		}
		sc.close();
	}

}
