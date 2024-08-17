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

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import pageObjects.PageObjectManagers;
import utils.TestContextSetup;

public class CheckoutPageStepDefinitions {

	TestContextSetup testContextSetup;
	PageObjectManagers pageObjectManager;
	public CheckoutPage checkoutPage;

	public CheckoutPageStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
	}

	@Then("user proceeds to checkout and validates the item in checkout page")
	public void user_proceeds_to_checkout_and_validates_the_item_in_checkout_page() {
		
		checkoutPage.checkoutItems();
	}

	@Then("verify user has provision to apply promocode")
	public void verify_user_has_provision_to_apply_promocode() {
		
		Assert.assertTrue(checkoutPage.verifyPromoBtn());
		Assert.assertTrue(checkoutPage.verifyPlaceOrder());
	}

}
