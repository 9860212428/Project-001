package com.SauceDemo.UtilityPackage;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass 
{
  public static void GetSceenshot(WebDriver driver, String name) throws IOException 
  {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);

		File Dest = new File("./Screenshots/"+name+".jpg");

		FileHandler.copy(Source, Dest);
	}
}
