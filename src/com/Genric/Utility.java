package com.Genric;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utility 
{
	public static void Selectdropdown(WebDriver driver, WebElement element,String text) throws InterruptedException {
		Select s=new Select(element);
		s.selectByVisibleText(text);
		Thread.sleep(2000);
		
	}

}
