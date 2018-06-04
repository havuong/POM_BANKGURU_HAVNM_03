package bankguru.pages;

import org.openqa.selenium.WebDriver;

import bankguru.NewCustomerPageUI;
import commons.AbstractPage;

public class NewCustomerPagePO extends AbstractPage{
	WebDriver driver;

	public NewCustomerPagePO(WebDriver driver_) {
		this.driver = driver_;
	}
	public void inputCustomerName(String customerName) {
		waitForControlVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TXT);
		sendkeyToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TXT, customerName);
	}

	public void checkGender() {
		waitForControlVisible(driver, NewCustomerPageUI.GENDER_TXT);
		checkTheCheckbox(driver, NewCustomerPageUI.GENDER_TXT);
	}

	public void inputDob(String dob) {
		waitForControlVisible(driver, NewCustomerPageUI.DATE_OF_BIRTH_TXT);
		sendkeyToElement(driver, NewCustomerPageUI.DATE_OF_BIRTH_TXT, dob);
	}

	public void inputAdd(String add) {
		waitForControlVisible(driver, NewCustomerPageUI.ADD_TXT);
		sendkeyToElement(driver, NewCustomerPageUI.ADD_TXT, add);
	}

	public void inputCity(String city) {
		waitForControlVisible(driver, NewCustomerPageUI.CTIY_TXT);
		sendkeyToElement(driver, NewCustomerPageUI.CTIY_TXT, city);
	}

	public void inputState(String state) {
		waitForControlVisible(driver, NewCustomerPageUI.STATE_TXT);
		sendkeyToElement(driver, NewCustomerPageUI.STATE_TXT, state);
	}

	public void inputPIN(String pin) {
		waitForControlVisible(driver, NewCustomerPageUI.PIN_TXT);
		sendkeyToElement(driver, NewCustomerPageUI.PIN_TXT, pin);
	}

	public void inputMobile(String mobile) {
		waitForControlVisible(driver, NewCustomerPageUI.MOBILE_TXT);
		sendkeyToElement(driver, NewCustomerPageUI.MOBILE_TXT, mobile);
	}

	public void inputMail(String email) {
		waitForControlVisible(driver, NewCustomerPageUI.EMAIL_TXT);
		sendkeyToElement(driver, NewCustomerPageUI.EMAIL_TXT, email);
	}

	public void inputPassword(String pass) {
		waitForControlVisible(driver, NewCustomerPageUI.PASSWORD_TXT);
		sendkeyToElement(driver, NewCustomerPageUI.PASSWORD_TXT, pass);
	}

	public void clickToSubmit() {
		waitForControlVisible(driver, NewCustomerPageUI.MOBILE_TXT);
		clickToElement(driver, NewCustomerPageUI.SUBMIT_BTN);
	}
	public String getCustomerID() {
		waitForControlVisible(driver, NewCustomerPageUI.CUSTOMER_ID_TXT);
		return getTextElement(driver, NewCustomerPageUI.CUSTOMER_ID_TXT);
	}
}
