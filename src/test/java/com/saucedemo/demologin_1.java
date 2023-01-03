package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demologin_1 {
	
	

	WebDriver driver;
	
	@BeforeTest
	public void LaunchBrowser() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.saucedemo.com/");
	}
	
	@Test		
	public void login() throws InterruptedException
	
	{	Thread.sleep(2000);					
		WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
		username.sendKeys("standard_user");
		
		Thread.sleep(2000);
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("secret_sauce");
		
		Thread.sleep(2000);
		WebElement login = driver.findElement(By.xpath("//input[@id='login-button']"));
		login.click();
		
		Thread.sleep(2000);
		
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Swag Labs";
		
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		
		}

}
