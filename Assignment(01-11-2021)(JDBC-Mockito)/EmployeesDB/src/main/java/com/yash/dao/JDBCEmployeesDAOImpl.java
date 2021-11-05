package com.yash.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.yash.entities.Employees;
import com.yash.exception.DAOException;
import com.yash.helper.ConnectionManager;
public class JDBCEmployeesDAOImpl implements EmployeesDAO {
	private ConnectionManager manager=new ConnectionManager();
	public List<Employees> getAllEmployees() throws DAOException {
		List<Employees> employeesList=new ArrayList<Employees>();

		try {
			Connection connection=manager.openConnection();
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from employees");
			
			while(resultSet.next()) {
				Employees employee=new Employees();
				employee.setEmployeeId(resultSet.getInt("employee_id"));
				employee.setFirstName(resultSet.getString("first_name"));
				employee.setLastName(resultSet.getString("last_name"));
				employee.setEmail(resultSet.getString("email"));
				employee.setPhoneNumber(resultSet.getString("phone_number"));
				if(resultSet.getDate("hire_date")!=null) {
				    employee.setHireDate(resultSet.getDate("hire_date").toLocalDate());
				}
				employee.setJobId(resultSet.getString("job_id"));
				employee.setSalary(resultSet.getDouble("salary"));
				employee.setCommissionPCT(resultSet.getDouble("commission_pct"));
				employee.setManagerId(resultSet.getInt("manager_id"));
				employee.setDepartmentId(resultSet.getInt("department_id"));
				employeesList.add(employee);
			}
			manager.closeConnection();
		} catch (ClassNotFoundException | SQLException e) {
			throw new DAOException(e,"DAO Exception");
		} 
		
		return employeesList;
	}

	public Employees getEmployeeByEmpId(int employeeId) throws DAOException {
		Employees employee=new Employees();
	 try {
		Connection connection=manager.openConnection();
		PreparedStatement statement=connection.prepareStatement("select * from employees where employee_id=?");
		statement.setInt(1, employeeId);
		ResultSet resultSet=statement.executeQuery();
		while(resultSet.next()) {
			employee.setEmployeeId(resultSet.getInt("employee_id"));
			employee.setFirstName(resultSet.getString("first_name"));
			employee.setLastName(resultSet.getString("last_name"));
			employee.setEmail(resultSet.getString("email"));
			employee.setPhoneNumber(resultSet.getString("phone_number"));
			if(resultSet.getDate("hire_date")!=null) {
			    employee.setHireDate(resultSet.getDate("hire_date").toLocalDate());
			}
	
			employee.setJobId(resultSet.getString("job_id"));
			employee.setSalary(resultSet.getDouble("salary"));
			employee.setCommissionPCT(resultSet.getDouble("commission_pct"));
			employee.setManagerId(resultSet.getInt("manager_id"));
			employee.setDepartmentId(resultSet.getInt("department_id"));
		}
		manager.closeConnection();
	}catch(ClassNotFoundException | SQLException e) {
     throw new DAOException(e,"DAO Exception");
	}
	 return employee;
	}

	public boolean storeEmployeeDetails(Employees employee) throws DAOException {
       int rows=0;
		try {
			Connection connection=manager.openConnection();
			PreparedStatement statement=
					connection.prepareStatement("insert into employees values(?,?,?,?,?,?,?,?,?,?,?)");
			statement.setInt(1, employee.getEmployeeId());
			statement.setString(2, employee.getFirstName());
			statement.setString(3, employee.getLastName());
			statement.setString(4, employee.getEmail());
			statement.setString(5,employee.getPhoneNumber());
			LocalDate localDate=employee.getHireDate();
			statement.setDate(6, java.sql.Date.valueOf(localDate));
			statement.setString(7,employee.getJobId());
			statement.setDouble(8, employee.getSalary());
			statement.setDouble(9, employee.getCommissionPCT());
			statement.setInt(10, employee.getManagerId());
			statement.setInt(11, employee.getDepartmentId());
			rows=statement.executeUpdate();
			manager.closeConnection();
		} catch (ClassNotFoundException | SQLException e) {
           throw new DAOException(e,"DAO Exception");
		
		}
		if(rows>0)
			return true;
		else
		    return false;
	}

	public boolean updateEmployeeSalary(int employeeId, double newSalary) throws DAOException {
		int rows=0;
		try {
			Connection connection = manager.openConnection();
			PreparedStatement statement=
					connection.prepareStatement("update employees set salary=? where employee_id=?");
			statement.setDouble(1, newSalary);
			statement.setInt(2, employeeId);
			rows=statement.executeUpdate();
			
			manager.closeConnection();
		} catch (ClassNotFoundException | SQLException e) {
			throw new DAOException(e,"DAO Exception");
		}
		if(rows>0)
			return true;
		else
			return false;
	}

	public boolean deleteEmployee(Employees employees) throws DAOException {
		int rows=0;
		try {
			Connection connection = manager.openConnection();
			PreparedStatement statement=
					connection.prepareStatement("delete from employees where employee_id=?");
			statement.setInt(1, employees.getEmployeeId());
			rows=statement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			throw new DAOException(e,"DAO Exception");
		}
		if(rows>0)
			return true;
		else
			return false;
	}

	public Employees getDepartmentName(int employeeId) throws DAOException {
		Employees employee=new Employees();
		 try {
			Connection connection=manager.openConnection();
			PreparedStatement statement=connection.prepareStatement("select * from employees where employee_id=?");
			statement.setInt(1, employeeId);
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next()) {
				employee.setEmployeeId(resultSet.getInt("employee_id"));
				employee.setFirstName(resultSet.getString("first_name"));
				employee.setLastName(resultSet.getString("last_name"));
				employee.setEmail(resultSet.getString("email"));
				employee.setPhoneNumber(resultSet.getString("phone_number"));
				if(resultSet.getDate("hire_date")!=null) {
				    employee.setHireDate(resultSet.getDate("hire_date").toLocalDate());
				}
				employee.setJobId(resultSet.getString("job_id"));
				employee.setSalary(resultSet.getDouble("salary"));
				employee.setCommissionPCT(resultSet.getDouble("commission_pct"));
				employee.setManagerId(resultSet.getInt("manager_id"));
				employee.setDepartmentId(resultSet.getInt("department_id"));
			}
			manager.closeConnection();
		}catch(ClassNotFoundException | SQLException e) {
	     throw new DAOException(e,"DAO Exception");
		}
		 return employee;
		}
}
