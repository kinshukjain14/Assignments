package com.yash.view;

import java.util.List;

import com.yash.controller.SortType;
import com.yash.controller.StudentController;
import com.yash.model.StudentModel;

public class StudentViews
{	
	private static StudentController controller = new StudentController();
	
	public static void displayAllStudentData(SortType sortType) 
	{
		System.out.println("\n=========================================== Required Data ===========================================\n");
		List<StudentModel> retrieveStudentService = controller.handleStudentDataRequest(sortType);
		for (StudentModel studentModel : retrieveStudentService) {
			System.out.println(studentModel);
		}
		System.out.println("\n=========================================== *** *** *** *** ===========================================\n");
	}
	
}
