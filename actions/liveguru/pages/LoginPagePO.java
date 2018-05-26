package liveguru.pages;

import org.openqa.selenium.WebDriver;

import liveguru.LoginPageUI;
import commons.AbstractPage;

public class LoginPagePO extends AbstractPage {
	WebDriver driver;
	
	public LoginPagePO(WebDriver driver_){
		this.driver = driver_;
	}

	public void inputToEmailTextbox(String email) {
		waitForControlVisible(driver, LoginPageUI.EMAIL_TXT);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TXT, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitForControlVisible(driver, LoginPageUI.PASSWORD_TXT);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TXT, password);
	}

	public void clickToLoginButton() {
		waitForControlVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

	public String getErrorMesseageIncaseEmailEmpty() {
		waitForControlVisible(driver, LoginPageUI.ERROR_MESSAGE_INCASE_EMAIL_EMPTY);
		return getTextElement(driver, LoginPageUI.ERROR_MESSAGE_INCASE_EMAIL_EMPTY);
	}
	
	public String getErrorMesseageIncasePasswordEmpty() {
		waitForControlVisible(driver, LoginPageUI.ERROR_MESSAGE_INCASE_PASSWORD_EMPTY);
		return getTextElement(driver, LoginPageUI.ERROR_MESSAGE_INCASE_PASSWORD_EMPTY);
	}
	
	public String getErrorMesseageIncaseEmailInvalid() {
		waitForControlVisible(driver, LoginPageUI.ERROR_MESSAGE_INCASE_EMAIL_INVALID);
		return getTextElement(driver, LoginPageUI.ERROR_MESSAGE_INCASE_EMAIL_INVALID);
	}
	
	public String getErrorMesseageIncasePasswordInvalid() {
		waitForControlVisible(driver, LoginPageUI.ERROR_MESSAGE_INCASE_PASSWORD_INVALID);
		return getTextElement(driver, LoginPageUI.ERROR_MESSAGE_INCASE_PASSWORD_INVALID);
	}
	
	public String getErrorMesseageIncasePasswordIncorrect() {
		waitForControlVisible(driver, LoginPageUI.ERROR_MESSAGE_INCASE_PASSWORD_INCORRECT);
		return getTextElement(driver, LoginPageUI.ERROR_MESSAGE_INCASE_PASSWORD_INCORRECT);
	}
}
