package com.yash.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXML
{
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException
	{
		File file = new File("src\\testpaper.xml");
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(file);
		
		document.getDocumentElement().normalize();
		String rootNode = document.getDocumentElement().getNodeName();
		System.out.println("************** "+rootNode.toUpperCase()+" **************\n");
		
		NodeList subjectList = document.getElementsByTagName("subject");

		for(int i=0;i<subjectList.getLength();i++) 
		{
			Node node = subjectList.item(i);
			NodeList questionsList = node.getChildNodes();
			String subjectName = node.getAttributes().getNamedItem("name").getTextContent();
			System.out.println("********************************************************************************************");
			System.out.println(node.getNodeName().toUpperCase()+" : "+subjectName);
			
			for(int j=0;j<questionsList.getLength();j++) 
			{
				Node question = questionsList.item(j);
				if(question.getNodeType()==Node.ELEMENT_NODE) {
					Element e = (Element) question;
					System.out.println("Q"+(j+1)+". "+e.getElementsByTagName("questionDescription").item(0).getTextContent());
					NodeList optionsList = e.getElementsByTagName("option");
					for (int k = 0; k < optionsList.getLength(); k++) {
						Node n = optionsList.item(k);
						System.out.println("\t"+(k+1)+". "+n.getTextContent());
					}
					System.out.println();
				}
				
			}
			System.out.println("********************************************************************************************");
		}
		
	}
}
