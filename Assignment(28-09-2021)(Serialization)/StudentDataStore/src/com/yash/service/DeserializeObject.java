package com.yash.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import com.yash.entity.Student;
import com.yash.model.StudentModel;

public class DeserializeObject
{
	private static double sum=0.0;
	
	@SuppressWarnings("unchecked")
	public List<StudentModel> deserializeStudentObject()
	{
		File file = new File("D:\\STS\\StudentDataStore\\src\\com\\yash\\resources");
		try(
				InputStream is = new FileInputStream(file.getAbsoluteFile()+"\\student.dat");
				ObjectInputStream ois = new ObjectInputStream(is);
				){
			if(file.isDirectory()) 
			{	
				List<StudentModel> model = new ArrayList<>();
				List<Student> lists = (List<Student>)ois.readObject();
				for (Student student : lists) {
					StudentModel s = new StudentModel();
					s.setRollNo(student.getRollNo());
					s.setName(student.getName());
					List<Double> scoreList = student.getScoreList();
					scoreList.forEach(x -> sum+=x );
					s.setScoreList(scoreList);
					s.setPercentage((sum/600)*100);
					model.add(s);
					sum=0.0;
				}
				
				return model;
			}
			else 
			{
				throw new IOException("Directory does not exist");
			}
		}
		catch(IOException | ClassNotFoundException e) {
			System.err.println(e.getMessage());
			return null;
		}
	
	}
}
