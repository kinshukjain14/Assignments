package com.yash.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.codehaus.jackson.map.ObjectMapper;

import com.yash.entity.Category;

public class SerializeJson {
	
	public void SerializeToJSON(Category category) throws FileNotFoundException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		File file = new File("D:\\STS\\CatergoriesJson\\src\\com\\yash\\resources\\Categories.json");
		
		try(OutputStream os = new FileOutputStream(file,true))
		{
			mapper.writeValue(os, category);
		}
		
	}
}
