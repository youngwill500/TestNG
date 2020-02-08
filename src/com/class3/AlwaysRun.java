package com.class3;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlwaysRun {
	
	@BeforeMethod(alwaysRun=true)
	public void beforeMethod() {
		System.out.println("I am before method");
	}
	
	@AfterMethod(alwaysRun=true)
	public void afterMethod() {
		System.out.println("I am after method");
	}
	
	@Test
	public void testMethod() {
		System.out.println("I am the test method");
	}
	
	
	
	

}
