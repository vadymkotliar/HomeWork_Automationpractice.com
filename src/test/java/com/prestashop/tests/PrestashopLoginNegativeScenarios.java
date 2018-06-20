package com.prestashop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrestashopLoginNegativeScenarios {
    WebDriver driver;
//=========================================================
    @BeforeMethod
    public void setup() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown() {
	driver.close();
    }
//==========================================================
    @Test
    public void wrongCredentialsTest() {
	driver.get("http://automationpractice.com ");
	driver.findElement(By.className("login")).click();
	driver.findElement(By.id("email")).sendKeys("email@server.net");
	driver.findElement(By.id("passwd")).sendKeys("12345");
	driver.findElement(By.id("SubmitLogin")).click();

	Assert.assertEquals(driver.findElement(By.cssSelector("#center_column>div>ol>li")).getText(),
		"Authentication failed.");
    }
    
    
    @Test
    public void invalidEmailTest() {
	driver.get("http://automationpractice.com ");
	driver.findElement(By.className("login")).click();
	driver.findElement(By.id("email")).sendKeys("emailserver.net");
	driver.findElement(By.id("passwd")).sendKeys("12345");
	driver.findElement(By.id("SubmitLogin")).click();

	Assert.assertEquals(driver.findElement(By.cssSelector("#center_column>div>ol>li")).getText(),
		"Invalid email address.");
    }
   
    
    @Test
    public void  blankEmailTest() {
	driver.get("http://automationpractice.com ");
	driver.findElement(By.className("login")).click();
	driver.findElement(By.id("passwd")).sendKeys("12345");
	driver.findElement(By.id("SubmitLogin")).click();

	Assert.assertEquals(driver.findElement(By.cssSelector("#center_column>div>ol>li")).getText(),
		"An email address required.");
    }
    
    
    @Test
    public void  blankPasswordTest() {
	driver.get("http://automationpractice.com ");
	driver.findElement(By.className("login")).click();
	driver.findElement(By.id("email")).sendKeys("email@server.net");
	driver.findElement(By.id("SubmitLogin")).click();

	Assert.assertEquals(driver.findElement(By.cssSelector("#center_column>div>ol>li")).getText(),
		"Password is required.");
    }
    
}
