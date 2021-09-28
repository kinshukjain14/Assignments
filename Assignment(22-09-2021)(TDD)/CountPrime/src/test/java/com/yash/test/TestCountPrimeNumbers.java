package com.yash.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yash.service.CountPrimeNumbers;

public class TestCountPrimeNumbers {

	private CountPrimeNumbers countPrimeNumbers;

	@Before
	public void setUp() throws Exception {
		countPrimeNumbers = new CountPrimeNumbers();
	}

	@After
	public void tearDown() throws Exception {
		countPrimeNumbers=null;
	}

	@Test
	public void testCountPrime_positive() 
	{
		int[] inputArr= {1,2,4,3,21,33,4,13,17};
		int expected = 4;
		int actual = countPrimeNumbers.getCount(inputArr);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCountPrime_negative() {
		int[] inputArr= {};
		try {
		countPrimeNumbers.getCount(inputArr);
		assertTrue(false);
		}
		catch(RuntimeException e) {
			assertTrue(true);
			System.err.println(e.getMessage());
		}
	}

}
