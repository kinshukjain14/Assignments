package com.yash.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.yash.dao.JDBCEmployeesDAOImpl;
import com.yash.entities.Employees;
import com.yash.exception.DAOException;
import com.yash.helper.ConnectionManager;

class TestJDBCEmployeesDAOImpl {
	@Mock
	private ConnectionManager manager;

	@Mock
	private Connection connection;

	@Mock
	private Statement statement;

	@Mock
	private PreparedStatement preparedStatement;

	@Mock
	private ResultSet resultSet;

	@InjectMocks
	private JDBCEmployeesDAOImpl jdbcEmployeesDAOImpl;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testgetAllEmployeesWhenReturnedListSizeIsOne() {
		try {
			when(manager.openConnection()).thenReturn(connection);
			when(connection.createStatement()).thenReturn(statement);
			when(statement.executeQuery(anyString())).thenReturn(resultSet);
			when(resultSet.next()).thenReturn(true).thenReturn(false);
			List<Employees> employeesList = jdbcEmployeesDAOImpl.getAllEmployees();
			assertTrue(employeesList.size() == 1);
		} catch (ClassNotFoundException | SQLException | DAOException e) {
			assertFalse(true);
		}
	}

	@Test
	void testgetAllEmployeesWhenReturnedListSizeIsOneOrGreaterthanOne() {
		try {
			when(manager.openConnection()).thenReturn(connection);
			when(connection.createStatement()).thenReturn(statement);
			when(statement.executeQuery(anyString())).thenReturn(resultSet);
			when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
			List<Employees> employeesList = jdbcEmployeesDAOImpl.getAllEmployees();
			assertTrue(employeesList.size() >= 1);
		} catch (ClassNotFoundException | SQLException | DAOException e) {
			assertFalse(true);
		}
	}

	@Test
	void testgetAllEmployeesWhenReturnedListSizeIsEmpty() {
		try {
			when(manager.openConnection()).thenReturn(connection);
			when(connection.createStatement()).thenReturn(statement);
			when(statement.executeQuery(anyString())).thenReturn(resultSet);
			when(resultSet.next()).thenReturn(false);
			List<Employees> employeesList = jdbcEmployeesDAOImpl.getAllEmployees();
			assertTrue(employeesList.size() == 0);
		} catch (ClassNotFoundException | SQLException | DAOException e) {
			assertFalse(true);
		}
	}

	@Test
	void testgetAllEmployeesWhenExceptionOccurs() {
		try {
			when(manager.openConnection()).thenReturn(connection);
			when(connection.createStatement()).thenReturn(statement);
			when(statement.executeQuery(anyString())).thenThrow(SQLException.class);
			when(resultSet.next()).thenReturn(false);
			jdbcEmployeesDAOImpl.getAllEmployees();
			assertTrue(false);
		} catch (ClassNotFoundException | SQLException | DAOException e) {
			assertTrue(true);
		}
	}

	@Test
	void testgetEmployeeByIdWhenFound() {
		try {
			when(manager.openConnection()).thenReturn(connection);
			when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
			when(preparedStatement.executeQuery()).thenReturn(resultSet);
			when(resultSet.next()).thenReturn(true).thenReturn(false);
			when(resultSet.getInt("employee_id")).thenReturn(101);
			int employeeId = 101;

			Employees employees = jdbcEmployeesDAOImpl.getEmployeeByEmpId(employeeId);
			assertEquals(employeeId, employees.getEmployeeId());
		} catch (ClassNotFoundException | SQLException | DAOException e) {
			assertTrue(true);
		}
	}

	@Test
	void testgetEmployeeByIdWhenIsNotFound() {
		try {
			when(manager.openConnection()).thenReturn(connection);
			when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
			when(preparedStatement.executeQuery()).thenReturn(resultSet);
			when(resultSet.next()).thenReturn(false);
			int employeeId = 0;

			Employees employees = jdbcEmployeesDAOImpl.getEmployeeByEmpId(employeeId);
			assertEquals(employeeId, employees.getEmployeeId());
		} catch (ClassNotFoundException | SQLException | DAOException e) {
			assertTrue(true);
		}
	}

	@Test
	void teststoreEmployeeDetailsIfSuccessful() {
		try {
			when(manager.openConnection()).thenReturn(connection);
			when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
			when(preparedStatement.executeUpdate()).thenReturn(1);
			Employees employees = Mockito.mock(Employees.class);
			when(employees.getHireDate()).thenReturn(LocalDate.now());
			boolean actual = jdbcEmployeesDAOImpl.storeEmployeeDetails(employees);
			assertEquals(true, actual);

		} catch (ClassNotFoundException | SQLException | DAOException e) {
			assertFalse(true);
		}
	}

	@Test
	void teststoreEmployeeDetailsIfUnSuccessful() {
		try {
			when(manager.openConnection()).thenReturn(connection);
			when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
			when(preparedStatement.executeUpdate()).thenReturn(0);
			Employees employees = Mockito.mock(Employees.class);
			when(employees.getHireDate()).thenReturn(LocalDate.now());
			boolean actual = jdbcEmployeesDAOImpl.storeEmployeeDetails(employees);
			assertEquals(false, actual);

		} catch (ClassNotFoundException | SQLException | DAOException e) {
			assertFalse(true);

		}
	}

