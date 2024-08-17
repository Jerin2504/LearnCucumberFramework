package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	public WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By search = By.cssSelector("input[type='search']");
	By productName = By.xpath("//h4");
	By incrementBtn = By.cssSelector("a.increment");
	By addToCart = By.cssSelector(".product-action button");
	
	public void searchItem(String shortName) {
		driver.findElement(search).sendKeys(shortName);
	}
	
	public String getProductName() {
		return driver.findElement(productName).getText().split("-")[0].trim();
	}
	
	public void incrementquantity() {
		driver.findElement(incrementBtn).click();
		driver.findElement(incrementBtn).click();
	}
	
	public void addToCart() {
		driver.findElement(addToCart).click();
	}

}
