package com.class2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import com.utils.CommonMethods;

public class InternetTask extends CommonMethods{
	
	@BeforeMethod
	public void start() {
		CommonMethods.setUp("chrome", "https://the-internet.herokuapp.com/");
		
	}
	
	@Test
	public void verifyWebLinks() {
		
		List <WebElement> links = driver.findElements(By.tagName("li"));
		links.size();
		
		for(int i = 0; i <links.size(); i++) {
			   String url = links.get(i).getAttribute("href");
	            System.out.println("Name:"+links.get(i).getText());
	            System.out.println("url"+url);
	            System.out.println("----");
			
		}
		
		
	}
	
	

}
