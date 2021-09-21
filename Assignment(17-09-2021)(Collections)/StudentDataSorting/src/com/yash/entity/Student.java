package com.yash.entity;

public class Student {
	
	public int rollNo;
	public String firstName;
	public String lastName;
	public int age;
	public double semesterMark1;
	public double semesterMark2;
	public double semesterMark3;
	public double percentage;
	
	public Student() 
	{
		
	}
	
	@Override
	public String toString() {
		return "Student [RollNo : " + rollNo + ", Name : " + firstName +" "+lastName + ", Age : " + age
				+ ", Semester1 : " + semesterMark1 + ", Semester2 : " + semesterMark2 + ", Semester3 : "
				+ semesterMark3 + ", Percentage : " + percentage + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(percentage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + rollNo;
		temp = Double.doubleToLongBits(semesterMark1);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(semesterMark2);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(semesterMark3);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (Double.doubleToLongBits(percentage) != Double.doubleToLongBits(other.percentage))
			return false;
		if (rollNo != other.rollNo)
			return false;
		if (Double.doubleToLongBits(semesterMark1) != Double.doubleToLongBits(other.semesterMark1))
			return false;
		if (Double.doubleToLongBits(semesterMark2) != Double.doubleToLongBits(other.semesterMark2))
			return false;
		if (Double.doubleToLongBits(semesterMark3) != Double.doubleToLongBits(other.semesterMark3))
			return false;
		return true;
	}
	
}