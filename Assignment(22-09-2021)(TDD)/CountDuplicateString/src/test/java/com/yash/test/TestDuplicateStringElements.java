package com.yash.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yash.service.DuplicateStringElements;

public class TestDuplicateStringElements {
	

	private DuplicateStringElements duplicateStringElements;

	@Before
	public void setUp() throws Exception {
		duplicateStringElements = new DuplicateStringElements();
	}

	@After
	public void tearDown() throws Exception {
		duplicateStringElements=null;
	}

	@Test
	public void testCountDuplicateStrings_positive() 
	{
		String[] inputArr= {"Hello","Hi","Hello","Welcome","new","Welcome","rtr","ddf","rtr","Hi"};
		int expected = 4;
		int actual = duplicateStringElements.getDuplicateCount(inputArr);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCountDuplicateStrings_negative() 
	{
		String[] inputArr = {"Hello"};
		int expected = 0;
		int actual = duplicateStringElements.getDuplicateCount(inputArr);
		assertEquals(expected, actual);
	}
	

}
