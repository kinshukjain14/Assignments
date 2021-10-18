package com.yash.test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class TestStringStartAndEnd {

	@Test
	public void testStringStartWith_S_And_EndsWith_H() {
		String str = "Someone told him I am from Chittogarh";
		assertThat(str,startsWith("S"));
		assertThat(str, endsWith("h"));
	}

}
