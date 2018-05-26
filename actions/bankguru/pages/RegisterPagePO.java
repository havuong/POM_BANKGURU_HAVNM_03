package bankguru.pages;

import org.openqa.selenium.WebDriver;

import bankguru.RegisterPageUI;
import commons.AbstractPage;
import commons.PageFactoryManager;

public class RegisterPagePO extends AbstractPage{
	WebDriver driver;
	
	public RegisterPagePO(WebDriver driver_){
		this.driver = driver_;
	}
	
	public void inputToEmailIDTextbox(String email) {
		waitForControlVisible(driver, RegisterPageUI.EMAILID_TXT);
		sendkeyToElement(driver, RegisterPageUI.EMAILID_TXT, email);
	}
	
	public void clickToSubmitButton() {
		waitForControlVisible(driver, RegisterPageUI.SUBMIT_BTN);
		clickToElement(driver, RegisterPageUI.SUBMIT_BTN);
	}
	
	public String getUserIDInfo() {
		waitForControlVisible(driver, RegisterPageUI.USERID_TEXT);
		return getTextElement(driver, RegisterPageUI.USERID_TEXT);
	}
	
	public String getPasswordInfo() {
		waitForControlVisible(driver, RegisterPageUI.PASSWORD_TEXT);
		return getTextElement(driver, RegisterPageUI.PASSWORD_TEXT);
	}
	
	public LoginPagePO openLoginPage(String loginPageUrl) {
		openAnyUrl(driver, loginPageUrl);
		return PageFactoryManager.getLoginPage(driver);
	}
}
