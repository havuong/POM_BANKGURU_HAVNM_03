package com.bankguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login_01_CreateUserAndLogin {
	WebDriver driver;
	String loginUrl;
	String username, password, userID;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/v4");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_Login_01_CreateUser() {
		String mail = "autotest" + randomData() + "@yopmail.com";
		loginUrl = driver.getCurrentUrl();
		driver.findElement(By.xpath("//a[contains(text(),'here')]")).click();
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(mail);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		username = driver.findElement(By.xpath("//td[contains(text(),'User ID :')]/following-sibling::td")).getText();
		password = driver.findElement(By.xpath("//td[contains(text(),'Password :')]/following-sibling::td")).getText();
		System.out.println("UserName: " + username + "/ln Password: " + password);
	}

	@Test
	public void TC_Login_02_LoginApp() {
		driver.get(loginUrl);
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//marquee[@behavior='alternate']")).isDisplayed());
		userID = driver.findElement(By.xpath("//td[contains(@style,'color: green')]")).getText();

	}

	public int randomData() {
		Random rand = new Random();
		int number = rand.nextInt(999999) + 1;
		return number;
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
