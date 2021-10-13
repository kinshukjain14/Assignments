package com.yash.service;

import java.util.List;

import com.yash.entity.Student;

public class DisplayFullName {
	public static void main(String[] args) {
		List<Student> students = Student.getStudents();
		System.out.println("************ Students Names **************");
		students
		.forEach(x->System.out.println(x.getFirstName().toUpperCase()+" "+x.getLastName().toUpperCase()));
		System.out.println("******************************************");
	}
}
