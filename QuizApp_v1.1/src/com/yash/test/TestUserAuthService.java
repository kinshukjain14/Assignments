package com.yash.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.yash.exception.AuthenticationException;
import com.yash.helper.QuizFactory;
import com.yash.service.UserService;

class TestUserAuthService {

	private static UserService service;
	@BeforeAll
	static void setUpBeforeClass() {
		service = QuizFactory.newUserAuthService(); 
	}
	
	@DisplayName("Test user authentication : Positive")
	@Test
	void test1() {
		String username = "kinshuk.jain14";
		String password = "kinshu123";
		try {
			boolean authenticateUser = service.authenticateUser(username, password);
			assertTrue(authenticateUser);
		} catch (AuthenticationException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	@DisplayName("Test user authentication : Negative")
	@Test
	void test2() {
		String username = "ashutosh12";
		String password = "123";
		try {
			service.authenticateUser(username, password);
			assertTrue(false);
		} catch (AuthenticationException e) {
			assertTrue(true);
		}
	}

	@DisplayName("Test user authentication : Exception")
	@Test
	void test3() {
		String username = "ashutosh12";
		String password = "123";
		try {
			service.authenticateUser(username, password);
			assertTrue(false);
		} catch (AuthenticationException e) {
			assertEquals("== Invalid username or password ==", e.getMessage());
		}
	}
	
	@AfterAll
	static void tearDownAfterClass() {
		service=null;
	}

}
