package com.yash.dao;

import java.util.Map;
import java.util.TreeMap;

import com.yash.entity.Student;

public class MemoryDAOImpl implements StudentDAO {
	private Map<Integer,Student> map ;
	
	public MemoryDAOImpl() {
		super();
		this.map = new TreeMap<Integer, Student>();
	}

	@Override
	public boolean addStudentRecord(Student student)
	{
		return map.put(student.getStudentId(),student) == null;
	}

	@Override
	public Map<Integer, Student> getAllStudentRecord() {
		return map;
	}

	@Override
	public Student deleteStudentRecord(Integer key) {
		return map.remove(key);
	}
	
	@Override
	public boolean updateStudentRecord(Student student) {
		return !map.put(student.getStudentId(), student).equals(student);
	}

}
