package com.yash.model;

import java.util.Map;

public class QuestionModel {
	String question;
	Map<String,Boolean> optionsMap;
	public QuestionModel(String question, Map<String, Boolean> optionsMap) {
		super();
		this.question = question;
		this.optionsMap = optionsMap;
	}
	public String getQuestion() {
		return question;
	}
	public Map<String, Boolean> getOptionsMap() {
		return optionsMap;
	}
		
}
