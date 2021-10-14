package com.yash.controller;

import com.yash.helper.QuizFactory;
import com.yash.model.QuizScoreModel;
import com.yash.service.QuizScoreServices;

public class QuizScoresController {
	
	private static QuizScoreServices service;
	
	public static boolean handleQuizScoreStorage(QuizScoreModel model)
	{
		service = QuizFactory.newQuizScoreServices();
		return service.addQuizScore(model);
	}
	
	public static String handleQuizScoreRetrival() {
		service = QuizFactory.newQuizScoreServices();
		return service.getQuizScore();
	}
}
