package com.yash.service;

import java.util.List;

import com.yash.controller.SortType;
import com.yash.model.StudentModel;

public interface StudentService {
	List<StudentModel> retrieveStudentService(SortType sortBy);
}
