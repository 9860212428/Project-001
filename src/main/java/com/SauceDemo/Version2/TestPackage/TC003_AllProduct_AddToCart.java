package com.SauceDemo.Version2.TestPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SauceDemo.POMPackage.HomePagePOMClass;
import com.SauceDemo.UtilityPackage.UtilityClass;

public class TC003_AllProduct_AddToCart extends TestBaseClass_V2
{
	@Test
	public void VerifyAllProdAddToCart() throws IOException
	{
		HomePagePOMClass HP = new HomePagePOMClass(driver);
		HP.AllProductAddToCartClick();
//		System.out.println("Clicked on All Products ADD TO CART Buttons");
        log.info("Clicked on All Products ADD TO CART Buttons");
        
		//Take Screenshot before login credentials Entered
		UtilityClass.GetSceenshot(driver, "HomePage1");

		// Validation

		String ExpectedResult = "5";  //Actual 6 but for Our Confirmation to fail TC

		String ActualResult = HP.AddToCartLinkGetText();
	  
	  Assert.assertEquals(ExpectedResult, ActualResult);
	}
}
