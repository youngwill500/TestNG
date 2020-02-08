package com.class2;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;
import com.utils.Constants;

public class SoftAssertionDemo extends CommonMethods {
	
	@BeforeMethod
	public void open() {
		setUp("chrome",Constants.HRMS_URL);
	}
	
	@Test
	public void logoAndLogin() {
		boolean logoDisplayed = driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
		logoDisplayed=false;
		
		//Hard Assert will fail and execution will stop at that point
		//Assert.assertTrue(LogoDisplayed, "Logo is Not displayed');
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(logoDisplayed, "Logo is NOT displayed");
		
		
		
		
		
	}
	
	
	

}
