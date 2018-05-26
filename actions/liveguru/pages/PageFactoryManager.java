package liveguru.pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
	private static LoginPagePO loginPage;
	private static HomePagePO homePage;
	private static DashboardPagePO dashboardPage;

	public static HomePagePO getHomePage(WebDriver driver_) {
		if (homePage == null) {
			return new HomePagePO(driver_);
		}
		return homePage;
	}

	public static LoginPagePO getLoginPage(WebDriver driver_) {
		if (loginPage == null) {
			return new LoginPagePO(driver_);
		}
		return loginPage;
	}

	public static DashboardPagePO getDashboardPage(WebDriver driver_) {
		if (dashboardPage == null) {
			return new DashboardPagePO(driver_);
		}
		return dashboardPage;
	}

}
