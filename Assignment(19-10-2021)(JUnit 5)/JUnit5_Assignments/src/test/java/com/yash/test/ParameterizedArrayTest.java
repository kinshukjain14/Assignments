package com.yash.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParameterizedArrayTest {

	@ParameterizedTest
	@ValueSource(ints ={10,20,12,10,12})
	void testArrayEvenElements(int element) 
	{
		assertTrue(element%2==0);
	}

}
