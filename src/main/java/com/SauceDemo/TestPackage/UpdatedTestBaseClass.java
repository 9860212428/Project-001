package com.SauceDemo.TestPackage;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.SauceDemo.POMPackage.HomePagePOMClass;
import com.SauceDemo.POMPackage.LoginPagePOMClass;
import com.SauceDemo.UtilityPackage.UtilityClass;

public class UpdatedTestBaseClass 
{
	 //We write all @AfterMethod & @BeforeMethod here
		// And write only @Test of Test cases in Test Class
		
		WebDriver driver;
		
		@BeforeClass
		public void Setup()
		{
			  System.setProperty("webdriver.chrome.driver", 
					  "./Drivers/chromedriver.exe");
				 
				 driver = new ChromeDriver();
				System.out.println("Browser is Opened");
				 
				driver.manage().window().maximize();  // to maximize the current web page
				System.out.println("Browser is Maximized");
		}
		
		@BeforeMethod
		public void Login()
		{
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
		}
		
		@AfterMethod
	    public void LogOut() throws IOException
	     {
			HomePagePOMClass HP = new HomePagePOMClass(driver);

		    HP.MenuButtonClick();
		    System.out.println("Clicked on Menu Button");
		    
		  //Take Screenshot after Clicked on Menu Button
		  	UtilityClass.GetSceenshot(driver, "LoginPage1");  
		  	
		    HP.logoutButtonClick();
		    System.out.println("Clicked on Logout Button");
	     }
		
		@AfterClass
	    public void tearDown()
	     {
			driver.quit();
			System.out.println("Browser is Closed");
	     }	
}
