package com.yash.view;

import java.util.Scanner;

import com.yash.exception.QuestionParsingException;
import com.yash.model.QuizScoreModel;
import com.yash.model.UserModel;
import com.yash.validation.UserInputValidation;

public class QuizMenuView 
{
	private static int candidateId;
	private static String moduleName;
	private static String candidateName;
	private static String candidateEmail;
	private static Long candidateContact;
	private static boolean quizScoreToStore;
	private static UserModel responseModel;
	
	public static void loadModuleMenu(Scanner sc, boolean quizScoreToStore,UserModel model) throws InterruptedException, QuestionParsingException 
	{
		QuizMenuView.quizScoreToStore = quizScoreToStore;
		QuizMenuView.responseModel=model;
		while (true) 
		{
			System.out.println("Select your desired module :\n(1) Java\n(2) SQL\n(3) HTML\n(4) CSS\n(5) Exit");
			System.out.print("Enter your choice:");
			int option=0;
			if(sc.hasNextInt()) 
			{
				option = sc.nextInt();
			}
			else 
			{
				System.out.println("=== Invalid Input : only integer value is allowed ===");
				sc.next();
				continue;
			}
			
			switch (option) 
			{
			case 1:
				moduleName="Java";
				loadCandidateDetailsForm(sc, moduleName, responseModel);
				testInstructions(sc,moduleName);
				option = 5;
				break;
			case 2:
				moduleName="SQL";
				loadCandidateDetailsForm(sc, moduleName, responseModel);
				testInstructions(sc,moduleName);
				option = 5;
				break;
			case 3:
				moduleName="HTML";
				loadCandidateDetailsForm(sc, moduleName, responseModel);
				testInstructions(sc,moduleName);
				option = 5;
				break;
			case 4:
				moduleName="CSS";
				loadCandidateDetailsForm(sc, moduleName, responseModel);
				testInstructions(sc,moduleName);
				option = 5;
				break;
			case 5:
				option=5;
				break;
			default:
				System.out.println("== Invalid choice selection : Try Again == ");
				continue;
			}
			
			if(option == 5)
			{
				System.out.println("***************************** Thanks for Visiting *****************************");
				System.exit(0);
			}
		}

	}

	public static void loadCandidateDetailsForm(Scanner sc,String moduleName, UserModel model) throws InterruptedException 
	{
		System.out.println("\n****** Complete Candidate Details *******");
		int max = 10000;
		int min = 10;
		int range = max - min + 1;
		candidateId = (int) (Math.random() * range) + min;
		System.out.println("Your candidate id for this quiz is : " + candidateId);
		System.out.println("Module Selected : "+moduleName);

		if(model != null) {
			candidateName=model.getName();
			candidateEmail=model.getEmail();
			candidateContact=model.getContactNo();
			System.out.println("Candidate Name : "+candidateName);
			System.out.println("Candidate Email : "+candidateEmail);
			System.out.println("Candidate Contact No. : "+candidateContact);
			System.out.println("******************************************\n");
			Thread.sleep(3000);
			return;
		}
		
		UserInputValidation validator = new UserInputValidation();
		while(true) {
			System.out.print("Enter Name : ");			
			sc.nextLine();
			candidateName = sc.nextLine();
			if (!validator.validateName(candidateName)) {
				System.out.println("== Invalid : Name cannot contains special charaters and numeric values ==\n");
				continue;
			}
			break;
		}
		
		while(true) {
			System.out.print("Enter email id : ");			
			candidateEmail = sc.next();
			if (!validator.validateEmail(candidateEmail)) {
				System.out.println("== Invalid Email Id ==\n");
				continue;
			}
			break;
		}
		
		while(true) 
		{
			System.out.print("Enter contact no : ");	
			if(sc.hasNextLong()) 
			{
				candidateContact = sc.nextLong();				
				if(!validator.validateContactNumber(candidateContact)) {
					System.out.println("=== Invalid Contact number ===\n");
					continue;					
				}
				break;
			}
			else {
				System.out.println("== Invalid Input : required numeric value ==\n");
				continue;
			}
		}
	}

	public static void testInstructions(Scanner sc, String moduleName) throws InterruptedException, QuestionParsingException 
	{
		System.out.println("\n****** Instructions for Quiz ******");
		System.out.println("1.No of questions is 10 and available time is 10 min.");
		System.out.println("2.Candidate cannot visit the answer again if already attempted the questions.");
		System.out.println("3.Candidate have to attempt all the questions.");
		System.out.println("4.Each question carries 1 mark.");
		System.out.print("\nWant to start? [y/n] : ");
		String command = sc.next();
		if(command.equalsIgnoreCase("y")) {
				QuizScoreModel quizModel = new QuizScoreModel();
				quizModel.setCandidateId(candidateId);
				quizModel.setCandidateName(candidateName);
				quizModel.setModuleName(moduleName);
				System.out.println("\n******** Loding Quiz********\n");
				QuizLoaderView.loadQuiz(sc, moduleName,quizModel,QuizMenuView.quizScoreToStore);
		}
		else {
			System.out.println("\n****************************************************\n");
			loadModuleMenu(sc,QuizMenuView.quizScoreToStore,responseModel);
		}
		
	}

}
