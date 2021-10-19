package com.yash.entity;

public class User {
	private int userId;
	private String userName;
	private String password;
	private String name;
	private String email;
	private Long contactNo;
	
	public User(int userId,String userName, String password,String name,String email,Long contactNo) {
		super();
		this.userId=userId;
		this.userName = userName;
		this.password = password;
		this.name=name;
		this.email=email;
		this.contactNo=contactNo;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public int getUserId() {
		return userId;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public Long getContactNo() {
		return contactNo;
	}
	
	
}
