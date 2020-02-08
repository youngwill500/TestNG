package com.class3;

// Open chrome browser
// Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
// Login into the application
// Add 5 different Employees and create login credentials by providing: 
// First Name
// Last Name
// Username
// Password
// Provide Employee First and Last Name
// Verify Employee has been added successfully and take screenshot (you must have 5 different screenshots)
// Close the browser


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

// Open chrome browser
// Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
// Login into the application
// Add 5 different Employees and create login credentials by providing: 
// First Name
// Last Name
// Username
// Password
// Provide Employee First and Last Name
// Verify Employee has been added successfully and take screenshot (you must have 5 different screenshots)
// Close the browser
// Specify group for this test case, add it into specific suite and execute from xml file.





import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;

public class HW extends CommonMethods {
	

	
	@BeforeMethod
	public void openSite() {
	
	CommonMethods.setUp("chrome", "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
	driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
	driver.findElement(By.id("btnLogin")).click();
	
	
		
}
	@Test(dataProvider = "getData", groups="regression")
	public void addNewEmployees(String firstName, String lastName, String password) throws InterruptedException {
		
	WebDriverWait wait = new WebDriverWait(driver, 30);	
	driver.findElement(By.id("menu_pim_viewPimModule")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("menu_pim_addEmployee")).click();
	driver.findElement(By.id("firstName")).sendKeys(firstName);
	driver.findElement(By.id("lastName")).sendKeys(lastName);
	driver.findElement(By.id("chkLogin")).click();
	driver.findElement(By.id("user_name")).sendKeys(firstName+"."+lastName);
	driver.findElement(By.id("user_password")).sendKeys(password);
	driver.findElement(By.id("re_password")).sendKeys(password);
	driver.findElement(By.xpath("//input[@id='btnSave']")).click();
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[text()='Personal Details']")));
	
	
//	driver.findElement(By.id("menu_pim_viewPimModule")).click();
//	driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
//	driver.findElement(By.xpath("//input[@id='empsearch_employee_name_empName']")).sendKeys(firstName+" "+lastName);
	
	
	//WebElement actualName = driver.findElement(By.id("personal_txtEmpFirstName"));
	WebElement actualName = driver.findElement(By.xpath("//div[@id='profile-pic']/h1"));
	String expectedName = firstName+" "+lastName;
	SoftAssert softAssert = new SoftAssert();
	softAssert.assertEquals(actualName, expectedName);
	
	
	CommonMethods.takeScreenshot(firstName+"_"+lastName);
	
	 }	
	
	
	@DataProvider
	public Object [] [] getData() {
		
		Object [] [] data = {
				{"Kames", "Patrick","Syntax12345!"},
				{"Kon", "Jones","Syntax12345!"},
				{"Klex", "Albright","Syntax12345!"},
				{"Kiana", "Russian","Syntax12345!"},
				{"Kally", "Morris","Syntax12345!"}};
		return data;
	}
	

	
    @AfterMethod
	public void tearDown() {
	
		driver.close();
	}
	
}
