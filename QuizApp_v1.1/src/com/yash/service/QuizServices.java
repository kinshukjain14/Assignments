package com.yash.service;

import com.yash.exception.QuestionParsingException;
import com.yash.model.SubjectDataModel;

public interface QuizServices 
{
	public SubjectDataModel getSubjectQuestions(String subjectName) throws QuestionParsingException;
}
