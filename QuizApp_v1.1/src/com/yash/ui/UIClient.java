package com.yash.ui;

import java.util.Scanner;

import com.yash.exception.QuestionParsingException;
import com.yash.exception.QuizRepositoryException;
import com.yash.repository.CreateXML;
import com.yash.view.LoginView;

public class UIClient 
{
	public static void main(String[] args) 
	{
		try(Scanner sc = new Scanner(System.in))
		{
			System.out.println("***************************** Welcome to Quiz System CLI *****************************");
			CreateXML.generateXML();
			LoginView.login(sc);
			System.out.println("***************************** Thanks for Visiting *****************************");
			
		}
		catch(QuizRepositoryException | InterruptedException | QuestionParsingException e) {
			System.err.println("***** Error in Application *****");
			System.err.println(e.getMessage());
		}
	}
}
