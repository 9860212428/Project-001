package com.SauceDemo.TestPackage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.SauceDemo.POMPackage.LoginPagePOMClass;

public class TC01_Verify_Login_Fuctionality 
{
	public static void main(String[] args) 
	  {
		  System.setProperty("webdriver.chrome.driver", 
				  "./Drivers/chromedriver.exe");
			 
			WebDriver driver = new ChromeDriver();
			System.out.println("Browser is Opened");
			 
			driver.manage().window().maximize();  // to maximize the current web page
			System.out.println("Browser is Maximized");
			
			driver.get("https://www.saucedemo.com/");  //Enter VAlid URL
			System.out.println("URL is Opened");
			
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);  // Apply Implicit Wait

			LoginPagePOMClass lp = new LoginPagePOMClass(driver);
			
			lp.Sendusername();
			System.out.println("Username is Entered");
			
			lp.Sendpassword();
			System.out.println("Password is Entered");
			
			lp.clickLoginButton();
			System.out.println("Clicked on Login Button");
			
//			Apply Validation
			
			System.out.println("Apply Validation");
			
			String ExpectedTitle = "Swag Labs";
			
			String ActualTitle = driver.getTitle();
			
			if (ExpectedTitle.equals(ActualTitle))
			{
				System.out.println("TestCase is passed");
			}
			
			else
			{
				System.out.println("Test Case is Failed");
			}
		driver.quit();
		System.out.println("Browser is Closed");
	  
	  }
}
