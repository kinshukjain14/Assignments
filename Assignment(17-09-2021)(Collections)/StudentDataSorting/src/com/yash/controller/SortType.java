package com.yash.controller;

public enum SortType {
	ROLLNO("ROLLNO"),FIRSTNAME("FIRSTNAME"),LASTNAME("LASTNAME"),AGE("AGE"),PERCENTAGE("PERCENTAGE");
	private String val;
	private SortType(String val) {
		this.val=val;
	}
	public String getValue() {
		return val;
	}
}
