package com.bankguru.login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import bankguru.pages.DeleteCustomerPagePO;
import bankguru.pages.EditCustomerPagePO;
import bankguru.pages.HomePagePO;
import bankguru.pages.LoginPagePO;
import bankguru.pages.NewCustomerPagePO;
import bankguru.pages.RegisterPagePO;
import commons.AbstractTest;
import commons.PageFactoryManager;

public class Login_01_CreateUserAndLogin extends AbstractTest {
	WebDriver driver;
	String username, password, loginUrl, userID, email;
	private LoginPagePO loginPage;
	private RegisterPagePO registerPage;
	private HomePagePO homePage;
	private NewCustomerPagePO newCustomerPage;
	private EditCustomerPagePO editCustomerPage;
	private DeleteCustomerPagePO deleteCustomerPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String url) {
		driver = openMultiBrowser(browser, url);
		loginPage = PageFactoryManager.getLoginPage(driver);
		email = "autotest" + randomData() + "@yopmail.com";
	}

	@Test
	public void TC_Login_01_CreateUser() {
		loginUrl = loginPage.getLoginPageUrl();
		registerPage = loginPage.clickToHereLink();
		registerPage.inputToEmailIDTextbox(email);
		registerPage.clickToSubmitButton();
		username = registerPage.getUserIDInfo();
		password = registerPage.getPasswordInfo();
	}

	@Test
	public void TC_Login_02_LoginApp() {
		loginPage = registerPage.openLoginPage(loginUrl);
		loginPage.inputToUsernameTextbox(username);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToSubmitButton();
		verifyTrue(homePage.isWelcomeMessageDisplayed());

		newCustomerPage = homePage.openNewCustomerPage(driver);
		editCustomerPage = newCustomerPage.openEditCustomerPage(driver);
		deleteCustomerPage = editCustomerPage.openDeleteCustomerPage(driver);
		homePage = deleteCustomerPage.openHomePage(driver);
		editCustomerPage = homePage.openEditCustomerPage(driver);
	}

	@AfterClass
	public void afterClass() {
		closeBrowser(driver);
	}

}
