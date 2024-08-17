package stepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.PageObjectManagers;
import utils.TestContextSetup;

public class LandingPageStepDefinitions {

	TestContextSetup testContextSetup;
	PageObjectManagers pageObjectManager;
	LandingPage landingPage;
	
public LandingPageStepDefinitions(TestContextSetup testContextSetup) {
	this.testContextSetup = testContextSetup;
	landingPage = testContextSetup.pageObjectManager.getLandingPage();
}
	
	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() throws IOException {
//	    testContextSetup.driver = new ChromeDriver();
//	    testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	   
				
	}
	@When("^user search with Shortname (.+) and extracted actual name of product$")
	public void user_search_with_shortnam_and_extracted_actual_name_of_product(String shortName) {
	//	pageObjectManager = new PageObjectManagers(testContextSetup.driver);
		
		
		landingPage.searchItem(shortName);
		testContextSetup.shortName = shortName;
	//   testContextSetup.driver.findElement(By.cssSelector("input[type='search']")).sendKeys(shortName);
	//   testContextSetup.productName = testContextSetup.driver.findElement(By.xpath("//h4")).getText().split("-")[0].trim();
		testContextSetup.productName = landingPage.getProductName();
	
	}
	
	@When("Add {string} items of the selected product to cart")
	public void Add_3_items_of_the_selected_product_to_cart(String quantity) {
		landingPage.incrementquantity();
		landingPage.addToCart();
	}


}
