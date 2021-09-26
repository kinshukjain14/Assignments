package com.yash.service;

import java.util.List;
import com.yash.model.StudentDataModel;

public interface StudentServices {
	public boolean registerStudent(StudentDataModel studentModel);
	public List<StudentDataModel> retrieveAllStudentData();
	public boolean updateStudentData(StudentDataModel studentModel);
	public String removeStudentDataModel(StudentDataModel studentModel);
}
