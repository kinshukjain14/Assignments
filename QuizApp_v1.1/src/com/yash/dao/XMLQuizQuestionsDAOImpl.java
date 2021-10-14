package com.yash.dao;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import com.yash.entity.Subject;

public class XMLQuizQuestionsDAOImpl implements QuizQuestionsDAO{

	@Override
	public Subject retriveSubjects(String subjectName) throws ParserConfigurationException, SAXException, IOException 
	{
		DataHandler dataHandler = new DataHandler(subjectName);
		File file = new File("src\\com\\yash\\resources\\testpaper.xml");
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		
		InputSource source = new InputSource(file.getPath());
		source.setEncoding(StandardCharsets.UTF_8.displayName());
		
		saxParser.parse(source, dataHandler);
		Subject subject = dataHandler.getSubjectQuestions(); 
		return subject;
	}

}
