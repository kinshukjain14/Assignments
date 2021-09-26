package com.yash.dao;

import java.util.Map;

import com.yash.entity.Student;

public interface StudentDAO {
	public boolean addStudentRecord(Student student);
	public Map<Integer,Student> getAllStudentRecord();
	public Student deleteStudentRecord(Integer key);
	public boolean updateStudentRecord(Student student);
}
