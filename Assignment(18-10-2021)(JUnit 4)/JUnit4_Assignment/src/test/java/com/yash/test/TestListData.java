package com.yash.test;


import static org.hamcrest.MatcherAssert.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestListData 
{
	private List<Integer> list;

	@Before
	public void setUp() {
		list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(9);
		list.add(34);
		list.add(9);
		list.add(54);
		list.add(10);
	}
	
	@Test
	public void testIfListContainsItems() {
		assertThat(list,Matchers.hasItems(1,9,10));
	}
	
	@After
	public void tearDown() {
		list=null;
	}
	

}
