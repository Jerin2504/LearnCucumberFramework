package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public WebDriver driver;

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
		return driver;

	}

}
