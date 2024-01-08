package com.cucumber.screenshotUtility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {
	
	

	    public static void captureScreenshot(WebDriver driver, String screenshotName) {
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        File destination = new File("./screenshots/" + screenshotName + ".png");

	        try {
	            org.apache.commons.io.FileUtils.copyFile(source, destination);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
	


