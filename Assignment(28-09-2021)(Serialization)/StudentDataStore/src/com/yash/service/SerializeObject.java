package com.yash.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.List;

import com.yash.entity.Student;

public class SerializeObject {
	
	public boolean serializeStudentObject(List<Student> studentsList) {
		File file = new File("D:\\STS\\StudentDataStore\\src\\com\\yash\\resources");
		
		try(
				OutputStream os = new FileOutputStream(file.getAbsolutePath()+"\\student.dat");
				ObjectOutputStream oos = new ObjectOutputStream(os);
				){
			if(file.isDirectory()) 
			{
				oos.writeObject(studentsList);
				return true;
			}
			else {
				throw new IOException("Directory does not exist");
			}
		}
		catch(IOException e) {
			System.err.println(e.getMessage());
			return false;
		}
	
	}
}
