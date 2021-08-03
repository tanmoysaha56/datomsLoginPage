package com.tanmoy.Datoms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class baseTest 
{
	@BeforeMethod
	public void beforeMethod()
	{
		initializeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void afterTest()
		{
			//driver.close();
		}
	
	WebDriver driver;
	public void initializeDriver()
	{
		String browser = Constants.browser;
		if(browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
		driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			//firefox driver
		}
		else
		{
			//default browser driver
		}
	}
	@Test
	public void loginPage()
	{
		String Url = Constants.url;
		driver.get(Url);
		driver.findElement(By.id("email")).sendKeys("emailId");
		driver.findElement(By.id("password")).sendKeys("Password");
		driver.findElement(By.id("form_submit_btn")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Forgot Password ?']")).click();
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("login_back")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Back to login']")).click();
		
	}

}
