package com.SauceDemo.TestPackage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.SauceDemo.POMPackage.HomePagePOMClass;
import com.SauceDemo.POMPackage.LoginPagePOMClass;
import com.SauceDemo.UtilityPackage.UtilityClass;

public class TC04_Verify_Logout_Fuctionality 
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

	LoginPagePOMClass lp = new LoginPagePOMClass(driver);

	lp.Sendusername();
	System.out.println("Username is Entered");

	lp.Sendpassword();
	System.out.println("Password is Entered");

	//Take Screenshot After login credentials Entered
	UtilityClass.GetSceenshot(driver, "LoginPage2");

	lp.clickLoginButton();
	System.out.println("Clicked on Login Button & Redirected to Home Page");

	HomePagePOMClass HP = new HomePagePOMClass(driver);

    HP.MenuButtonClick();
    System.out.println("Clicked on Menu Button");
    
  //Take Screenshot after Clicked on Menu Button
  	UtilityClass.GetSceenshot(driver, "LoginPage1");  
  	
    HP.logoutButtonClick();
    System.out.println("Clicked on Logout Button");

    driver.quit();
    System.out.println("Browser is closed");
    
    //Apply Validation
    
    
}
}
