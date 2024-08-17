package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	
	public WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By cartBag = By.cssSelector("[alt='Cart']");
	By checkoutBtn = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By promocode = By.cssSelector(".promoBtn");
	By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");
	
	public void checkoutItems() {
		driver.findElement(cartBag).click();
		driver.findElement(checkoutBtn).click();
	}
	
	public boolean verifyPromoBtn() {
		
		return driver.findElement(promocode).isDisplayed();
	}
	
	public Boolean verifyPlaceOrder() {
		return driver.findElement(placeOrder).isDisplayed();
	}
}
