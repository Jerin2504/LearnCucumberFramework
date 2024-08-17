package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OffersPage {
	
	WebDriver driver;
	public OffersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//By topDeals = By.xpath("");
	//By searchField = By.cssSelector("");

	@FindBy(xpath = "//a[text()='Top Deals']")
	WebElement topDeals;
	
	@FindBy(css = "input[id='search-field']")
	WebElement searchField;
	
	@FindBy(css = "tbody>tr>td")
	List<WebElement> getRowDetails;
	
	public void clickTopDeals() {
		topDeals.click();
	}
	
	public void searchField(String shortName) {
		searchField.sendKeys(shortName);
	}
	
	public String getRowDetails() {
		return getRowDetails.get(0).getText();
	}
}
