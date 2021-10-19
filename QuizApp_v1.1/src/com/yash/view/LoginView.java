package com.yash.view;

import java.util.Scanner;

import com.yash.controller.UserAuthController;
import com.yash.exception.AuthenticationException;
import com.yash.exception.QuestionParsingException;
import com.yash.exception.UserDataNotFoundException;
import com.yash.model.UserModel;

public class LoginView 
{

	public static void login(Scanner sc) throws InterruptedException, QuestionParsingException 
	{
		int choice=0;
		while(true) 
		{
			System.out.println("\n=== Main Menu ===");
			System.out.println("1. Login user");
			System.out.println("2. Attempt quiz as a Guest");
			System.out.println("3. Exit");
			System.out.print("Enter choice : ");
			if(sc.hasNextInt()) 
			{
				 choice = sc.nextInt();
					if(choice == 1) 
					{
						System.out.print("Enter user name : ");
						String userName = sc.next();
						System.out.print("Enter Password : ");
						String password=sc.next();
						UserModel userModel = new UserModel();
						userModel.setUserName(userName);
						userModel.setPassword(password);
						UserAuthController authController = new UserAuthController();
						try {							
							if(authController.handleUserAuth(userModel)) {
								System.out.println("** Authentication Successful **");
								UserModel responseModel = authController.handleUserDetailsRequest();
								QuizMenuView.loadModuleMenu(sc,true,responseModel);							
								break;
							}		
						}
						catch(AuthenticationException | UserDataNotFoundException e) {
							System.err.println(e.getMessage());
							System.out.println();
							Thread.sleep(500);
							continue;
						}
					}
					else if(choice == 2) {
						System.out.println(">> Important Information : You are started this quiz as a guest your result scores cannot be stored after quiz completion");
						Thread.sleep(1000);
						QuizMenuView.loadModuleMenu(sc,false,null);
						break;
					}
					else if(choice == 3) {
						return;
					}
					else {
						System.err.println("=== Invalid Input ===");
						Thread.sleep(500);
						continue;
					}
			}
			else {
				System.err.println("=== Invalid Input ===");
				sc.next();
				Thread.sleep(500);
				continue;
			}			
		}

	}
}
