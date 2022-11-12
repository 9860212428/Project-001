package com.SauceDemo.POMPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePOMClass 
{
//POM Class for Login Page elements & Actions on it
	

//	Steps in POM Class
	
//1--> Webdriver Declare
	private WebDriver driver;
	
//2--> @FindBy Element find
	
	@FindBy(xpath="//input[@id='user-name']")
	private WebElement username;
//3--> Method to apply action on Element
	
	public void Sendusername()
	{
		 username.sendKeys("standard_user");
	}

	//2--> @FindBy Element find
	
		@FindBy(xpath="//input[@id='password']")
		private WebElement password;
	//3--> Method to apply action on Element
		
		public void Sendpassword()
		{
			 password.sendKeys("secret_sauce");
		}

		//2--> @FindBy Element find
		
			@FindBy(xpath="//input[@id='login-button']")
			private WebElement login;
		//3--> Method to apply action on Element
			
			public void clickLoginButton()
			{
				 login.click();
			}
	
//4--> Constructor Declare
	
	public LoginPagePOMClass(WebDriver driver)
	{
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	
}
