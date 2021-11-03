package com.yash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.yash.helper.ConnectionManager;

public class DeleteEmployeeWithoutDeptId {
	public static void main(String[] args) {
		try(
				Connection con = new ConnectionManager().openConnection();
				){

			PreparedStatement statement = con.prepareStatement("delete from employees where department_id is null");
			int execute = statement.executeUpdate();
			if(execute > 0) {
				System.out.println("Records delected successfully");
			}
			else {
				System.err.println("Error in application");
			}
		} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
	}
}
