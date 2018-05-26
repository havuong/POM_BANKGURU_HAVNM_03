package com.liveguru.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import liveguru.pages.DashboardPagePO;
import liveguru.pages.HomePagePO;
import liveguru.pages.LoginPagePO;
import liveguru.pages.PageFactoryManager;

public class Login_01_Validation extends AbstractTest {
	WebDriver driver;
	private String emailInvalid, passwordInvalid, passwordIncorrect, emailVaid, passwordValid, emailPasswordErrorEmpty,
			emailErrorInvalid, passwordErrorInvalid, passwordErrorIncorrect;
	private LoginPagePO loginPage;
	private HomePagePO homePage;
	private DashboardPagePO dashboardPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String url) {
		emailInvalid = "1234567@1234.1234";
		passwordInvalid = "12345";
		passwordIncorrect = "123456";
		emailVaid = "automationvalid@gmail.com";
		passwordValid = "111111";
		emailPasswordErrorEmpty = "This is a required field.";
		emailErrorInvalid = "Please enter a valid email address. For example johndoe@domain.com.";
		passwordErrorInvalid = "Please enter 6 or more characters without leading or trailing spaces.";
		passwordErrorIncorrect = "Invalid login or password.";

		driver = openMultiBrowser(browser, url);
		homePage = PageFactoryManager.getHomePage(driver);
		loginPage = homePage.clickMyAccountLink();
	}

	@Test
	public void TC_01_EmailAndPasswordEmpty() {
		loginPage.inputToEmailTextbox("");
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();
		Assert.assertEquals(emailPasswordErrorEmpty, loginPage.getErrorMesseageIncaseEmailEmpty());
		Assert.assertEquals(emailPasswordErrorEmpty, loginPage.getErrorMesseageIncasePasswordEmpty());
	}

	@Test
	public void TC_02_EmailInvalid() {
		loginPage.inputToEmailTextbox(emailInvalid);
		loginPage.inputToPasswordTextbox(passwordValid);
		loginPage.clickToLoginButton();
		Assert.assertEquals(emailErrorInvalid, loginPage.getErrorMesseageIncaseEmailInvalid());
	}

	@Test
	public void TC_03_PasswordLessThan6Characters() {
		loginPage.inputToEmailTextbox(emailInvalid);
		loginPage.inputToPasswordTextbox(passwordInvalid);
		loginPage.clickToLoginButton();
		Assert.assertEquals(passwordErrorInvalid, loginPage.getErrorMesseageIncasePasswordInvalid());
	}

	@Test
	public void TC_04_PasswordIncorrect() {
		loginPage.inputToEmailTextbox(emailVaid);
		loginPage.inputToPasswordTextbox(passwordIncorrect);
		loginPage.clickToLoginButton();
		Assert.assertEquals(passwordErrorIncorrect, loginPage.getErrorMesseageIncasePasswordIncorrect());
	}

	@Test
	public void TC_05_EmailPasswordValid() {
		loginPage.inputToEmailTextbox(emailVaid);
		loginPage.inputToPasswordTextbox(passwordValid);
		loginPage.clickToLoginButton();
		dashboardPage = PageFactoryManager.getDashboardPage(driver);
		Assert.assertTrue(dashboardPage.isDashboardDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
