package com.SauceDemo.Version2.TestPackage;

import java.io.IOException;

import org.testng.annotations.Test;

import com.SauceDemo.POMPackage.HomePagePOMClass;
import com.SauceDemo.UtilityPackage.UtilityClass;

public class TC004_VerifyLogOut extends TestBaseClass_V2 
{
	@Test
	public void VerifyLogout() throws IOException
	{	
	
	HomePagePOMClass HP = new HomePagePOMClass(driver);

    HP.MenuButtonClick();
//    System.out.println("Clicked on Menu Button");
    log.info("Clicked on Menu Button");
    
  //Take Screenshot after Clicked on Menu Button
  	UtilityClass.GetSceenshot(driver, "LoginPage1");  
  	
    HP.logoutButtonClick();
//    System.out.println("Clicked on Logout Button");
    log.info("Clicked on Logout Button");
	}
}
