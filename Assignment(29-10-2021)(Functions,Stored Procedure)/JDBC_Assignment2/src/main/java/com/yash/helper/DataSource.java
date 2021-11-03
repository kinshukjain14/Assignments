package com.yash.helper;

import java.util.ResourceBundle;

public class DataSource {

	private String driver;
	private String url;
	private String userName;
	private String password;
	
	public DataSource(String baseName) {
		ResourceBundle resourceBundle=ResourceBundle.getBundle(baseName);
		this.driver=resourceBundle.getString("driver");
		this.url=resourceBundle.getString("url");
		this.userName=resourceBundle.getString("username");
		this.password=resourceBundle.getString("password");
	}

	public String getDriver() {
		return driver;
	}

	public String getUrl() {
		return url;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
	
	
}
