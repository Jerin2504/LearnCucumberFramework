package Listeners;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;


public class WebDriverEvents implements WebDriverListener {

	public void beforeAnyWebDriverCall(WebDriver driver, Method method, Object[] args) {
		System.out.println("Calling WebDriver :" + method.getName());
	}

	public void afterAnyWebDriverCall(WebDriver driver, Method method, Object[] args, Object result) {
		System.out.println("Called WebDriver: " + method.getName());
	}

	public void beforeGetCurrentUrl(WebDriver driver) {
		System.out.println("Entering new URL");
	}

	public void afterGetCurrentUrl(String result, WebDriver driver) {
		System.out.println("Entered new URL :" + result);
	}
	

	public void beforeFindElement(WebDriver driver, By locator) {
		System.out.println("Finding element :" + locator);
	}

	public void afterFindElement(WebDriver driver, By locator, WebElement result) {
		System.out.println("Found element :" + locator);
	}

	public void beforeClose(WebDriver driver) {
		System.out.println("Closing driver");
	}

	public void afterClose(WebDriver driver) {
		System.out.println("Driver Closed");
	}

	public void beforeQuit(WebDriver driver) {
		System.out.println("Quiting driver");
	}

	public void afterQuit(WebDriver driver) {
		System.out.println("Driver quit");
	}

	public void beforeClick(WebElement element) {
		System.out.println("Clicking WebElement :" +  element);
	}

	public void afterClick(WebElement element) {
		System.out.println("Element clicked :" + element);
	}

}
