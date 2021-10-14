package com.yash.entity;

import java.util.LinkedList;
import java.util.List;

public class Question 
{
	private List<String> questions;
	private Option option;
	
	public Question() {
		this.questions = new LinkedList<String>();
	}

	public List<String> getQuestions() {
		return questions;
	}

	public void setQuestions(List<String> questions) {
		this.questions = questions;
	}

	public Option getOption() {
		return option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

}
