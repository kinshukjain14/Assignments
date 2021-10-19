package com.yash.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.yash.exception.QuestionParsingException;
import com.yash.helper.QuizFactory;
import com.yash.model.QuestionModel;
import com.yash.model.SubjectDataModel;
import com.yash.service.QuizServices;

class TestQuizService {

	private static QuizServices quizServices;

	@BeforeAll
	static void setUpBeforeClass() {
		quizServices = QuizFactory.newServicesInstance();
	}

	@AfterAll
	static void tearDownAfterClass() {
		quizServices=null;
	}

	@DisplayName("Get Questions list : positive")
	@Test
	void test1() {
		try {
			SubjectDataModel subjectQuestions = quizServices.getSubjectQuestions("Java");
			List<QuestionModel> questionsList = subjectQuestions.getQuestionsList();
			assertTrue(questionsList.size()!=0);
		} catch (QuestionParsingException e) {
			assertTrue(false);
		}
	}
	
	@DisplayName("Get Questions list : Negative")
	@Test
	void test2() {
		try {
			SubjectDataModel subjectQuestions = quizServices.getSubjectQuestions("English");
			List<QuestionModel> questionsList = subjectQuestions.getQuestionsList();
			assertTrue(!(questionsList.size()!=0));
		} catch (QuestionParsingException e) {
		}
		assertTrue(true);
	}
	
	@DisplayName("Check Question having 4 options")
	@Test
	void test3() {
		boolean expectedFlag=true;
		try {
			SubjectDataModel subjectQuestions = quizServices.getSubjectQuestions("English");
			List<QuestionModel> questionsList = subjectQuestions.getQuestionsList();
			for (QuestionModel questionModel : questionsList) {
				Map<String, Boolean> optionsMap = questionModel.getOptionsMap();
				if(optionsMap.size()<4) {
					expectedFlag=false;
					break;
				}
			}
		} catch (QuestionParsingException e) {
		}
		assertTrue(expectedFlag);
	}

}
