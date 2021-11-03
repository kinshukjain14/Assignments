package com.yash.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	private DataSource dataSource;
	private Connection connection=null;
	
	public ConnectionManager() {
		this.dataSource=new DataSource("db");
	}
	
	public Connection openConnection() throws ClassNotFoundException, SQLException {
		Class.forName(dataSource.getDriver());
		connection=DriverManager.getConnection(dataSource.getUrl(),dataSource.getUserName(),dataSource.getPassword());
		return connection;
	}

	public void closeConnection() throws SQLException {
		connection.close();
	}
}
