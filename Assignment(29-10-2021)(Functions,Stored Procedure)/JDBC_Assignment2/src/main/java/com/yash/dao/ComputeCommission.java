package com.yash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.yash.helper.ConnectionManager;

public class ComputeCommission {
	public static void main(String[] args) {
		try(
				Connection con = new ConnectionManager().openConnection();
				Scanner sc = new Scanner(System.in);
				){
			System.out.print("Enter Employee id : ");
			int id = sc.nextInt();
			PreparedStatement statement = con.prepareStatement("select retrieveCommission(salary) AS 'Commission' from employees where employee_id=?");
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				System.out.println("Commission : "+resultSet.getDouble(1));
			}
			else {
				System.out.println("-- Employee not found --");
			}
		} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
	}
}
