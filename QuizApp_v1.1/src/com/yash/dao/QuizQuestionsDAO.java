package com.yash.dao;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.yash.entity.Subject;

public interface QuizQuestionsDAO 
{
	public Subject retriveSubjects(String subjectName) throws ParserConfigurationException, SAXException, IOException;
}
