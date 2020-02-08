package com.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
	
													// result will give help 
	
	  public void onTestStart(ITestResult result) {    	//Hey Listener, when my test starts listen to it and perform this action
		    System.out.println("Test Started"+result.getName());
		  }
	
	  public void onTestSuccess(ITestResult result) { 	//When the test passes, listen to it and perform this actions
		   System.out.println("Test Passed "+result.getName());
		   CommonMethods.takeScreenshot("passed/" + result.getName());
		  }
	
	  
	  public void onTestFailure(ITestResult result) { 	//When failure happens, listen then perform this actions
		   System.out.println("Test Failed "+result.getName());
		   CommonMethods.takeScreenshot("failed/" + result.getName());
		  }
	
}
