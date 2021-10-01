package com.yash.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.yash.entity.Student;
import com.yash.model.StudentModel;
import com.yash.service.DeserializeObject;
import com.yash.service.SerializeObject;


public class MainMenu {
	
	private static Scanner sc;
	private static List<Student> studentsList = new ArrayList<>();
	
	public static void main(String[] args) {
		MainMenu.mainView();
	}

	public static void mainView() 
	{
		System.out.println("======== Welcome to Student App ========\n");
		System.out.println("** Enter Students Records **\n");
		System.out.print("Enter students count to be registered : ");
		int studentCount = 0;	
		try (Scanner sc = new Scanner(System.in)) {
			studentCount=sc.nextInt();
			MainMenu.studentRegistrationForm(studentCount);
			
			boolean state = new SerializeObject().serializeStudentObject(studentsList);
			if(state == true) {
				System.out.println("************ Serialisation Done ************\n");
			}
			else {
				throw new IOException();
			}
			System.out.println("************ Deserialising ************ ");
			List<StudentModel> objectsList = new DeserializeObject().deserializeStudentObject();
			Comparator<StudentModel> comp = (obj1,obj2) -> {
				return -obj1.getPercentage().compareTo(obj2.getPercentage());
			};
			Collections.sort(objectsList,comp);
			
			System.out.println("****** Desired Results ********");
			objectsList.forEach(System.out::println);
		}
		catch (InputMismatchException | IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void studentRegistrationForm(int studentCount) {
		sc = new Scanner(System.in);
		for (int i = 1; i <= studentCount; i++) 
		{
			System.out.println("\n========== Student " + i + " Details ==========");
			System.out.print("Enter Roll no : ");
			int rollNo = sc.nextInt();
			System.out.print("Enter Firstname : ");
			String firstName = sc.next();
			System.out.print("Enter Lastname : ");
			String lastName = sc.next();
			List<Double> markList=new ArrayList<>();
			
			for (int j = 1; j <= 6; j++) {
				System.out.print("Enter subject "+j+" marks : ");
				Double mark = sc.nextDouble();
				markList.add(mark);
			}
			
			Student student = new Student();
			student.setRollNo(rollNo);
			student.setName(firstName+" "+lastName);
			student.setScoreList(markList);
			studentsList.add(student);
			}
	}

}
