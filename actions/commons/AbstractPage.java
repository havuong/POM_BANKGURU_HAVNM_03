package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import bankguru.AbstractPageUI;
import bankguru.pages.DeleteCustomerPagePO;
import bankguru.pages.EditCustomerPagePO;
import bankguru.pages.HomePagePO;
import bankguru.pages.LoginPagePO;
import bankguru.pages.NewCustomerPagePO;
import bankguru.pages.PageFactoryManager;

public class AbstractPage {

	public void openAnyUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getTitlePage(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void back(WebDriver driver) {
		driver.navigate().back();
	}

	public void forward(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void clickToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void clickToElement(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String value) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(value);
	}

	public String getFirstItemSelected(WebDriver driver, String locator) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		return select.getFirstSelectedOption().getText();
	}

	public String getAttributeValue(WebDriver driver, String locator, String attribute) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attribute);
	}

	public String getTextElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public int getSize(WebDriver driver, String locator) {
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		return elements.size();
	}

	public void checkTheCheckbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckTheCheckbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isControlDisplayed(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isControlDisplayed(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isControlEnabled(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	public boolean isControlSelected(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}

	public void acceptAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void cancelAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void sendkeyToAlert(WebDriver driver, String value) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
		alert.accept();
	}

	public void switchWindowByID(WebDriver driver, String locator, String value) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWindow = driver.findElement(By.id(locator)).getAttribute("id");
			if (currentWindow.equals(value)) {
				break;
			}
		}
	}

	public void switchWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWindow = driver.getTitle();
			if (currentWindow.equals(title)) {
				break;
			}
		}
	}

	public void switchToIframe(WebDriver driver, String locator) {
		WebElement iframe = driver.findElement(By.xpath(locator));
		driver.switchTo().frame(iframe);
	}

	public void doubleClick(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	public void hoverMouse(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void rightClick(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	public void dragAndDrop(WebDriver driver, String locatorSource, String locatorTarget) {
		WebElement sourceElement = driver.findElement(By.xpath(locatorSource));
		WebElement targetElement = driver.findElement(By.xpath(locatorTarget));
		Actions action = new Actions(driver);
		action.dragAndDrop(sourceElement, targetElement).build().perform();
	}

	public void keyPress(WebDriver driver, Keys withKey) {
		Actions action = new Actions(driver);
		action.sendKeys(withKey).build().perform();
	}

	public void uploadFile(WebDriver driver, String locator, String filePath) {
		WebElement element = driver.findElement(By.xpath("//input[@type='file']"));
		element.sendKeys(filePath);
	}

	public Object executeJavascriptToBrowser(WebDriver driver, String javaScript) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript(javaScript);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object executeJavascriptToElement(WebDriver driver, String javaScript, WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript(javaScript, element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void hightlightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='6px groove red'", element);
	}

	public void removeAttributeOfElement(WebDriver driver, WebElement element, String attribute) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('" + attribute + "')", element);
	}

	public boolean checkAnyImageLoaded(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (boolean) js.executeScript("return arguments[0].complete && "
				+ "typeof arguments[0].naturalWidth != 'underined' && arguments[0].naturalWidth > 0", element);
	}

	public void waitForControlPresence(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForControlClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForControlNotVisible(WebDriver driver, String locator) {
		By by = By.xpath(locator);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	public void waitForAlertPresence(WebDriver driver) {
		new WebDriverWait(driver, 60).ignoring(NoAlertPresentException.class)
				.until(ExpectedConditions.alertIsPresent());
	}

	public void waitForControlVisible(WebDriver driver, String locator) {
		By by = By.xpath(locator);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitForControlVisible(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		By by = By.xpath(locator);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public NewCustomerPagePO openNewCustomerPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "New Customer");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "New Customer");
		return PageFactoryManager.getNewCustomerPage(driver);
	}

	public EditCustomerPagePO openEditCustomerPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Edit Customer");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Edit Customer");
		return PageFactoryManager.getEditCustomerPage(driver);
	}

	public DeleteCustomerPagePO openDeleteCustomerPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Delete Customer");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Delete Customer");
		return PageFactoryManager.getDeleteCustomerPage(driver);
	}

	public HomePagePO openHomePage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Manager");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Manager");
		return PageFactoryManager.getHomePage(driver);
	}
	
	public LoginPagePO openLogOutPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Log out");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Log out");
		acceptAlert(driver);
		waitForControlVisible(driver, AbstractPageUI.LOGIN_FORM_LINK);
		return PageFactoryManager.getLoginPage(driver);
	}
}
