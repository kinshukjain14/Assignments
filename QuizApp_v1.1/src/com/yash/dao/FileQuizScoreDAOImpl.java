package com.yash.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import com.yash.entity.QuizScores;

public class FileQuizScoreDAOImpl implements QuizScoresDAO {

	@Override
	public boolean saveQuizScores(QuizScores score) {
		try(
			OutputStream os = new FileOutputStream("src\\com\\yash\\resources\\QuizScores.dat");
			ObjectOutputStream oos = new ObjectOutputStream(os);
				){
			oos.writeObject(score);
			return true;
		}
		catch(IOException ex) {
			return false;
		}
	}

	@Override
	public String fetchQuizScores() {
		try(
				InputStream is = new FileInputStream("src\\com\\yash\\resources\\QuizScores.dat");
				ObjectInputStream ois = new ObjectInputStream(is);
					){
				QuizScores q = (QuizScores)ois.readObject();
				return q.toString();
			}
			catch(IOException | ClassNotFoundException ex) {
				return null;
			}
	}
	
}
