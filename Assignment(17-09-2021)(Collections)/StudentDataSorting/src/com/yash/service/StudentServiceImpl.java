package com.yash.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.yash.controller.SortType;
import com.yash.dao.StudentDAO;
import com.yash.helper.StudentFactory;
import com.yash.model.StudentModel;

public class StudentServiceImpl implements StudentService {

	@Override
	public List<StudentModel> retrieveStudentService(SortType sortBy) {
		StudentDAO data = StudentFactory.getMemoryStudentDAO();
		List<StudentModel> studentModel = data.retriveStudentData()  ;
		switch(sortBy)
		{
		case ROLLNO:
				Collections.sort(studentModel,new Comparator<StudentModel>() {
					@Override
					public int compare(StudentModel o1, StudentModel o2) {
						if(o1.getRollNo() > o2.getRollNo())
							return 1;
						else if (o1.getRollNo()<o2.getRollNo())
							return -1;
						else
							return 0;									
					}					
				});
				break;
		case FIRSTNAME:
				Collections.sort(studentModel,new Comparator<StudentModel>() {
					@Override
					public int compare(StudentModel o1, StudentModel o2) {
						return o1.getFirstName().compareTo(o2.getFirstName());
					}
					
				});
				break;
		case LASTNAME:
			Collections.sort(studentModel,new Comparator<StudentModel>() {
				@Override
				public int compare(StudentModel o1, StudentModel o2) {
					return o1.getLastName().compareTo(o2.getLastName());
				}
			});
				break;
		case AGE :
			Collections.sort(studentModel,new Comparator<StudentModel>() {
				@Override
				public int compare(StudentModel o1, StudentModel o2) {
					if(o1.getAge() > o2.getAge())
						return 1;
					else if (o1.getAge()<o2.getAge())
						return -1;
					else
						return 0;									
				}					
			});
				break;
		case PERCENTAGE:
			Collections.sort(studentModel,new Comparator<StudentModel>() {
				@Override
				public int compare(StudentModel o1, StudentModel o2) {
					if(o1.getPercentage() > o2.getPercentage())
						return -1;
					else if (o1.getPercentage()<o2.getPercentage())
						return 1;
					else
						return 0;									
				}					
			});
				break;
		default :
				break;
		}
		return studentModel;
	}


}
