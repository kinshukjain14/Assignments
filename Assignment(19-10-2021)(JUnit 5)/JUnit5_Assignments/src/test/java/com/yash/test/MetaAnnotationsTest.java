package com.yash.test;

import static org.junit.jupiter.api.Assertions.*;

import com.yash.meta.Feature1;
import com.yash.meta.Feature2;
import com.yash.service.ArrayOperation;
import com.yash.service.Calculator;

class MetaAnnotationsTest {

	@Feature1
	void testArraysorting() 
	{
		ArrayOperation o = new ArrayOperation();
		int []arrayInput = {23,45,3,21,3,2,1};
		int []expected = {1,2,3,3,21,23,45};
		int []actual = o.sortArray(arrayInput);
		assertArrayEquals(expected, actual);
	}
	
	@Feature2
	void testCalculatorOperation() 
	{
		Calculator calc = new Calculator();
		int expected = 50;
		int no1=500;
		int no2=10;
		int actual = calc.computeDivision(no1,no2);
		assertEquals(expected, actual);
	}

}
