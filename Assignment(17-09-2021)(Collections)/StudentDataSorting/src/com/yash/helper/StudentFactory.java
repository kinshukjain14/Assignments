package com.yash.helper;

import com.yash.dao.StudentDAO;
import com.yash.dao.StudentDaoImpl;
import com.yash.service.StudentService;
import com.yash.service.StudentServiceImpl;

public class StudentFactory {
	public static StudentService getStudentFactory() {
		return new StudentServiceImpl();
	}
	
	public static StudentDAO getMemoryStudentDAO() {
		return new StudentDaoImpl();
	}
}
