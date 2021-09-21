package com.yash.controller;

import java.util.List;

import com.yash.dao.StudentDAO;
import com.yash.helper.StudentFactory;
import com.yash.model.StudentModel;
import com.yash.service.StudentService;

public class StudentController {
	public boolean handleStudentRegister(StudentModel model) {
		StudentDAO studentDao = StudentFactory.getMemoryStudentDAO();
		return studentDao.storeStudentData(model);
	}
	
	public List<StudentModel> handleStudentDataRequest(SortType sortType) 
	{
		StudentService studentService= StudentFactory.getStudentFactory();
		return studentService.retrieveStudentService(sortType);
	}
}
