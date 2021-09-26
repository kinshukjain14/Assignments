package com.yash.helper;

import com.yash.dao.MemoryDAOImpl;
import com.yash.dao.StudentDAO;
import com.yash.service.StudentServiceImpl;
import com.yash.service.StudentServices;

public class StudentFactory {
	public static StudentServices getStudentServices() {
		return new StudentServiceImpl();
	}
	
	public static StudentDAO getStudentDAO() {
		return new MemoryDAOImpl();
	}
}
