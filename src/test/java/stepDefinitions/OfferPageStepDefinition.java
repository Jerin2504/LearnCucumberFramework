package stepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.OffersPage;
import pageObjects.PageObjectManagers;
import utils.GenericUtils;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
	TestContextSetup testContextSetup;
	PageObjectManagers pageObjectManager;

	public OfferPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Then("^user search fro same (.+) in offers page to check the product exists$")
	public void user_search_fro_same_shortname_in_offers_page_to_check_the_product_exists(String shortName) throws IOException {

	//	pageObjectManager = new PageObjectManagers(testContextSetup.driver);
		OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();
		
		offersPage.clickTopDeals();
		// testContextSetup.driver.findElement(By.xpath("//a[text()=\"Top
		// Deals\"]")).click();

		testContextSetup.genericUtils.switchWindow();
	//	Set<String> windowHandles = testContextSetup.driver.getWindowHandles();
	//	for (String handle : windowHandles) {
	//		if (!(handle.equals(testContextSetup.parentWindow))) {
	//			testContextSetup.driver.switchTo().window(handle);
	//		}
	//	}
				testContextSetup.wait = new WebDriverWait(testContextSetup.testBase.WebDriverManager(), Duration.ofSeconds(20));
				testContextSetup.wait
						.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[id='search-field']")));

				offersPage.searchField(shortName);
				String productName = offersPage.getRowDetails();
				// testContextSetup.driver.findElement(By.cssSelector("input[id='search-field']")).sendKeys(testContextSetup.shortName);
				// List<WebElement> rowValues =
				// testContextSetup.driver.findElements(By.cssSelector("tbody>tr>td"));

				Assert.assertEquals(productName, testContextSetup.productName, "Product not found");

		
	}

}
