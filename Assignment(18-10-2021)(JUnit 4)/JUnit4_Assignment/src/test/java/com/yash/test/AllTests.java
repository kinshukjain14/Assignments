package com.yash.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestListData.class, TestMap.class, TestNullReference.class, TestStringStartAndEnd.class })
public class AllTests {
	
}
