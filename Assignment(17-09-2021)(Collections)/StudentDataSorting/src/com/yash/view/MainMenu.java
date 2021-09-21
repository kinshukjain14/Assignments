package com.yash.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.yash.controller.SortType;
import com.yash.controller.StudentController;
import com.yash.exception.DataModelException;
import com.yash.model.StudentModel;

public class MainMenu 
{	
	private static Scanner sc;

	public static void mainView() 
	{
		System.out.println("======== Welcome to Student App ========\n");
		System.out.println("** Enter Students Records **\n");
		System.out.print("Enter students count to be registered : ");
		int studentCount = 0;	
		try (Scanner sc = new Scanner(System.in)) {
			studentCount=sc.nextInt();
			boolean flag = true;
			while(flag) {
				flag = MainMenu.studentRegistrationForm(studentCount);
			}
			flag=true;
			while(flag) {
				flag=MainMenu.mainMenu();
			}
		}
		catch (DataModelException | InputMismatchException e) {
			System.err.println(e.getMessage());
		}
	}

	public static boolean mainMenu() {
			System.out.println("\n\n*************** Main Menu ***************");
			System.out.println("1. Display all data");
			System.out.println("2. Sort data using student Age");
			System.out.println("3. Sort data using First Name");
			System.out.println("4. Sort data using Last Name");
			System.out.println("5. Sort data using Percentage");
			System.out.println("6. Exit");

			System.out.print("\nEnter Choice : ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				StudentViews.displayAllStudentData(SortType.ROLLNO);
				break;
			case 2:
				StudentViews.displayAllStudentData(SortType.AGE);
				break;
			case 3:
				StudentViews.displayAllStudentData(SortType.FIRSTNAME);
				break;
			case 4:
				StudentViews.displayAllStudentData(SortType.LASTNAME);
				break;
			case 5:
				StudentViews.displayAllStudentData(SortType.PERCENTAGE);
				break;
			case 6:
				System.out.println("****** Thank you ******");
				return false;
			default:
				System.out.println("***** Invalid choice *****");
			}

		return true;
	}

	public static boolean studentRegistrationForm(int studentCount) throws DataModelException {
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
				System.out.print("Enter age : ");
				int age = sc.nextInt();
				System.out.print("Enter Semester 1 marks : ");
				double semesterMark1 = sc.nextDouble();
				System.out.print("Enter Semester 2 marks : ");
				double semesterMark2 = sc.nextDouble();
				System.out.print("Enter Semester 3 marks : ");
				double semesterMark3 = sc.nextDouble();
				StudentModel model = new StudentModel();
				model.setRollNo(rollNo);
				model.setFirstName(firstName);
				model.setLastName(lastName);
				model.setAge(age);
				model.setSemesterMark1(semesterMark1);
				model.setSemesterMark2(semesterMark2);
				model.setSemesterMark3(semesterMark3);
				model.setPercentage(semesterMark1, semesterMark2, semesterMark3);

				StudentController controller = new StudentController();
				boolean status = controller.handleStudentRegister(model);

				if (status == true) {
					System.out.println("\n========== Student " + i + " registered ==========\n");
				}
				else {
					throw new DataModelException("Error in Application");
				}

				}
		return false;
	}
}
