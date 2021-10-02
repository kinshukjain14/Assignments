package com.yash.entity;

import java.util.LinkedHashMap;
import java.util.Map;

public class Option 
{
	private Map<String,Boolean> options;
	
	public Option() {
		this.options = new LinkedHashMap<>();
	}

	public Map<String, Boolean> getOptions() {
		return options;
	}

	public void setOptions(String question,Boolean answer) {
		options.put(question, answer);
	}
		
}
