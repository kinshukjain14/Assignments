package com.yash.dao;

import java.util.List;
import com.yash.model.StudentModel;

public interface StudentDAO {
	List<StudentModel> retriveStudentData();
	boolean storeStudentData(StudentModel student);
}
