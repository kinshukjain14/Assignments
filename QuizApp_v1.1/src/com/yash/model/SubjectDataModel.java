package com.yash.model;

import java.util.List;

public class SubjectDataModel 
{
	List<QuestionModel> questionsList;

	public SubjectDataModel(List<QuestionModel> questionsList) {
		super();
		this.questionsList = questionsList;
	}

	public List<QuestionModel> getQuestionsList() {
		return questionsList;
	}
	
}
