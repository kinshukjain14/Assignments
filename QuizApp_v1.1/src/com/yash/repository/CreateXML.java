package com.yash.repository;

import java.io.File;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.yash.entity.Option;
import com.yash.entity.Question;
import com.yash.entity.Subject;
import com.yash.exception.QuizRepositoryException;

public class CreateXML {
	public static void generateXML() throws QuizRepositoryException
	{
		try {
		File file = new File("src\\com\\yash\\resources\\testpaper.xml");
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
		Document document = documentBuilder.newDocument();
		
		Element rootElement = document.createElement("testpaper");
		document.appendChild(rootElement);
		
		QuestionsRepository repo = new QuestionsRepository();
		List<Subject> subjectsList = repo.getSubjectsList();
		
		Integer i=1;
		Integer code =101;
		for (Subject s : subjectsList) 
		{
			Element subject1 = document.createElement("subject");
			subject1.setAttribute("name",s.getSubjectName());
			subject1.setAttribute("code",code.toString());
			rootElement.appendChild(subject1);
			List<Question> questions = s.getQuestions();
			for (Question question : questions) 
			{
				List<String> qList = question.getQuestions();
			
				Option op = question.getOption();
				Map<String, Boolean> optionsMap = op.getOptions();
					Element createElement = document.createElement("question");
					createElement.setAttribute("id",i.toString());
					subject1.appendChild(createElement);
					Element ques = document.createElement("questionDescription");
					CDATASection cdataQues = document.createCDATASection(qList.get(i-1));
					ques.appendChild(cdataQues);

					createElement.appendChild(ques);
					
					optionsMap.entrySet().stream().forEach(x->{
						Element options = document.createElement("option");
						if(x.getValue() == true) {
							options.setAttribute("choice","true");																		
						}
						else {
							options.setAttribute("choice", "false");
						}
						CDATASection cdataOption = document.createCDATASection(x.getKey());
						options.appendChild(cdataOption);

						createElement.appendChild(options);
						
					});
				i++;
			}
			code++;
			i=1;
		}
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
		transformer.setOutputProperty(OutputKeys.INDENT,"yes");
		DOMSource domSource = new DOMSource(document);
		StreamResult streamResult = new StreamResult(file);
		transformer.transform(domSource, streamResult);
		}
		catch(ParserConfigurationException | TransformerException e) {
			throw new QuizRepositoryException("Error in generating quiz repository");
		}
		
	}
}
