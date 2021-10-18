package com.yash.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMap {

	private Map<Integer,Integer> map;

	@Before
	public void setUp() throws Exception {
		map = new HashMap<Integer,Integer>();
		map.put(1001, 23212);
		map.put(1021, 23);
		map.put(1031, 34221);
		map.put(1201, 4342);
		map.put(1101, 26421);
		map.put(-1001, -10000);
		map.put(-10034, 232);	
	}

	@After
	public void tearDown() throws Exception {
		map=null;
	}

	@Test
	public void testMapContainsSpecificKeyAndValue() 
	{
		assertThat(map,hasEntry(-1001, -10000));
	}

}
