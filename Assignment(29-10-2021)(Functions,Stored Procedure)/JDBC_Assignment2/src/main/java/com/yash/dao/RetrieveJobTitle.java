package com.yash.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import com.yash.helper.ConnectionManager;

public class RetrieveJobTitle {
	public static void main(String[] args) {
		try(
				Connection con = new ConnectionManager().openConnection();
				Scanner sc = new Scanner(System.in);
				){
			System.out.print("Enter Employee id : ");
			int id = sc.nextInt();
			CallableStatement statement = con.prepareCall("{call hr.RetrieveJobTitle(?,?)}");
			statement.setInt(1, id);
			statement.registerOutParameter(2, Types.VARCHAR);
			statement.execute();
			String jobTitle = statement.getString(2);
			System.out.println("Job title : "+jobTitle);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
