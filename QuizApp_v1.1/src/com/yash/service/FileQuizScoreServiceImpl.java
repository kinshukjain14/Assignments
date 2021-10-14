package com.yash.service;

import com.yash.dao.QuizScoresDAO;
import com.yash.entity.QuizScores;
import com.yash.helper.QuizFactory;
import com.yash.model.QuizScoreModel;

public class FileQuizScoreServiceImpl implements QuizScoreServices {

	private QuizScoresDAO dao; 
	
	@Override
	public boolean addQuizScore(QuizScoreModel model) 
	{
		QuizScores quizScores = new QuizScores();
		quizScores.setCandidateId(model.getCandidateId());
		quizScores.setCandidateName(model.getCandidateName());
		quizScores.setModuleName(model.getModuleName());
		quizScores.setPercentage(model.getPercentage());
		quizScores.setStatus(model.getStatus());
		dao = QuizFactory.newQuizScoresDAO();
		return dao.saveQuizScores(quizScores);
	}

	@Override
	public String getQuizScore() {
		dao=QuizFactory.newQuizScoresDAO();
		return dao.fetchQuizScores();
	}

}
