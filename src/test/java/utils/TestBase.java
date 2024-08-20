package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.BeforeClass;





public class TestBase {

	public WebDriver driver;
	public static Logger logger;

	public WebDriver WebDriverManager() throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fis);

		String browserProperties = prop.getProperty("browser");
		String url = prop.getProperty("QAUrl");
		String browserMaven = System.getProperty("browser");

		String browser = browserMaven != null ? browserMaven : browserProperties;

		if (driver == null) {
			if (browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
				driver.get(url);
			} else if (browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
				driver.get(url);
			}
		}
		
		WebDriverListener listener = new Listeners.WebDriverEvents();
		driver = new EventFiringDecorator<WebDriver>(listener).decorate(driver);
		
		return driver;
		
		
	}
	
	@BeforeClass(groups= {"smoke"})
	public void setupLogger() {
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.ALL);

	}

}
