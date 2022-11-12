package com.SauceDemo.TestPackage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.SauceDemo.POMPackage.HomePagePOMClass;
import com.SauceDemo.POMPackage.LoginPagePOMClass;
import com.SauceDemo.UtilityPackage.UtilityClass;

public class TC03_Verify_All_Product_AddToCart_Fuctionality 
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
System.out.println("Clicked on Login Button");

HomePagePOMClass HP = new HomePagePOMClass(driver);

HP.AllProductAddToCartClick();
System.out.println("Clicked on All Products ADD TO CART Buttons");

//Take Screenshot before login credentials Entered
UtilityClass.GetSceenshot(driver, "HomePage1");

// Validation

String ExpectedResult = "6";

String ActualResult = HP.AddToCartLinkGetText();

if(ExpectedResult.equals(ActualResult))
{
	System.out.println("Test Case is Passed");
}

else
{
	System.out.println("Test Case is Failed");
}

driver.quit();
System.out.println("Browser is Closed");
}
}
