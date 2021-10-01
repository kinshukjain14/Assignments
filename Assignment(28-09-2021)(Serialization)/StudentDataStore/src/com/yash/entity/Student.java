package com.yash.entity;
import java.io.Serializable;
import java.util.List;

public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int rollNo;
	private String name;
	private List<Double> scoreList;
	
	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", Scores =" + scoreList + " ]";
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setScoreList(List<Double> scoreList) {
		this.scoreList = scoreList;
	}

	public int getRollNo() {
		return rollNo;
	}

	public String getName() {
		return name;
	}

	public List<Double> getScoreList() {
		return scoreList;
	}	
}
