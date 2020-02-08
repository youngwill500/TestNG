package com.utils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonMethods {
	public static WebDriver driver;
	/*
	 * Use this method to open Web page
	 * @Param browser the desired browse
	 * @param url the desired Url
	 */
	
	
	public static void setUp(String browser, String url) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Drivers/chromeDriver.exe");
			 driver = new ChromeDriver();
			driver.get(url);
			
		}else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
			 driver = new FirefoxDriver();
			driver.get(url);
		}else {
			System.err.println("Browser not supported");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		
	}
	
	/**
	 * This method will take a screenshot
	 * @param fileName
	 */
	public static void takeScreenshot(String fileName) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File file=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("screenshot/"+fileName+".png"));
		} catch (IOException e) {
			System.out.println("Cannot take a screenshot");
		}
	}
	
	
	
	
	public static void acceptAlert() {
        try {
            Alert alert=driver.switchTo().alert();
            alert.accept();
        }catch(NoAlertPresentException e) {
            System.out.println("Alert is not present");
        }
    }
    /**
     * This method dismiss the alert
     * 
     * @throws will throw an NoAlertPresentException if alert is not present
     */
    public static void dismissAlert() {
        try {
            Alert alert=driver.switchTo().alert();
            alert.dismiss();
        }catch(NoAlertPresentException e) {
            System.out.println("Alert is not present");
        }
    }
    /**This method will get a text from the alert
     * 
     * @return text of the alert
     * @throws will throw NoAlertPresentException if alert is not present
     */
    
    public static String getAlertText() {
        try {
            Alert alert=driver.switchTo().alert();
            return alert.getText();
        }catch(NoAlertPresentException e) {
            System.out.println("Alert is not present");
        }
        return null;
    }
    
    /*
     * This method will click on the element using JSExecutor
     * 
     */
    
    public static void jsClick(WebElement element) {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();", element);
    	
    }
    
    /*
     * This method will search for the Element 
     * 
     */
    
    public static void scrollIntoElement(WebElement element) {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView(true);", element);
    	
    }
    
    /*
     * This method will scroll the page down
     * @param pixel
     */
	
	
    public static void scrollDown(int pixel) {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,"+pixel+")");
    	
    }
    
    //This method will scroll up 
	
    public static void scrollUp(int pixel) {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,"+pixel+")");
    	
    }
	
	

}
