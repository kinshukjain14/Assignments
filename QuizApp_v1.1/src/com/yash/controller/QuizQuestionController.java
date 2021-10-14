package com.yash.controller;

import com.yash.exception.QuestionParsingException;
import com.yash.helper.QuizFactory;
import com.yash.model.SubjectDataModel;
import com.yash.service.QuizServices;

public class QuizQuestionController {
	
	private QuizServices service;
	
	public QuizQuestionController() {
		this.service = QuizFactory.newServicesInstance(); 
	}
	
	public SubjectDataModel handleSubjectquestion(String subjectName) throws QuestionParsingException {
		return service.getSubjectQuestions(subjectName); 
	}
	
	
}
