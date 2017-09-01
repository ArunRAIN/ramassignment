package com.Genric;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BasePage
{
	public WebDriver driver;
	
	@BeforeMethod
	public void precondition()
	{
		//System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		Reporter.log("Firefox :Browser Opened",true);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://online.aami.com.au/motor/pub/");
		Reporter.log("Expected Url opened :https://online.aami.com.au/motor/pub/",true);
	}
	
	@AfterMethod
	public void postcondition()
	{
		//driver.quit();
		Reporter.log("Firefox :Browser closed",true);
	}

}
