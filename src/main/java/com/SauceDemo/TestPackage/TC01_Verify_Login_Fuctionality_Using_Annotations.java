package com.SauceDemo.TestPackage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SauceDemo.POMPackage.LoginPagePOMClass;

public class TC01_Verify_Login_Fuctionality_Using_Annotations 
{
	WebDriver driver;
	@BeforeMethod
	public void Setup()
	{
		  System.setProperty("webdriver.chrome.driver", 
				  "./Drivers/chromedriver.exe");
			 
			 driver = new ChromeDriver();
			System.out.println("Browser is Opened");
			 
			driver.manage().window().maximize();  // to maximize the current web page
			System.out.println("Browser is Maximized");
			
			driver.get("https://www.saucedemo.com/");  //Enter VAlid URL
			System.out.println("URL is Opened");
			
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);  // Apply Implicit Wait

			LoginPagePOMClass lp = new LoginPagePOMClass(driver);
			
			lp.Sendusername();
			System.out.println("Username is Entered");
			
			lp.Sendpassword();
			System.out.println("Password is Entered");
			
			lp.clickLoginButton();
			System.out.println("Clicked on Login Button");
	}	
//			Apply Validation
	@Test
	public void VerifyLogin()
	{
			System.out.println("Apply Validation");
			
			String ExpectedTitle = "Swag Labs";
			
			String ActualTitle =  driver.getTitle();
			
			if (ExpectedTitle.equals(ActualTitle))
			{
				System.out.println("TestCase is passed");
			}
			
			else
			{
				System.out.println("Test Case is Failed");
			}
	}
	
      @AfterMethod
     public void tearDown()
     {
		driver.quit();
		System.out.println("Browser is Closed");
     }
      
	  }

