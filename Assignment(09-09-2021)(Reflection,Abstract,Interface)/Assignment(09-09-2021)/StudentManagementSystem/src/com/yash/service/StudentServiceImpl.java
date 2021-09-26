package com.yash.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.yash.dao.StudentDAO;
import com.yash.entity.Student;
import com.yash.helper.StudentFactory;
import com.yash.model.StudentDataModel;

public class StudentServiceImpl implements StudentServices{
	private StudentDAO dao;
	private int key;
	public StudentServiceImpl() {
		super();
		this.dao = StudentFactory.getStudentDAO();
	}

	@Override
	public boolean registerStudent(StudentDataModel studentModel) {
		Student student = new Student();
		int id = (int)(Math.random()*100);
		student.setStudentId(id);
		student.setRollNo(studentModel.getRollNo());
		student.setFirstName(studentModel.getFirstName());
		student.setLastName(studentModel.getLastName());
		student.setAge(studentModel.getAge());
		student.setContactNo(studentModel.getContactNo());
		return dao.addStudentRecord(student);
	}

	@Override
	public List<StudentDataModel> retrieveAllStudentData() {
		List<StudentDataModel> list = new LinkedList<>();
		Map<Integer,Student> map = dao.getAllStudentRecord();
		List<Student> studentList = map.keySet().stream().map(x->map.get(x)).collect(Collectors.toList());
		studentList.stream().forEach(x->{
			StudentDataModel model = new StudentDataModel();
			model.setRollNo(x.getRollNo());
			model.setFirstName(x.getFirstName());
			model.setLastName(x.getLastName());
			model.setAge(x.getAge());
			model.setContactNo(x.getContactNo());
			list.add(model);
		});
		return list;
	}

	@Override
	public boolean updateStudentData(StudentDataModel studentModel) {
		Map<Integer, Student> allStudentRecord = dao.getAllStudentRecord();
		allStudentRecord.entrySet().stream().forEach(x->{
			if(x.getValue().getRollNo() == studentModel.getRollNo()) {
				this.key=x.getKey();
			}
		});
		Student student = new Student();
		student.setStudentId(this.key);
		student.setRollNo(studentModel.getRollNo());
		student.setFirstName(studentModel.getFirstName());
		student.setLastName(studentModel.getLastName());
		student.setAge(studentModel.getAge());
		student.setContactNo(studentModel.getContactNo());
		return dao.updateStudentRecord(student);
		
	}

	@Override
	public String removeStudentDataModel(StudentDataModel studentModel) 
	{
		Map<Integer, Student> allStudentRecord = dao.getAllStudentRecord();
		allStudentRecord.entrySet().stream().forEach(x->{
			if(x.getValue().getRollNo() == studentModel.getRollNo()) {
				this.key=x.getKey();
			}
		});
		return dao.deleteStudentRecord(this.key).toString();
	}
	
}
