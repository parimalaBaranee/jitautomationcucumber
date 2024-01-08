package com.cucumber.BasePage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	WebDriver driver;
	public WebDriver getDriver() {
		
		if(driver==null) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
			return driver;
		}
		
		public void launchapp(WebDriver driver) {
			driver.get("https://login.salesforce.com");
		}
	public void takescreenshot(WebDriver driver, String methodName) {
			
			//Take Screen shot interface create and Object of thescreen 
			TakesScreenshot screenshot = ((TakesScreenshot)driver);
			// store this in source file . 
			File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
			
			Date current = new Date();
			String timestamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(current);
			
			     String reportFileName = "Saleseforce" +timestamp+ ".jpeg";
			     String fileSeperator = System.getProperty("file.separator");
			     String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "newscreenshots";
			     String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName;
			 
			
			
			//String filepath = reportFileLocation;
			File destFile = new File (reportFileLocation);
			try {
				FileUtils.copyFile(scrFile, destFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}
