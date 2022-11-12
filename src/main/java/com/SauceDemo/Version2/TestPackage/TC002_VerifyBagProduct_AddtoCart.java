package com.SauceDemo.Version2.TestPackage;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.SauceDemo.POMPackage.HomePagePOMClass;
import com.SauceDemo.UtilityPackage.UtilityClass;

public class TC002_VerifyBagProduct_AddtoCart extends TestBaseClass_V2
{
	@Test
	public void VrifyBagAddToCart() throws IOException
	{
	
	HomePagePOMClass HP = new HomePagePOMClass(driver);
	 
	HP.BagAddToCartClick();
//	System.out.println("Clicked on Bag Product Add to cart Button");
	log.info("Clicked on Bag Product Add to cart Button");
	
	//Take Screenshot of Home Screen after product add to cart
	UtilityClass.GetSceenshot(driver, "HomePage");
	
//Validation
	
//	System.out.println("Apply Validation");
	log.info("Apply Validation");
	  
	  String ExpectedCount = "1";
	  
	  String ActualCount = HP.AddToCartLinkGetText();
	  
	  Assert.assertEquals(ActualCount, ExpectedCount);
	}
	
}
