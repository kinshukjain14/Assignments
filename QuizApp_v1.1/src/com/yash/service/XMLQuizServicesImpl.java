package com.yash.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.yash.dao.QuizQuestionsDAO;
import com.yash.entity.Question;
import com.yash.entity.Subject;
import com.yash.exception.QuestionParsingException;
import com.yash.helper.QuizFactory;
import com.yash.model.QuestionModel;
import com.yash.model.SubjectDataModel;

public class XMLQuizServicesImpl implements QuizServices{

	@Override
	public SubjectDataModel getSubjectQuestions(String subjectName) throws QuestionParsingException{
		List<QuestionModel> qModels = new ArrayList<>();
		QuizQuestionsDAO quizQuestions = QuizFactory.newDAOInstance();
		Subject subject;
		try {
			subject = quizQuestions.retriveSubjects(subjectName);
			List<Question> questions = subject.getQuestions();
			questions.forEach(x->{
				List<String> questionsTemp = x.getQuestions();
				questionsTemp.forEach(y->{
					Map<String, Boolean> options = x.getOption().getOptions();
					qModels.add(new QuestionModel(y, options));
				});
			});
			
			SubjectDataModel model = new SubjectDataModel(qModels);
			return model;
		} catch (ParserConfigurationException | SAXException | IOException | NullPointerException e) {
			throw new QuestionParsingException("Error in processing the quiz questions");
		}
	}

	
}
