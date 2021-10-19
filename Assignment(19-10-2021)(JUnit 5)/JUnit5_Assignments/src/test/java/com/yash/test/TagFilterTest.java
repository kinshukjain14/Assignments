package com.yash.test;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.hamcrest.core.IsCollectionContaining;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.yash.service.Calculator;
import com.yash.service.GetList;

class TagFilterTest {

	private List<Integer> list;

	@BeforeEach
	void setUp() throws Exception {
		list = new GetList().getIntegerList();
	}

	@AfterEach
	void tearDown() throws Exception {
		list=null;
	}

	@DisplayName("Test 1 : To check elements are present in a list or not")
	@Tag("FAST")
	@Test
	void test1() {
		assertThat(list,IsCollectionContaining.hasItems(9,10,2));
	}
	
	@DisplayName("Test 2 : Test to check No is greater than 50")
	@Tag("SLOW")
	@Test
	void test2() 
	{
		Calculator calc = new Calculator();
		try {
			Thread.sleep(1000);
			assertTrue(calc.computeDivision(500, 10)>=50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
