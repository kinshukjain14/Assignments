package com.yash.repository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.yash.entity.Option;
import com.yash.entity.Question;
import com.yash.entity.Subject;

public class QuestionsRepository {

	private List<String> questionsList;
	private Option op;
	private List<Question> q;
	private static List<Subject> subjectsList = new LinkedList<Subject>();
	
	public List<Subject> getSubjectsList(){
		loadJavaQuestions();
		loadSQLQuestions();
		loadHTMLQuestions();
		loadCSSQuestions();
		return subjectsList;
	}
	
	public void setUp() {
		questionsList = new LinkedList<>();
		q=new ArrayList<Question>();
		op = new Option();
	}
	
	public void load() {
		Question ques = new Question();
		ques.setQuestions(questionsList);
		ques.setOption(op);		
		q.add(ques);
	}
	
	public void loadSQLQuestions() 
	{
		setUp();
		questionsList.add("What is the full form of SQL?");
		op.setOptions("Structured Query List", false);
		op.setOptions("Structure Query Language", true);
		op.setOptions("Sample Query Language", false);
		op.setOptions("None of these.", false);
		load();
		
		op=new Option();
		questionsList.add("Which of the following is not a valid SQL type?");
		op.setOptions("FLOAT", false);
		op.setOptions("NUMERIC", false);
		op.setOptions("DECIMAL", true);
		op.setOptions("CHARACTER", false);
		load();
		
		op = new Option();
		questionsList.add("Which of the following is not a DDL command?");
		op.setOptions("TRUNCATE", false);
		op.setOptions("ALTER", false);
		op.setOptions("CREATE", false);
		op.setOptions("UPDATE", true);
		load();

		op = new Option();
		questionsList.add("Which of the following are TCL commands?");
		op.setOptions("COMMIT and ROLLBACK", true);
		op.setOptions("UPDATE and TRUNCATE", false);
		op.setOptions("SELECT and INSERT", false);
		op.setOptions("GRANT and REVOKE", false);
		load();

		op = new Option();
		questionsList.add("Which statement is used to delete all rows in a table without having the action logged?");
		op.setOptions("DELETE", false);
		op.setOptions("REMOVE", false);
		op.setOptions("DROP", false);
		op.setOptions("TRUNCATE", true);
		load();
		
		op = new Option();
		questionsList.add("SQL Views are also known as");
		op.setOptions("Simple tables", false);
		op.setOptions("Virtual tables", true);
		op.setOptions("Complex tables", false);
		op.setOptions("Actual tables", false);
		load();
		
		op = new Option();
		questionsList.add("How many Primary keys can have in a table?");
		op.setOptions("Only 1", true);
		op.setOptions("Only 2", false);
		op.setOptions("Depends on no of Columns", false);
		op.setOptions("Depends on DBA", false);
		load();

		op = new Option();
		questionsList.add("What operator tests column for absence of data");
		op.setOptions("NOT Operator", false);
		op.setOptions("Exists Operator", false);
		op.setOptions("IS NULL Operator", true);
		op.setOptions("None of these", false);
		load();
		
		op = new Option();
		questionsList.add("In which of the following cases a DML statement is not executed?");
		op.setOptions("When existing rows are modified.", false);
		op.setOptions("When a table is deleted.", true);
		op.setOptions("When some rows are deleted.", false);
		op.setOptions("All of the above", false);
		load();

		op = new Option();
		questionsList.add("What is returned by INSTR ('JAVAT POINT', 'P')?");
		op.setOptions("6", false);
		op.setOptions("7", true);
		op.setOptions("POINT", false);
		op.setOptions("JAVAT", false);
		load();
		
		Subject s = new Subject(102, "SQL", q);
		subjectsList.add(s);
	}

