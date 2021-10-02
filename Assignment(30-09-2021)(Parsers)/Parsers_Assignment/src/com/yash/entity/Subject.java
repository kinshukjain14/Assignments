package com.yash.entity;

import java.util.List;

public class Subject {
	private int subjectCode;
	private String subjectName;
	private List<Question> questions;
	
	public Subject(int subjectCode, String subjectName, List<Question> questions) 
	{
		super();
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.questions = questions;
	}

	public int getSubjectCode() 
	{
		return subjectCode;
	}

	public String getSubjectName() 
	{
		return subjectName;
	}

	public List<Question> getQuestions() 
	{
		return questions;
	}
	
	
}
