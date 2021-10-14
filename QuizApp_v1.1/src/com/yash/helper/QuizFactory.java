package com.yash.helper;

import com.yash.dao.FileQuizScoreDAOImpl;
import com.yash.dao.MemoryUserDAOImpl;
import com.yash.dao.QuizQuestionsDAO;
import com.yash.dao.QuizScoresDAO;
import com.yash.dao.UserDAO;
import com.yash.dao.XMLQuizQuestionsDAOImpl;
import com.yash.service.FileQuizScoreServiceImpl;
import com.yash.service.QuizScoreServices;
import com.yash.service.QuizServices;
import com.yash.service.UserService;
import com.yash.service.UserServiceImpl;
import com.yash.service.XMLQuizServicesImpl;

public class QuizFactory
{
	public static QuizQuestionsDAO newDAOInstance() {
		return new XMLQuizQuestionsDAOImpl();
	}
	
	public static QuizServices newServicesInstance() {
		return new XMLQuizServicesImpl();
	}
	
	public static QuizScoresDAO newQuizScoresDAO() {
		return new FileQuizScoreDAOImpl();
	}
	
	public static QuizScoreServices newQuizScoreServices() {
		return new FileQuizScoreServiceImpl();
	}
	
	public static UserDAO newUserDao() {
		return new MemoryUserDAOImpl();
	}
	public static UserService newUserAuthService() {
		return new UserServiceImpl();
	}
}
