package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.Genric.Utility;

public class CarInsurance 
{
	WebDriver driver;
	
	public CarInsurance(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(xpath="//a[text()='Comprehensive Quote']")
	private WebElement Quteclick;
	
	@FindBy(id="vehicleYearOfManufactureList")
	private WebElement yormanufrsture;
	
	@FindBy(id="vehicleMakeList")
	private WebElement carmake;
	
	@FindBy(id="vehicleModelList")
	private WebElement carmodel;
	
	@FindBy(id="vehicleTransmissionList")
	private WebElement transmissiontype;
	
	@FindBy(id="vehicleNumberOfCylindersList")
	private WebElement noofcylinders;
	
	
	@FindBy(id="vehicleBodyTypeList")
	private WebElement bodytype;
	
	
	@FindBy(id="findcar")
	private WebElement findcarbutton;
	
	@FindBy(xpath="//label[text()='2017 Holden Captiva 5 LS (FWD) CG MY16 4 Door Wagon']/../../../..")
	private WebElement selectyrcar;
	
	@FindBy(id="_eventId_submit")
	private WebElement cardetailsbutton;
	
	
	
	public void Clickquote()
	{
		Quteclick.click();
			
	}
	
	
	public void FindCar(String text,String text1,String text2,String text3,String text4,String text5) throws InterruptedException
	{
	Utility.Selectdropdown(driver, yormanufrsture, text);
	Utility.Selectdropdown(driver, carmake, text1);
	Utility.Selectdropdown(driver, carmodel, text2);
	Utility.Selectdropdown(driver, transmissiontype, text3);
	Utility.Selectdropdown(driver, noofcylinders, text4);
	Utility.Selectdropdown(driver, bodytype, text5);
	
	findcarbutton.click();
	
	}

	public void selectyourcar(String selectcar)
	{
		driver.findElement(By.xpath("//label[text()='"+selectcar+"']/../../../..")).click();
		
		cardetailsbutton.click();
	}
	
	public void driverdetails(String carfinanced,String carprimilaryused,String kilometersused) throws InterruptedException
	{
		driver.findElement(By.xpath("//span[text()='"+carfinanced+"']")).click();
		
		driver.findElement(By.xpath("//span[text()='"+carprimilaryused+"']")).click();
		
		driver.findElement(By.xpath("//span[text()='"+kilometersused+"']")).click();
		
		
		 List<WebElement>  v= driver.findElements(By.xpath("(//span[text()='No'])[2]"));
		if(v.size()==1)
		{
			driver.findElement(By.xpath("(//span[text()='No'])[2]")).click();
		}
		else
		{
			
		}
		
		driver.findElement(By.id("address.suburbPostcodeState")).sendKeys("HOMEBUSH BAY, 2127, NSW");
		
		
		driver.findElement(By.id("address.streetAddress")).sendKeys("Homebush");
		
		
	
		driver.findElement(By.id("_eventId_submit")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'10 Homebush Bay Dr')]")).click();
		
		driver.findElement(By.id("_eventId_submit")).click();
		
		
		
	}
	
	public void getmyquote(String text7) throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='sg-Date']/span/input[@placeholder='dd'])[1]")).sendKeys("02");
		driver.findElement(By.xpath("(//div[@class='sg-Date']/span/input[@placeholder='mm'])[1]")).sendKeys("02");
		driver.findElement(By.xpath("(//div[@class='sg-Date']/span/input[@placeholder='yyyy'])[1]")).sendKeys("1990");
	
	driver.findElement(By.xpath("//span[text()='Male']")).click();
	WebElement element=driver.findElement(By.id("previousInsurerList"));
	Thread.sleep(1000);
	Utility.Selectdropdown(driver, element, text7);
	//Thread.sleep(3000);
	WebElement element1=driver.findElement(By.xpath("(//span[text()='No'])[1]"));
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", element1);
	
	Thread.sleep(2000);
	WebElement j2 = driver.findElement(By.xpath("//span[text()='0']"));
	JavascriptExecutor js1 = (JavascriptExecutor)driver;
	js1.executeScript("arguments[0].click();", j2);
	
	driver.findElement(By.xpath("(//span[text()='No'])[2]")).click();
	
	
	driver.findElement(By.xpath("(//span[text()='No'])[3]")).click();
	
	driver.findElement(By.id("_eventId_submit")).click();
	}

}
