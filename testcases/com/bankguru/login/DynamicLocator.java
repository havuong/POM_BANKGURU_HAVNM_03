package com.bankguru.login;

public class DynamicLocator {

	public static void main(String[] args) {
		String locator = "//ul[@class='menusubnav']//a[text()='%s']";
		openDynamicPage(locator, "Manager");
		openDynamicPage(locator, "New Customer");
		openDynamicPage(locator, "Edit Customer");
		openDynamicPage(locator, "Delete Customer");
		openDynamicPage(locator, "New Account");
		openDynamicPage(locator, "Edit Account");
		openDynamicPage(locator, "Delete Account");
	}

	public static void openDynamicPage(String locator, String pageName) {
		locator = String.format(locator, pageName);
		System.out.println(locator);
	}

}
