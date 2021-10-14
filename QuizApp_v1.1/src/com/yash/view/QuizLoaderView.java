package com.yash.view;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import java.util.Map.Entry;

import com.yash.controller.QuizQuestionController;
import com.yash.controller.QuizScoresController;
import com.yash.exception.QuestionParsingException;
import com.yash.model.QuestionModel;
import com.yash.model.QuizScoreModel;
import com.yash.model.SubjectDataModel;

public class QuizLoaderView 
{
	public static void loadQuiz(Scanner sc , String subject, QuizScoreModel quizModel,boolean quizScoreToStore) throws InterruptedException, QuestionParsingException  
	{
		List<Integer> score = new ArrayList<>();
		List<QuestionModel> questionsList=null;
		SubjectDataModel subjectQuestion;
		subjectQuestion = new QuizQuestionController().handleSubjectquestion(subject);
		questionsList = subjectQuestion.getQuestionsList();
		int i=1;
		LocalTime start = LocalTime.now();
		for (QuestionModel questionModel : questionsList) 
		{
			LocalTime time = LocalTime.now();
			String question = questionModel.getQuestion();
			System.out.println(i+". "+question+"\tTime : "+time.getHour()+":"+time.getMinute()+":"+time.getSecond());
			Map<String, Boolean> optionsMap = questionModel.getOptionsMap();
			Set<Entry<String,Boolean>> entrySet = optionsMap.entrySet();
			Iterator<Entry<String, Boolean>> iterator = entrySet.iterator();
			int no=1;
			List<Boolean> checkList=new ArrayList<Boolean>();
			while(iterator.hasNext()) 
			{
				Entry<String, Boolean> next = iterator.next();
				System.out.println("\t"+no+". "+next.getKey());
				checkList.add(next.getValue());
				no++;
			}
			System.out.println();
			int ch=0;
				while(true) {
						System.out.print("Enter your answer : ");
						if(sc.hasNextInt()) {
							ch = sc.nextInt();							
						}
						else {
							System.out.println("*** Invalid Input : only numeric value required ***");
							Thread.sleep(100);
							sc.next();
							continue;
						}
						if(ch>=1 && ch<=checkList.size()) {
							if(checkList.get(ch-1)) {
								score.add(1);
							}
							else {
								score.add(0);
							}
							break;
						}else {
							System.err.println("*** Invalid choice : Option entered is not available ***");
							Thread.sleep(100);
							continue;
						}
					}
				
			i++;
			if(i==questionsList.size()+1) 
			{
				System.out.println("\n******* Your responses are submitted ********\n");
				break;
			}

			System.out.println();
			Duration between = Duration.between(start, time);
			int minutes = (int)between.getSeconds()/60;
			if(minutes >= 10) 
			{
				System.err.println("\n************** Time Up *********************\n");
				Thread.sleep(500);
				System.out.println("\n******* Your responses are submitted ********\n");
				break;
			}
		}
		
		int totalMarks=0;
		int countCorrect = 0;
		int countWrong=0;
		for (int j = 0; j < score.size(); j++) {
			Integer answer = score.get(j);
			totalMarks+=answer;
			if(answer == 1) {
				countCorrect++;
			}
			else {
				countWrong++;
			}
		}
		
		double percentage = (double)((totalMarks*100)/questionsList.size());
		String status;
		System.out.println("********************* Result Summary *********************");
		System.out.println("Candidate Test Id : "+quizModel.getCandidateId());
		System.out.println("Candidate Name : "+quizModel.getCandidateName());
		System.out.println("Module : "+quizModel.getModuleName());
		System.out.println("Total Questions : "+questionsList.size());
		System.out.println("Attemted Questions : "+score.size());
		System.out.println("Correct answers : "+countCorrect);
		System.out.println("Wrong answers : "+countWrong);
		System.out.println("Percentage : "+ percentage+"%");
		System.out.println("*********************************************************");
		System.out.println();
		if(percentage >= 70.0) {
			status="PASS";
			System.out.println("Status : PASS");
		}
		else 
		{
			status="FAIL";
			System.out.println("Status : FAIL");
		}
		
		if(quizScoreToStore) {
			String quizScoreRetrival = QuizScoresController.handleQuizScoreRetrival();
			if(quizScoreRetrival != null) {
				System.out.println("\n***** Previous Attempt Data ******");
				System.out.println(quizScoreRetrival);
				System.out.println("************************************\n");
			}
			
			quizModel.setPercentage(percentage);
			quizModel.setStatus(status);
			
			boolean scoreStorage = QuizScoresController.handleQuizScoreStorage(quizModel);
			if(scoreStorage) 
			{
				System.out.println("****** Your Scores are saved successfully *******");
			}
			else {
				System.err.println("\n== Error in saving the scores ==\n");
				Thread.sleep(500);
			}
		}
		
	}
	
}
