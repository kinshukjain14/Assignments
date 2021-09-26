package com.yash.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.yash.helper.StudentFactory;
import com.yash.model.StudentDataModel;
import com.yash.service.StudentServices;

public class StudentController
{
	private StudentServices services;
	
	public StudentController() {
		super();
		this.services=StudentFactory.getStudentServices();
	}

	public boolean handleStudentRegistration(StudentDataModel model) {
		return services.registerStudent(model);
	}
	
	public List<StudentDataModel> handleStudentDataRetrival() {
		return services.retrieveAllStudentData();
	}
	
	public boolean handleDataUpdate(StudentDataModel model) {
		return services.updateStudentData(model);
	}
	
	public String handleDataDelete(StudentDataModel model) {
		return services.removeStudentDataModel(model);
	}
	
	public StudentDataModel handleStudentRollNo(int rollNo) {
		List<StudentDataModel> studentData = services.retrieveAllStudentData();
		studentData = studentData.stream().filter(x->rollNo==x.getRollNo()).collect(Collectors.toList());
		if(studentData.size() == 0)
			return null;
		return studentData.get(0);
	}
}
