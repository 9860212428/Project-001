package com.SauceDemo.TestPackage;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.SauceDemo.POMPackage.HomePagePOMClass;
import com.SauceDemo.POMPackage.LoginPagePOMClass;
import com.SauceDemo.UtilityPackage.UtilityClass;

public class TC02_Verify_Bag_Product_AddToCart_Functionality 
{
   public static void main(String[] args) throws IOException 
   {
	System.setProperty("webdriver.chrome.driver", 
			"./Drivers/chromedriver.exe");

	WebDriver driver = new ChromeDriver();
	System.out.println("Browser is Opened");
	 
	driver.manage().window().maximize();  // to maximize the current web page
	System.out.println("Browser is Maximized");
	
	driver.navigate().to("https://www.saucedemo.com/");
	System.out.println("Valid URL is Opened");
	
	//Take Screenshot before login credentials Entered
	UtilityClass.GetSceenshot(driver, "LoginPage1");
	
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	
	LoginPagePOMClass lp = new LoginPagePOMClass(driver);
	
	lp.Sendusername();
	System.out.println("Username is Entered");
	
	lp.Sendpassword();
	System.out.println("Password is Entered");
	
	//Take Screenshot After login credentials Entered
	UtilityClass.GetSceenshot(driver, "LoginPage2");
	
	lp.clickLoginButton();
	System.out.println("Clicked on Login Button");
	
	HomePagePOMClass HP = new HomePagePOMClass(driver);
	 
	HP.BagAddToCartClick();
	System.out.println("Clicked on Bag Product Add to cart Button");
	
	//Take Screenshot of Home Screen after product add to cart
	UtilityClass.GetSceenshot(driver, "HomePage");
	
//Validation
	
	System.out.println("Apply Validation");
	  
	  String ExpectedCount = "2";
	  
	  String ActualCount = HP.AddToCartLinkGetText();
	  
	  if (ExpectedCount.equals(ActualCount))
	  {
		  System.out.println("Test case is Passed");	  
	  }
	  else
	  {
		  System.out.println("Test Case is Failed");
	  }

	driver.quit();
	System.out.println("Browser is Closed");
   }
}
