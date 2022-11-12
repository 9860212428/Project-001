package com.SauceDemo.POMPackage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePOMClass 
{
//POM Class for Home Page elements & Actions on it
	

//	Steps in POM Class
	
//1--> Webdriver Declare
	private WebDriver driver;
	
//2--> @FindBy Element find
	
	//For Menu Button
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")
	private WebElement menuButton;
//3--> Method to apply action on Element
	
	public void MenuButtonClick()
	{
		menuButton.click();
	}
	
	//For logout Button
		@FindBy(xpath="//a[@id='logout_sidebar_link']")
		private WebElement logoutButton;
		
		public void logoutButtonClick()
		{
			logoutButton.click();
		}

	//For Add to Cart Button of Single bag Product
		
		@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
		private WebElement BagAddToCart;
		
		public void BagAddToCartClick()
		{
			BagAddToCart.click();
		}
		
		
//For Add to Cart Button of all Products
		
      @FindBy(xpath="//button[text()='Add to cart']")
	  List <WebElement> AllProductAddToCart;
				
	public void AllProductAddToCartClick()
	{
//		AllProductAddToCart.get(0).click(); 
//due to Collection Regular for loop not shows complete result so,
// Use for each Loop		
		for (WebElement allProduct : AllProductAddToCart )
//            datatype Refveriable     Webelement      	
		{
			allProduct.click();
	  //   Refveriable.action
		}
		
	}	
		
	//For Add to Cart link 
	
			@FindBy(xpath="//span[@class='shopping_cart_badge']")
			WebElement AddToCartLink;
			
			public String AddToCartLinkGetText()
			{
				String ActualCount = AddToCartLink.getText();
			    return ActualCount;
			}
	
//4--> Constructor Declare
	
	public HomePagePOMClass(WebDriver driver)
	{
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
}
