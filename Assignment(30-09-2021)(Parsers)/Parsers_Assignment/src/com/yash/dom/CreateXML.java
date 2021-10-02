package com.yash.dom;

import java.io.File;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.yash.entity.Option;
import com.yash.entity.Question;
import com.yash.entity.Subject;

public class CreateXML {
	public static void main(String[] args) throws ParserConfigurationException, TransformerException 
	{
		File file = new File("src\\testpaper.xml");
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
		Document document = documentBuilder.newDocument();
		
		Element rootElement = document.createElement("testpaper");
		document.appendChild(rootElement);
		
		QuestionsRepository repo = new QuestionsRepository();
		List<Subject> subjectsList = repo.getSubjectsList();
		
		Integer i=1;
		for (Subject s : subjectsList) 
		{
			Element subject1 = document.createElement("subject");
			subject1.setAttribute("name",s.getSubjectName());
			rootElement.appendChild(subject1);
			List<Question> questions = s.getQuestions();
			System.out.println("\nModule : "+s.getSubjectName());
			for (Question question : questions) 
			{
				List<String> qList = question.getQuestions();
			
				Option op = question.getOption();
				Map<String, Boolean> optionsMap = op.getOptions();
					Element createElement = document.createElement("question");
					createElement.setAttribute("id",i.toString());
					subject1.appendChild(createElement);
					Element ques = document.createElement("questionDescription");
					ques.setTextContent(qList.get(i-1));
					createElement.appendChild(ques);
					
					optionsMap.entrySet().stream().forEach(x->{
						Element options = document.createElement("option");
						if(x.getValue() == true) {
							options.setAttribute("choice","true");																		
						}
						else {
							options.setAttribute("choice", "false");
						}
						options.setTextContent(x.getKey());
						createElement.appendChild(options);
						
					});
					System.out.println("Question "+i+" loaded");
				i++;
			}
			i=1;
		}
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource domSource = new DOMSource(document);
		StreamResult streamResult = new StreamResult(file);
		transformer.transform(domSource, streamResult);
	}
}