	public void loadJavaQuestions() 
	{
		setUp();
		questionsList.add("Which of the following option leads to the portability and security of Java?");
		op.setOptions("Bytecode is executed by JVM", true);
		op.setOptions("The applet makes the Java code secure and portable", false);
		op.setOptions("Use of exception handling", false);
		op.setOptions("Dynamic binding between objects", false);
		load();
		
		op = new Option();
		questionsList.add("Which of the following is not a Java features?");
		op.setOptions("Dynamic", false);
		op.setOptions("Architecture Neutral", false);
		op.setOptions("Use of pointers", true);
		op.setOptions("Object-oriented", false);
		load();

		
		op = new Option();
		questionsList.add("_____ is used to find and fix bugs in the Java programs.");
		op.setOptions("JVM", false);
		op.setOptions("JRE", false);
		op.setOptions("JDK", false);
		op.setOptions("JDB", true);
		load();
		
		op = new Option();
		questionsList.add("Which of the following is a valid declaration of a char?");
		op.setOptions("char ch = '\\utea';", true);
		op.setOptions("char ca = 'tea';", false);
		op.setOptions("char cr = \\u0223;", false);
		op.setOptions("char cc = '\\itea';", false);
		load();

		op = new Option();
		questionsList.add("What is the return type of the hashCode() method in the Object class?");
		op.setOptions("Object", false);
		op.setOptions("int", true);
		op.setOptions("long", false);
		op.setOptions("void", false);
		load();

		op = new Option();
		questionsList.add("Which of the following is a valid long literal?");
		op.setOptions("ABH8097", false);
		op.setOptions("L990023", false);
		op.setOptions("904423", false);
		op.setOptions("0xnf029L", true);
		load();

		op = new Option();
		questionsList.add("What does the expression float a = 35 / 0 return?");
		op.setOptions("0", false);
		op.setOptions("Not a Number", false);
		op.setOptions("Infinity", true);
		op.setOptions("Run time exception", false);
		load();
		
		op = new Option();
		questionsList.add(
				"Which of the following tool is used to generate API documentation in HTML format from doc comments in source code?");
		op.setOptions("javap tool", false);
		op.setOptions("javaw command", false);
		op.setOptions("Javadoc tool", true);
		op.setOptions("javah command", false);
		load();

		op = new Option();
		questionsList.add("Which of the following creates a List of 3 visible items and multiple selections abled?");
		op.setOptions("new List(false, 3)", false);
		op.setOptions("new List(3, true)", true);
		op.setOptions("new List(true, 3)", false);
		op.setOptions("new List(3, false)", false);
		load();

		op = new Option();
		questionsList.add("Which of the following for loop declaration is not valid?");
		op.setOptions("for ( int i = 99; i >= 0; i / 9 )", true);
		op.setOptions("for ( int i = 7; i <= 77; i += 7 )", false);
		op.setOptions("for ( int i = 20; i >= 2; - -i )", false);
		op.setOptions("for ( int i = 2; i <= 20; i = 2* i )", false);
		load();
		
		Subject s = new Subject(101, "Java", q);
		subjectsList.add(s);

	}
	
	public void loadHTMLQuestions() 
	{
		setUp();
		questionsList.add("The correct sequence of HTML tags for starting a webpage is -");
		op.setOptions("Head, Title, HTML, body", false);
		op.setOptions("HTML, Body, Title, Head", false);
		op.setOptions("HTML, Title, Head, Body", false);
		op.setOptions("HTML, Head, Title, Body", true);
		load();
		
		op = new Option();
		questionsList.add("Which of the following element is responsible for making the text bold in HTML?");
		op.setOptions("<pre>", false);
		op.setOptions("<a>", false);
		op.setOptions("<b>", true);
		op.setOptions("<br>", false);
		load();
		
		op = new Option();
		questionsList.add("Which of the following tag is used to insert a line-break in HTML?");
		op.setOptions("<br>", true);
		op.setOptions("<a>", false);
		op.setOptions("<pre>", false);
		op.setOptions("<b>", false);
		load();

		op = new Option();
		questionsList.add("How to create an unordered list (a list with the list items in bullets) in HTML?");
		op.setOptions("<ul>", false);
		op.setOptions("<ol>", true);
		op.setOptions("<li>", false);
		op.setOptions("<i>", false);
		load();

		op = new Option();
		questionsList.add("Which character is used to represent the closing of a tag in HTML?");
		op.setOptions("\\", false);
		op.setOptions("!", false);
		op.setOptions("/", true);
		op.setOptions(".", false);
		load();
		
		op = new Option();
		questionsList.add("How to add a background color in HTML?");
		op.setOptions("<marquee bg color: \"red\">", false);
		op.setOptions("<marquee bg-color = \"red\">", false);
		op.setOptions("<marquee bgcolor = \"red\">", true);
		op.setOptions("<marquee color = \"red\">", false);
		load();
		
		op = new Option();
		questionsList.add("<input> is -");
		op.setOptions("a format tag.", false);
		op.setOptions("an empty tag.", true);
		op.setOptions("All of the above", false);
		op.setOptions("None of these", false);
		load();

		op = new Option();
		questionsList.add("Which of the following tag is used to make the underlined text?");
		op.setOptions("<i>", false);
		op.setOptions("<u>", true);
		op.setOptions("<br>", false);
		op.setOptions("<pre>", false);
		load();
		
		op = new Option();
		questionsList.add("Which of the following attribute is used to provide a unique name to an element?");
		op.setOptions("class", false);
		op.setOptions("id", true);
		op.setOptions("type", false);
		op.setOptions("None of these", false);
		load();

		op = new Option();
		questionsList.add("What are the types of unordered or bulleted list in HTML?");
		op.setOptions("disc, square, triangle", false);
		op.setOptions("polygon, triangle, circle", false);
		op.setOptions("disc, circle, square", true);
		op.setOptions("All of the above", false);
		load();
		
		Subject s = new Subject(103, "HTML", q);
		subjectsList.add(s);
	}

