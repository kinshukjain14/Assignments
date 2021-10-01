package com.yash.model;

import java.util.List;

public class StudentModel{
	private int rollNo;
	private String name;
	private List<Double> scoreList;
	private Double percentage;
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Double> getScoreList() {
		return scoreList;
	}
	public void setScoreList(List<Double> scoreList) {
		this.scoreList = scoreList;
	}
	public Double getPercentage() {
		return percentage;
	}
	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	@Override
	public String toString() {
		return "StudentModel [rollNo=" + rollNo + ", name=" + name + ", percentage=" + percentage + "]";
	}
	
}
