package com.yash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.yash.entities.Jobs;
import com.yash.helper.ConnectionManager;

public class InsertJobDetails {
	public static void main(String[] args) {
		try(
				Connection con = new ConnectionManager().openConnection();
				){
			Jobs jobs = new Jobs();
			jobs.setJobId("AT_PROG");
			jobs.setJobTitle("Assistant Programmer");
			jobs.setMaxSalary(8000);
			jobs.setMinSalary(5000);
			
			PreparedStatement statement = con.prepareStatement("insert into jobs values (?,?,?,?)");
			statement.setString(1, jobs.getJobId());
			statement.setString(2, jobs.getJobTitle());
			statement.setDouble(3, jobs.getMinSalary());
			statement.setDouble(4, jobs.getMaxSalary());
			int i = statement.executeUpdate();
			if(i>0) {
				System.out.println("Record Inserted sucessfully");
			}
			else {
				System.err.println("Error in application");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
