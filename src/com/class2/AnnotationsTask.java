package com.class2;

import org.openqa.selenium.By;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.utils.CommonMethods;

public class AnnotationsTask extends CommonMethods {

	@BeforeMethod
	public void open() {
		CommonMethods.setUp("chrome", "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
	}

	@Test
	public void titleValidation() {
		String expectedTitle = "Human Management System";
		String actualTitle = driver.getTitle();// Human Management System
		Assert.assertEquals(actualTitle, expectedTitle, "Titles are NOT matched");

//		if (actualTitle.equals(expectedTitle)) {
//			System.out.println("test pass");
//		} else {
//			System.out.println("test fails");
//		}
	}

	@Test
	public void logoValidation() {
		boolean isDisplayed = driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
		Assert.assertTrue(isDisplayed, "Syntax Logo is NOT displayed");
		// using if condition we cannot make testNG test failed
//		if (isDisplayed) {
//			System.out.println("test pass");
//		} else {
//			System.out.println("test fails");
//		}
	}

	@AfterMethod
	public void close() {
		driver.close();
	}

}
