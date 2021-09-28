package com.yash.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yash.service.ArrayFourthLargestElement;

public class TestArrayFourthLargestElement {

	private ArrayFourthLargestElement element;

	@Before
	public void setUp() throws Exception {
		element = new ArrayFourthLargestElement();
	}

	@After
	public void tearDown() throws Exception {
		element=null;
	}

	@Test
	public void testArray_NthLargestElementPositive() {
		int inputArr[]= {20,32,2,43,45,23};
		int expected = 23;
		int index=4;
		int actual = element.getFourthLargest(inputArr,index);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testArray_NthLargestElementNegative() {
		int inputArr[]= {2,5,3};
		int index=4;
		try {
			element.getFourthLargest(inputArr, index);
			assertTrue(true);
		}
		catch(Exception e) {
			System.err.println(e);
			assertTrue(false);
		}
	}
	
	@Test
	public void testArray_ExceptionWhen_Nth_ValueIsGreaterThanSize() {
		int inputArr[]= {2,5,3,4,3,32,23,2,32,42,323};
		int index=inputArr.length+1;;
		element.getFourthLargest(inputArr, index);
		assertTrue(true);
	}

}
