package com.yash.model;

public class StudentDataModel {
	private int rollNo;
	private String firstName;
	private String lastName;
	private int age;
	private long contactNo;
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	@Override
	public String toString() {
		return "Student [RollNo = " + rollNo + ", Name = " + firstName + " " + lastName + ", Age = "
				+ age + ", Contact No = " + contactNo + "]";
	}
	
	
}
