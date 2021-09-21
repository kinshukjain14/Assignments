package com.yash.model;

import com.yash.entity.Student;

public class StudentModel{
	
	private Student data = new Student();

	public int getRollNo() {
		return data.rollNo;
	}
	public void setRollNo(int rollNo) {
		this.data.rollNo = rollNo;
	}
	public String getFirstName() {
		return data.firstName;
	}
	public void setFirstName(String firstName) {
		this.data.firstName = firstName;
	}
	public String getLastName() {
		return data.lastName;
	}
	public void setLastName(String lastName) {
		this.data.lastName = lastName;
	}
	public int getAge() {
		return data.age;
	}
	public void setAge(int age) {
		this.data.age = age;
	}
	public double getSemesterMark1() {
		return data.semesterMark1;
	}
	public void setSemesterMark1(double semesterMark1) {
		this.data.semesterMark1 = semesterMark1;
	}
	public double getSemesterMark2() {
		return data.semesterMark2;
	}
	public void setSemesterMark2(double semesterMark2) {
		this.data.semesterMark2 = semesterMark2;
	}
	public double getSemesterMark3() {
		return data.semesterMark3;
	}
	public void setSemesterMark3(double semesterMark3) {
		this.data.semesterMark3 = semesterMark3;
	}
	public double getPercentage() {
		return data.percentage;
	}
	public void setPercentage(double semesterMark1,double semesterMark2, double semesterMark3)
	{
		double percentage = ((semesterMark1 + semesterMark2 + semesterMark3) * 100) / 300 ;
		this.data.percentage = percentage;
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
	@Override
	public int hashCode() {
		return data.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		return data.equals(obj);
	}
	
	

}
