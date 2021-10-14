package com.yash.dao;

import com.yash.entity.QuizScores;

public interface QuizScoresDAO {
	public boolean saveQuizScores(QuizScores score);
	public String fetchQuizScores();
}
