package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v125.css.CSS.GetInlineStylesForNodeResponse;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.PageObjectManagers;

public class TestContextSetup {

//	public WebDriver driver;
	public String parentWindow;
	public String shortName;
	public String productName;
	public WebDriverWait wait;
	public GenericUtils genericUtils;
	
	public TestBase testBase;
	public PageObjectManagers pageObjectManager;
	
	public TestContextSetup() throws IOException {
		testBase = new TestBase();
		pageObjectManager = new PageObjectManagers(testBase.WebDriverManager());
		genericUtils = new GenericUtils(testBase.WebDriverManager());
	}
	
}
