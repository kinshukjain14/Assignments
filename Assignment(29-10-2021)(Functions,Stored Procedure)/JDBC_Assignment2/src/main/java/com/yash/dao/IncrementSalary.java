package com.yash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.yash.helper.ConnectionManager;

public class IncrementSalary {
	public static void main(String[] args) {
		try(
				Connection con = new ConnectionManager().openConnection();
				){
			PreparedStatement statement = con.prepareStatement("update employees set salary = salary + 200 where job_id=?");
			statement.setString(1, "SA_REP");
			int i = statement.executeUpdate();
			
			if(i>0)
				System.out.println("Salary updated successfully");
			else
				System.err.println("Error in application");
		} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
	}
}
