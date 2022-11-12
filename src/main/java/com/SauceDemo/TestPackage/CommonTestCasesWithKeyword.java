package com.SauceDemo.TestPackage;
import java.io.IOException;
import org.testng.annotations.Test;
import com.SauceDemo.POMPackage.HomePagePOMClass;
import com.SauceDemo.UtilityPackage.UtilityClass;

public class CommonTestCasesWithKeyword extends TestBaseClass
{
   

	// Test Case-01
	@Test (priority=1, invocationCount=1, timeOut=2000, enabled=true)
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
	
	// Test Case-02
	
	@Test (priority=3, invocationCount=1, dependsOnMethods="VerifyLogin")
	public void VerifybagAddtoCartFuctionality() throws IOException
	{
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

	}	
	
	// Test Case-03
	
	@Test (priority=2, invocationCount=1, dependsOnMethods="VerifyLogin")
	public void VerifyAllProdAddtoCartFuctionality() throws IOException
	{
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

	}
	
	// Test Case-04
	
@Test(priority=4, invocationCount=1, dependsOnMethods="VerifyLogin")	
    public void VerifyLogout() throws IOException
    {
	HomePagePOMClass HP = new HomePagePOMClass(driver);

    HP.MenuButtonClick();
    System.out.println("Clicked on Menu Button");
    
  //Take Screenshot after Clicked on Menu Button
  	UtilityClass.GetSceenshot(driver, "LoginPage1");  
  	
    HP.logoutButtonClick();
    System.out.println("Clicked on Logout Button");

    driver.quit();
    System.out.println("Browser is closed");
    
    }
}