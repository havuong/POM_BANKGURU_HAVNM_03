package liveguru.pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import liveguru.DashboardPageUI;

public class DashboardPagePO extends AbstractPage  {
	WebDriver driver;
	
	public DashboardPagePO(WebDriver driver_){
		this.driver = driver_;
	}

	public boolean isDashboardDisplayed() {
		waitForControlVisible(driver, DashboardPageUI.MY_DASHBOARD);
		return isControlDisplayed(driver, DashboardPageUI.MY_DASHBOARD);
	}
}
