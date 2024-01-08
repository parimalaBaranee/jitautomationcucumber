package com.cucumber.steps;

import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Spliterator;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import com.cucumber.BasePage.BaseTest;
import com.cucumber.Page.LoginPage;
import com.cucumber.screenshotUtility.ScreenshotUtils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class LoginStep extends ScreenshotUtils{
	WebDriver driver;
	
	 private HashMap<String, By> objRepository;
	 private String mainWindowHandle;

	public WebElement getElement(String key) {
        objRepository = new HashMap<>();
        objRepository.put("username", By.id("username"));
        objRepository.put("password", By.id("password"));
        objRepository.put("Login", By.id("Login"));
        objRepository.put("menuDropdown", By.id("userNavLabel"));
        objRepository.put("developerConsole", By.xpath("//a[text()='Developer Console']"));

        By locator = objRepository.get(key);
        return driver.findElement(locator);
    }
	
	public void windowswitch()
	{
		
	 for (String handle : driver.getWindowHandles()) {
         if (!handle.equals(mainWindowHandle)) {
             driver.switchTo().window(handle);
             break;
         }
     }
	}
	
			@Given("User launch the application")	
				
		public void user_launch_the_application() {
			
			
			if (driver==null)
			{
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		    driver.get("https://login.salesforce.com/");
		}
		}
			
			
		    @Given("User is on {string}")
			
		    public void user_is_on(String string) {
		       System.out.println(string);
		    }

		    @Then("User enter into the username {string}")
			
		    public void user_enter_into_the_username(String string) {
		    	 WebElement username =getElement("username");
				    username.sendKeys(string);
		    }

		    @Then("User enter into the password {string}")
		    public void user_enter_into_the_password(String string) {
		    	 WebElement username =getElement("password");
				    username.sendKeys(string);
		    }

		    @Then("User click on Button {string}")
		    public void user_click_on_button(String key) {
		    	 WebElement loginButton = getElement("Login");
		         loginButton.click();
		    }

		    @Then("verify the text {string} {string}")
		    public void verify_the_text(String string, String string2) {
		       System.out.printf(string, string2);
		    }

		    
		    @Then("user click on button1 {string}")
		    public void user_click_on_button1(String string) {
		    	WebElement rememberme=driver.findElement(By.id("rememberUn"));
		    	rememberme.click();
		    }


		    @Then("user click on {string}")
		    public void user_click_on(String string) {
		    	WebElement menudropdown =getElement("menuDropdown");
		    	menudropdown.click();
		    }

		    @Then("User click on logoutButton {string}")
		    public void user_click_on_logout_button(String string) {
		    	WebElement Logout= driver.findElement(By.xpath("//a[text()='Logout']"));
		    	Logout.click();
		    }
		    
		    @SuppressWarnings("deprecation")
			@Then("User check the username {string}")
		    public void user_check_the_username(String expectedusername) {
		    	WebDriverWait wait = new WebDriverWait(driver, 10);
		    	WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='idcard-identity']")));
		    	//WebElement login = driver.findElement(By.id("Login"));
		    	 String actualUsername = login.getText();
		    	 Assert.assertEquals( expectedusername, actualUsername);
		    }
  @Then("verify the checkbox is selected")
		    public void verify_the_checkbox_is_selected() {
		    	WebElement rememberme=driver.findElement(By.id("rememberUn"));
		    	System.out.println("rememberme.isSelected()" + rememberme.isSelected());
		    }

 

  @SuppressWarnings("deprecation")
@Then("verify the\"DropDownNameIsMatching\"")
  public void verify_the_drop_down_name_is_matching() {
	  WebElement menudropdown = driver.findElement(By.id("userNavLabel"));
		String actualusername=menudropdown.getText();
		String expectedusername="Parimala Lucky";
		Assert.assertEquals(expectedusername, actualusername);
	 

  }
  
  @Then("verify the\"usermenuItem\"")
  public void verify_the_usermenu_item() {
	  List<String> expectedDropdownItems = Arrays.asList(
              "My Profile",
              "My Settings",
              "Developer Console",
              "Switch to Lightning Experience" ,"Logout"
      );
	  
	  List<WebElement> actualDropdownItems = driver.findElements(By.xpath("//div[@id='userNav-menuItems']//a"));

      // Verify that the actual items match the expected items
Assert.assertEquals("Number of items in the dropdown is incorrect.", expectedDropdownItems.size(),
              actualDropdownItems.size());

  }
	
  @Then("User clicks on {string} in the dropdown")
  public void user_clicks_on_in_the_dropdown(String string) {
	  mainWindowHandle = driver.getWindowHandle();
	  WebElement developerconsole= getElement("developerConsole");
		developerconsole.click();
		
  }
	 
  @Then("Developer Console should be opened {string}")
  public void developer_console_should_be_opened(String pageName)
  {
	  for (String windowHandle : driver.getWindowHandles()) {
          if (!windowHandle.equals(mainWindowHandle)) {
              driver.switchTo().window(windowHandle);
              // Perform actions on the new window if needed

              // Close the new window
              driver.close();
              break;
          }
      }

      // Switch back to the original window
      driver.switchTo().window(mainWindowHandle);
	  
		  
		 
	}
  
  
 
  
  

		   
		    @After
		  //  public void tidyUp() {
		    	public void afterScenario(Scenario scenario) 
		    {    	
		    	if(!scenario.isFailed()) 
		    	{
		            String screenshotName = scenario.getName().replaceAll(" ", "_");
		            ScreenshotUtils.captureScreenshot(driver, screenshotName);
		        driver.close();
		    }

		   
		    }
		
}
