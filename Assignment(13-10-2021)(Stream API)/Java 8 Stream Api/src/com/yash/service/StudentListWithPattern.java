package com.yash.service;

import java.util.List;
import java.util.stream.Collectors;

import com.yash.entity.Student;

public class StudentListWithPattern 
{
	public static void main(String[] args) 
	{
		List<Student> students = Student.getStudents();
		List<Student> filteredStudents = students
		.stream()
		.filter(x->x.getFirstName().contains("Ai"))
		.collect(Collectors.toList());
		
		System.out.println("************ Students that contains pattern 'ai' ************");
		filteredStudents.forEach(System.out::println);
	}
}
