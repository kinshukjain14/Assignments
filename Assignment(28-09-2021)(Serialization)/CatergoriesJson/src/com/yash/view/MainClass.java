package com.yash.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.yash.entity.Category;
import com.yash.repository.ShoppingCartRepository;
import com.yash.service.DeserializeJson;
import com.yash.service.SerializeJson;

public class MainClass {
	public static void main(String[] args) throws FileNotFoundException, IOException 
	{
		List<Category> categories = ShoppingCartRepository.getCategory();
		SerializeJson ser = new SerializeJson();
		DeserializeJson dser = new DeserializeJson();
	
		File file = new File("D:\\STS\\CatergoriesJson\\src\\com\\yash\\resources\\Categories.json");
		PrintWriter pw = new PrintWriter(file);
		pw.write("");
		
		categories.forEach(x->{
			try {
				ser.SerializeToJSON(x);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		Category category = dser.deserilizeFromJSON();
		System.out.println(category);
	}
}
