package commons;

import org.openqa.selenium.WebDriver;

import bankguru.pages.HomePagePO;
import bankguru.pages.LoginPagePO;
import bankguru.pages.RegisterPagePO;

public class PageFactoryManager {
	private static HomePagePO homePage;
	private static LoginPagePO loginPage;
	private static RegisterPagePO registerPage;
	
	public static HomePagePO getHomePage(WebDriver driver_){
		if(homePage == null){
			return new HomePagePO(driver_);
		}
		return homePage;
	}
	
	public static LoginPagePO getLoginPage(WebDriver driver_){
		if(loginPage == null){
			return new LoginPagePO(driver_);
		}
		return loginPage;
	}
	
	public static RegisterPagePO getRegisterPage(WebDriver driver_){
		if(registerPage == null){
			return new RegisterPagePO(driver_);
		}
		return registerPage;
	}

}
