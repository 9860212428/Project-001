package com.SauceDemo.Version2.TestPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_Verify_Login extends TestBaseClass_V2

{
//	WebDriver driver;
//	@BeforeMethod
//	public void Setup()
//	{
//		  System.setProperty("webdriver.chrome.driver", 
//				  "./Drivers/chromedriver.exe");
//			 
//			 driver = new ChromeDriver();
////			System.out.println("Browser is Opened");
//			log.info("Browser is Opened");
//			 
//			driver.manage().window().maximize();  // to maximize the current web page
////			System.out.println("Browser is Maximized");
//			log.info("Browser is Maximized");
//			
//			driver.get("https://www.saucedemo.com/");  //Enter VAlid URL
//			System.out.println("URL is Opened");
//			
//			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);  // Apply Implicit Wait
//
//			LoginPagePOMClass lp = new LoginPagePOMClass(driver);
//			
//			lp.Sendusername();
////			System.out.println("Username is Entered");
//		    log.info("Username is Entered");
//			
//			lp.Sendpassword();
////			System.out.println("Password is Entered");
//			log.info("Password is Entered");
//			
//			lp.clickLoginButton();
////			System.out.println("Clicked on Login Button");
//			log.info("Clicked on Login Button");
//	}
	
	@Test
	public void VerifyLogin()
	{
//			System.out.println("Apply Validation");
			log.info("Apply Validation");
			
			String ExpectedTitle = "Swag Labs";
			
			String ActualTitle =  driver.getTitle();
	
	Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	
//	@AfterMethod
//    public void tearDown()
//     {
//		driver.quit();
////		System.out.println("Browser is Closed");
//		log.info("Browser is Closed");

     
}
