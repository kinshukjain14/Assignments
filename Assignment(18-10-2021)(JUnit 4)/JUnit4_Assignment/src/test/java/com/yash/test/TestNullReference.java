package com.yash.test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TestNullReference {

	@Test
	public void testIfObjectReferenceIsNull() {
		Object obj = null;
		assertThat(obj, nullValue());
	}
	
	@Test
	public void testIfObjectReferenceIsNotNull() {
		Object obj = new Object();
		assertThat(obj, notNullValue());
	}

}
