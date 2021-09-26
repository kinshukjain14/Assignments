package com.yash.view;

import java.util.List;
import com.yash.controller.StudentController;
import com.yash.model.StudentDataModel;
import com.yash.validation.InputTypeValidator;

public class MainMenu {
	public void mainView() {
			StudentController controller = new StudentController();
			System.out.println("********************************* Welcome to Student Management System *********************************");
			while(true) 
			{
				InputTypeValidator validator = new InputTypeValidator();
				try {
				System.out.println("-------------- Main Menu --------------");
				System.out.println("1. Register Student");
				System.out.println("2. Update a Record");
				System.out.println("3. View all records");
				System.out.println("4. Delete a record");
				System.out.println("5. Exit");
				System.out.print("Enter choice : ");
				int choice=validator.takeIntegerInput();
				switch(choice) {
					case 1:
						System.out.print("Enter Roll No :");
						int rollNo =validator.takeIntegerInput();
						System.out.print("Enter First name : ");
						String firstName=validator.takeStringInput();
						System.out.print("Enter Last name : ");
						String lastName=validator.takeStringInput();
						System.out.print("Enter Age : ");
						int age = validator.takeIntegerInput();
						System.out.print("Enter Contact no : ");
						long contactNo = validator.takeLongInput();
						StudentDataModel model = new StudentDataModel();
						model.setRollNo(rollNo);
						model.setFirstName(firstName);
						model.setLastName(lastName);
						model.setAge(age);
						model.setContactNo(contactNo);
						boolean flag = controller.handleStudentRegistration(model);
						if(!flag)
							System.err.println("\n----- Data already exist -----\n");
						else
							System.out.println("\n----- Registered successfully -----\n");
						
						break;
					case 2:
						System.out.print("Enter Roll no. to update : ");
						rollNo = validator.takeIntegerInput();
						StudentDataModel studentData = controller.handleStudentRollNo(rollNo);
						if(studentData == null) {
							System.err.println("\n*** The Roll no. does not exist ***");
							System.out.println();
							continue;
						}
						else {
							System.out.println("Current Details : ");
							System.out.println(studentData);
						}
						loadUpdateMenu(studentData);
						flag = controller.handleDataUpdate(studentData);
						if(!flag)
						{
							System.err.println("\n--- Current & New data is same ---");
							System.out.println();
						}
						else
							System.out.println("\n--- Data updated ---\n");
						break;
					case 3:
						System.out.println("----------------- Available data ---------------------");
						List<StudentDataModel> dataRetrival = controller.handleStudentDataRetrival();
						if(dataRetrival.size() == 0) {
							System.out.println("**** No Data Found ****");
						}
						else {
							dataRetrival.forEach(System.out::println);							
						}
						System.out.println("------------------------------------------------------");
						System.out.print("\nReturn to Main Menu [Y/N] : ");
						String ip = validator.takeStringInput();
							if(ip.equalsIgnoreCase("Y"))
							{
								continue;
							}
							else {
								System.out.println("**************************** Thanks for visiting ****************************");
								validator = null;
								System.exit(0);
							}
						break;
					case 4:
						System.out.print("Enter Roll no. to delete : ");
						rollNo = validator.takeIntegerInput();
						studentData = controller.handleStudentRollNo(rollNo);
						if(studentData == null) {
							System.err.println("\n*** The Roll no. does not exist ***");
							System.out.println();
							continue;
						}
						else {
							System.out.println("Available data : ");
							System.out.println(studentData);
						}
						System.out.println("--- Summmary of Deleted Data ---");
						String dataDeleted = controller.handleDataDelete(studentData);
						System.out.println(dataDeleted);
						break;
					case 5:
						System.out.println("**************************** Thanks for visiting ****************************");
						validator = null;
						System.exit(0);
						break;
					default:
						System.err.println("\n=== Invalid Input ===");
						System.out.println();
						break;
				}
				}
				catch(Exception e) {
					System.err.println("\n"+e.getMessage());
					System.out.println();
				}
				validator=null;
			}	
	}
	
	public void loadUpdateMenu(StudentDataModel studentData) {
		InputTypeValidator validator = new InputTypeValidator();
		System.out.println("---- Select the desired option ----");
		System.out.println("1. Update Name");
		System.out.println("2. Update Age");
		System.out.println("3. Update Contact");
		int choice = validator.takeIntegerInput();
		switch(choice) {
			case 1 :
				System.out.print("Enter First Name : ");
				String firstName = validator.takeStringInput();
				System.out.print("Enter Last Name : ");
				String lastName = validator.takeStringInput();
				studentData.setFirstName(firstName);
				studentData.setLastName(lastName);
				break;
			case 2 :
				System.out.print("Enter Age : ");
				int age = validator.takeIntegerInput();
				studentData.setAge(age);
				break;
			case 3:
				System.out.print("Enter Contact : ");
				long contact = validator.takeLongInput();
				studentData.setContactNo(contact);
				break;
			default :
				System.err.println("\n--- Invalid Choice can't update ---");
				System.out.println();
				break;
		}
		validator=null;
	}
}
