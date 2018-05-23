package com.bankguru.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pages.HomePagePO;
import pages.LoginPagePO;
import pages.RegisterPagePO;

public class Login_01_PageObject_CreateUserAndLogin extends AbstractTest {
	WebDriver driver;
	String username, password, loginUrl, userID, email;
	private LoginPagePO loginPage;
	private RegisterPagePO registerPage;
	private HomePagePO homePage;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browser) {
		driver = openMultiBrowser(browser);
		loginPage = new LoginPagePO(driver);
		email = "autotest" + randomData() + "@yopmail.com";
	}

	@Test
	public void TC_Login_01_CreateUser() {

		loginUrl = loginPage.getLoginPageUrl();

		loginPage.clickToHereLink();
		registerPage = new RegisterPagePO(driver);

		registerPage.inputToEmailIDTextbox(email);
		registerPage.clickToSubmitButton();
		username = registerPage.getUserIDInfo();
		password = registerPage.getPasswordInfo();
	}

	@Test
	public void TC_Login_02_LoginApp() {
		registerPage.openLoginPage(loginUrl);
		loginPage = new LoginPagePO(driver);

		loginPage.inputToUsernameTextbox(username);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToSubmitButton();

		homePage = new HomePagePO(driver);
		Assert.assertTrue(homePage.isWelcomeMessageDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
