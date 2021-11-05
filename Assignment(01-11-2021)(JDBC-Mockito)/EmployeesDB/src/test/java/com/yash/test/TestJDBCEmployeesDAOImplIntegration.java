package com.yash.test;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.yash.dao.JDBCEmployeesDAOImpl;
import com.yash.entities.Employees;
import com.yash.exception.DAOException;
import com.yash.helper.ConnectionManager;

class TestJDBCEmployeesDAOImplIntegration {

	@Spy
	private ConnectionManager manager;
	@InjectMocks
	private JDBCEmployeesDAOImpl jdbcEmployeesDAOImpl;
	private static int empIdSample;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetAllEmployeesWhenReturnedListSizeIsGreaterThanZero() {
		try {
			List<Employees> employeesList = jdbcEmployeesDAOImpl.getAllEmployees();
			assertTrue(employeesList.size() > 0);
		} catch (DAOException e) {
			assertFalse(true);
		}
	}
	
	@Test
	void testGetEmployeeById() {
		try {
			int employeeId=101;
			Employees employeeByEmpId = jdbcEmployeesDAOImpl.getEmployeeByEmpId(employeeId);
			assertEquals(employeeId, employeeByEmpId.getEmployeeId());
		} catch (DAOException e) {
			assertFalse(true);
		}
	}
	
	@Test
	void testStoreEmployeeDetails() {
		Employees employee = new Employees();
		empIdSample = (int)(Math.random()*10000);
		employee.setEmployeeId(empIdSample);
		employee.setFirstName("Kinshuk");
		employee.setLastName("Jain");
		employee.setEmail("kinshuk.jain14@gmail.com");
		employee.setPhoneNumber("011.44.1344.486508");
		employee.setHireDate(LocalDate.now());
		employee.setJobId("J1");
		employee.setSalary(2000);
		employee.setCommissionPCT(0.20);
		employee.setManagerId(101);
		employee.setDepartmentId(10);
		
		try {
			boolean actual = jdbcEmployeesDAOImpl.storeEmployeeDetails(employee);
			assertTrue(actual);
		} catch (DAOException e) {
			assertFalse(true);
		}
	}
	
	@Test
	void testUpdateEmployeeSalary() {
		boolean actual;
		try {
			actual = jdbcEmployeesDAOImpl.updateEmployeeSalary(101, 7000);
			assertEquals(true, actual);
		} catch (DAOException e) {
			assertFalse(true);
		}
	}
	
	@Test
	void testDeleteEmployeeRecord() {
		Employees employees = new Employees();
		employees.setEmployeeId(empIdSample);
		try {
			boolean actual = jdbcEmployeesDAOImpl.deleteEmployee(employees);
			assertTrue(actual);
		} catch (DAOException e) {
			assertFalse(true);
		}
	}
	
	@Test
	void testGetEmployeeDepartmentId() {
		try {
			int employeeId = 101;
			int deptId=90;
			
			Employees employees = jdbcEmployeesDAOImpl.getDepartmentName(employeeId);
			assertEquals(deptId, employees.getDepartmentId());
		} catch (DAOException e) {
			assertTrue(true);
		}
	}

}
