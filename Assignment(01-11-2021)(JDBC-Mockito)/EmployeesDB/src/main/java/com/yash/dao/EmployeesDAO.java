package com.yash.dao;

import java.util.List;

import com.yash.entities.Employees;
import com.yash.exception.DAOException;

public interface EmployeesDAO {

	public List<Employees> getAllEmployees() throws DAOException;
	public Employees getEmployeeByEmpId(int employeeId) throws DAOException;
	public boolean storeEmployeeDetails(Employees employees) throws DAOException;
	public boolean updateEmployeeSalary(int employeeId,double newSalary)throws DAOException;
	public boolean deleteEmployee(Employees employees) throws DAOException;
	public Employees getDepartmentName(int employeeId)throws DAOException;
	
}
