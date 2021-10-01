package com.yash.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.codehaus.jackson.map.ObjectMapper;

import com.yash.entity.Category;

public class DeserializeJson 
{
	public Category deserilizeFromJSON() throws FileNotFoundException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		try(InputStream is = new FileInputStream("D:\\STS\\CatergoriesJson\\src\\com\\yash\\resources\\Categories.json"))
		{
			Category readValue = mapper.readValue(is,Category.class);
			return readValue;
		}
	}
}
