package com.SauceDemo.Version2.TestPackage;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.SauceDemo.POMPackage.LoginPagePOMClass;

public class TestBaseClass_V2 
{
	//We write all @AfterMethod & @BeforeMethod here
		// And write only @Test of Test cases in Test Class
		
		WebDriver driver;
		Logger log = Logger.getLogger("Automation_Project_2");
		
		@Parameters("Browsername")
		@BeforeMethod
		public void Setup(String Browsername)
		{
			if (Browsername.equals("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver", 
						"./Drivers/chromedriver.exe");
				 
				 driver = new ChromeDriver();	
			}
			else
			{
				System.out.println("Browser is Opened");System.setProperty("webdriver.gecko.driver", 
						"./Drivers/geckodriver.exe");
				   driver = new FirefoxDriver();	
			}
		
			PropertyConfigurator.configure("Log4j.Properties");
			
			log.info("Browser is Opened");
			
				driver.manage().window().maximize();  // to maximize the current web page
//				System.out.println("Browser is Maximized");
				log.info("Browser is Maximized");
		
				driver.get("https://www.saucedemo.com/");  //Enter VAlid URL
//				System.out.println("URL is Opened");
				log.info("URL is Opened");
				
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);  // Apply Implicit Wait

				LoginPagePOMClass lp = new LoginPagePOMClass(driver);
				
				lp.Sendusername();
//				System.out.println("Username is Entered");
				log.info("Username is Entered");
				
				lp.Sendpassword();
//				System.out.println("Password is Entered");
				log.info("Password is Entered");
				
				lp.clickLoginButton();
//				System.out.println("Clicked on Login Button");
				log.info("Clicked on Login Button");
		}
		
		
		@AfterMethod
	    public void tearDown()
	     {
			driver.quit();
//			System.out.println("Browser is Closed");
			log.info("Browser is Closed");
	     }	
}
