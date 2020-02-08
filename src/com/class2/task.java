package com.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;
import com.utils.Constants;



public class task extends CommonMethods {
	
	@BeforeMethod
	public void open() {
		CommonMethods.setUp("chrome", Constants.HRMS_URL);
	}
	
	@Test
	public void verifyLabels() {
	driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
	driver.findElement(By.id("btnLogin")).click();
	driver.findElement(By.linkText("PIM")).click();
	driver.findElement(By.linkText("Add Employee")).click();
	
	
	SoftAssert softAssert = new SoftAssert();
	//String expectedFullNameLabel = "Full Name";
	boolean expectedFullNameLabel = driver.findElement(By.xpath("//label[text()='Full Name']")).isDisplayed();
	softAssert.assertTrue(expectedFullNameLabel, "Full Name Label is displayed");
	
	boolean expectedEmployeeIdLabel  = driver.findElement(By.xpath("//label[text()='Employee Id']")).isDisplayed();
	softAssert.assertTrue(expectedEmployeeIdLabel, "Employee ID is displayed");


	boolean expectedPhotographLabel  = driver.findElement(By.xpath("//label[text()='Photograph']")).isDisplayed();
	softAssert.assertTrue(expectedPhotographLabel, "Photograph is displayed");
	
    driver.findElement(By.id("firstName")).sendKeys("John");
    driver.findElement(By.id("lastName")).sendKeys("Doe");
    
   driver.findElement(By.id("firstName")).isDisplayed();
   driver.findElement(By.id("lastName")).isDisplayed();
		
	}
	
	@AfterMethod
	public void endClass() {
		driver.close();
	}
	
	

}