	public void loadCSSQuestions() 
	{
		setUp();
		questionsList.add("CSS stands for -");
		op.setOptions("Cascade style sheets", false);
		op.setOptions("Color and style sheets", false);
		op.setOptions("Cascading style sheets", true);
		op.setOptions("None of the above", false);
		load();
		
		op = new Option();
		questionsList.add("The property in CSS used to change the background color of an element is -");
		op.setOptions("bgcolor", false);
		op.setOptions("color", false);
		op.setOptions("background-color", true);
		op.setOptions("All of the above", false);
		load();
		
		op = new Option();
		questionsList.add("The property in CSS used to change the text color of an element is -");
		op.setOptions("bgcolor", false);
		op.setOptions("color", true);
		op.setOptions("background-color", false);
		op.setOptions("All of the above", false);
		load();

		op = new Option();
		questionsList.add("The CSS property used to control the element's font-size is -");
		op.setOptions("text-style", false);
		op.setOptions("text-size", false);
		op.setOptions("font-size", true);
		op.setOptions("None of the above", false);
		load();

		op = new Option();
		questionsList.add("The HTML attribute used to define the inline styles is -");
		op.setOptions("style", true);
		op.setOptions("styles", false);
		op.setOptions("class", false);
		op.setOptions("None of the above", false);
		load();
		
		op = new Option();
		questionsList.add("Which of the following CSS property is used to set the background image of an element?");
		op.setOptions("background-attachment", false);
		op.setOptions("background-image", true);
		op.setOptions("background-color", false);
		op.setOptions("None of the above", false);
		load();
		
		op = new Option();
		questionsList.add("Which of the following is the correct syntax to make the background-color of all paragraph elements to yellow?");
		op.setOptions("p {background-color : yellow;}", true);
		op.setOptions("p {background-color : #yellow;}", false);
		op.setOptions("all {background-color : yellow;}", false);
		op.setOptions("all p {background-color : #yellow;}", false);
		load();

		op = new Option();
		questionsList.add("Which of the following property is used as the shorthand property for the padding properties?");
		op.setOptions("padding-left", false);
		op.setOptions("padding-right", false);
		op.setOptions("padding", false);
		op.setOptions("All of the above", true);
		load();
		
		op = new Option();
		questionsList.add("The CSS property used to specify the transparency of an element is -");
		op.setOptions("opacity", true);
		op.setOptions("filter", false);
		op.setOptions("visibility", false);
		op.setOptions("overlay", false);
		load();

		op = new Option();
		questionsList.add("Are the negative values allowed in padding property?");
		op.setOptions("Yes", false);
		op.setOptions("No", true);
		op.setOptions("Can't say", false);
		op.setOptions("May be", false);
		load();
		
		Subject s = new Subject(104, "CSS", q);
		subjectsList.add(s);
	}

}
