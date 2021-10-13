package com.yash.service;

import java.util.List;

import com.yash.entity.Student;

public class CountStudentWithK {
	public static void main(String[] args) {
		List<Student> students = Student.getStudents();
		long count = students
		.stream()
		.filter(name->name.getFirstName().startsWith("K"))
		.count();
		
		System.out.println("Students count whose name starts with 'K' : "+count);
	}
}
