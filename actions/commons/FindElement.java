package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElement {
	WebDriver driver;
	
	public WebElement findElement(String locator){
		if (locator.startsWith("xpath=")){
			locator = locator.substring(6);
			WebElement element = driver.findElement(By.xpath(locator));
			return element;
		}else if (locator.startsWith("id=")){
			locator = locator.substring(3);
			WebElement element = driver.findElement(By.id(locator));
			return element;
		}else if (locator.startsWith("css=")){
			locator = locator.substring(4);
			WebElement element = driver.findElement(By.cssSelector(locator));
			return element;
		}
		return null;
	}

}
