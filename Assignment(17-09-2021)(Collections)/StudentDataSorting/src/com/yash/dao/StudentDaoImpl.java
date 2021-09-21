package com.yash.dao;

import java.util.ArrayList;
import java.util.List;

import com.yash.entity.Student;
import com.yash.model.StudentModel;

public class StudentDaoImpl implements StudentDAO {
	private static List<StudentModel> studentList = new ArrayList<>();

	@Override
	public boolean storeStudentData(StudentModel student) {
		if(student == null) {
			return false;
		}
		studentList.add(student);
		return true;
	}

	@Override
	public List<StudentModel> retriveStudentData() {
		return studentList;
	}

}
