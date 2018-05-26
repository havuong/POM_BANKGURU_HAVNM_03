package liveguru.pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import liveguru.HomePageUI;

public class HomePagePO extends AbstractPage {
	WebDriver driver;
	
	public HomePagePO(WebDriver driver_){
		this.driver = driver_;
	}

	public LoginPagePO clickMyAccountLink() {
		waitForControlVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageFactoryManager.getLoginPage(driver);
	}
}
