package com.yash.dao;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.yash.entity.Option;
import com.yash.entity.Question;
import com.yash.entity.Subject;

public class DataHandler extends DefaultHandler 
{
	
	private boolean bSubject=false;
	private boolean bQuestion=false;
	private boolean bQuestionDescription=false;
	private boolean bOption=false;
	
	private String subjectName;
	private List<String> questionsList;
	private List<Question> questionsForSubject;
	private Option option ;
	private Question question;
	
	private String name="";
	private String code="";
	private String ques="";
	private boolean correctOption=false;
	
	public DataHandler(String subjectName) {
		this.subjectName=subjectName;
		questionsForSubject = new ArrayList<>();
	}
	
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equalsIgnoreCase("subject")) 
		{
			name = attributes.getValue(uri, "name");
			code = attributes.getValue(uri, "code");
			if(name.equalsIgnoreCase(subjectName)) {	
				bSubject=true;				
			}
		}
		else if(qName.equalsIgnoreCase("question") && name.equalsIgnoreCase(subjectName)) {
			bQuestion=true;
		}
		else if(qName.equalsIgnoreCase("questionDescription") && name.equalsIgnoreCase(subjectName)) {
			questionsList = new ArrayList<String>();
			option = new Option();
			
			bQuestionDescription=true;
		}
		else if(qName.equalsIgnoreCase("option") && name.equalsIgnoreCase(subjectName)) {
			String optionValue=attributes.getValue(uri, "choice");
			if(optionValue.equalsIgnoreCase("true")) {
				correctOption=true;
			}
			else {
				correctOption=false;
			}
			bOption=true;
		}
		
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(bSubject && name.equalsIgnoreCase(subjectName)) {
			bSubject=false;
		}
		else if(bQuestion && name.equalsIgnoreCase(subjectName)) {
			bQuestion=false;
		}
		else if(bQuestionDescription && name.equalsIgnoreCase(subjectName)) {
			ques=new String(ch,start,length);
			questionsList.add(ques);
			bQuestionDescription=false;
		}
		else if(bOption && name.equalsIgnoreCase(subjectName)) 
		{
			String optionValue = new String(ch,start,length);
			option.setOptions(optionValue, correctOption);
			bOption=false;
		}
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equalsIgnoreCase("questionDescription") && name.equalsIgnoreCase(subjectName))
		{			
			question = new Question();
			question.setQuestions(questionsList);
			question.setOption(option);
			questionsForSubject.add(question);
		}
	}
	
	public Subject getSubjectQuestions() {
		Subject obj = new Subject(Integer.parseInt(code), subjectName, questionsForSubject);
		return obj;
	}
}
