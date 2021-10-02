package com.yash.sax;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReadEmployeeXML {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		InputStream is = ClassLoader.getSystemResourceAsStream("employee.xml");
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		saxParser.parse(is, new DataHandler());	
	}
}


class DataHandler extends DefaultHandler{
	
	boolean bEmpId=false;
	boolean bEmpName=false;
	boolean bEmpSalary=false;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equalsIgnoreCase("employee")) {
			System.out.println("\nEmployee Details");
		}
		if(qName.equalsIgnoreCase("empId")) {
			bEmpId=true;
		}
		else if(qName.equalsIgnoreCase("empName")) {
			bEmpName=true;
		}
		else if(qName.equalsIgnoreCase("empSalary")) {
			bEmpSalary=true;
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(bEmpId) {
			System.out.println("Id : "+new String(ch,start,length));
			bEmpId=false;
		}
		else if(bEmpName) {
			System.out.println("Name : "+new String(ch,start,length));
			bEmpName=false;
		}
		else if(bEmpSalary) {
			System.out.println("Salary : "+new String(ch,start,length));
			bEmpSalary=false;
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equalsIgnoreCase("employee")) {
			System.out.println("*****************************");
		}
	}
	
}