	@Test
	void teststoreEmployeeDetailsThrowsException() {
		try {
			when(manager.openConnection()).thenReturn(connection);
			when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
			when(preparedStatement.executeUpdate()).thenThrow(SQLException.class);
			Employees employees = Mockito.mock(Employees.class);
			when(employees.getHireDate()).thenReturn(LocalDate.now());
			jdbcEmployeesDAOImpl.storeEmployeeDetails(employees);
			assertTrue(false);

		} catch (ClassNotFoundException | SQLException | DAOException e) {
			assertTrue(true);

		}
	}
	
	@Test
	void testUpdateEmployeeSalaryIfSuccessful() {
		try {
			when(manager.openConnection()).thenReturn(connection);
			when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
			when(preparedStatement.executeUpdate()).thenReturn(1);
			boolean actual = jdbcEmployeesDAOImpl.updateEmployeeSalary(101, 7000);
			assertEquals(true, actual);
		} catch (ClassNotFoundException | SQLException | DAOException e) {
			assertFalse(true);
		}
	}
	
	@Test
	void testUpdateEmployeeSalaryIfUnSuccessful() {
		try {
			when(manager.openConnection()).thenReturn(connection);
			when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
			when(preparedStatement.executeUpdate()).thenReturn(0);
			boolean actual = jdbcEmployeesDAOImpl.updateEmployeeSalary(101, 7000);
			assertEquals(false, actual);
		} catch (ClassNotFoundException | SQLException | DAOException e) {
			assertFalse(true);
		}
	}
	
	@Test
	void testUpdateEmployeeSalaryThrowsException() {
		try {
			when(manager.openConnection()).thenReturn(connection);
			when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
			when(preparedStatement.executeUpdate()).thenThrow(SQLException.class);
			jdbcEmployeesDAOImpl.updateEmployeeSalary(101, 7000);
			assertTrue(false);
		} catch (ClassNotFoundException | SQLException | DAOException e) {
			assertTrue(true);
		}
	}
	
	@Test
	void testDeleteEmployeeRecordIfSuccessful() {
		Employees employees = new Employees();
		employees.setEmployeeId(101);
		try {
			when(manager.openConnection()).thenReturn(connection);
			when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
			when(preparedStatement.executeUpdate()).thenReturn(1);
			boolean actual = jdbcEmployeesDAOImpl.deleteEmployee(employees);
			assertTrue(actual);
		} catch (ClassNotFoundException | SQLException | DAOException e) {
			assertFalse(true);
		}
		
	}
	@Test
	void testDeleteEmployeeRecordIfUnsuccessful() {
		Employees employees = new Employees();
		employees.setEmployeeId(101);
		try {
			when(manager.openConnection()).thenReturn(connection);
			when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
			when(preparedStatement.executeUpdate()).thenReturn(0);
			boolean actual = jdbcEmployeesDAOImpl.deleteEmployee(employees);
			assertEquals(false, actual);
		} catch (ClassNotFoundException | SQLException | DAOException e) {
			assertTrue(true);
		}
		
	}
	@Test
	void testDeleteEmployeeRecordThrowsException() {
		Employees employees = new Employees();
		employees.setEmployeeId(101);
		try {
			when(manager.openConnection()).thenReturn(connection);
			when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
			when(preparedStatement.executeUpdate()).thenThrow(SQLException.class);
			jdbcEmployeesDAOImpl.deleteEmployee(employees);
			assertTrue(false);
		} catch (ClassNotFoundException | SQLException | DAOException e) {
			assertTrue(true);
		}
		
	}
	
	@Test
	void testgetEmployeeDepartmentIdWhenFound() {
		try {
			when(manager.openConnection()).thenReturn(connection);
			when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
			when(preparedStatement.executeQuery()).thenReturn(resultSet);
			when(resultSet.next()).thenReturn(true).thenReturn(false);
			when(resultSet.getInt("department_id")).thenReturn(10);
			int employeeId = 101;
			int deptId=10;
			
			Employees employees = jdbcEmployeesDAOImpl.getDepartmentName(employeeId);
			assertEquals(deptId, employees.getDepartmentId());
		} catch (ClassNotFoundException | SQLException | DAOException e) {
			assertTrue(true);
		}
	}

	@Test
	void testgetEmployeeDepartmentIdWhenNotFound() {
		try {
			when(manager.openConnection()).thenReturn(connection);
			when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
			when(preparedStatement.executeQuery()).thenReturn(resultSet);
			when(resultSet.next()).thenReturn(false);
		
			int employeeId = 101;
			int deptId=0;
			
			Employees employees = jdbcEmployeesDAOImpl.getDepartmentName(employeeId);
			assertEquals(deptId, employees.getDepartmentId());
		} catch (ClassNotFoundException | SQLException | DAOException e) {
			assertTrue(true);
		}
	}
}
