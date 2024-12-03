package definition.steps;

import org.openqa.selenium.WebDriver;

import browser.setup.BrowserFactory;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;

public class Hooks {
public static WebDriver driver;
	@Before("@kids")
	public static void i_open_firefox_browser() {
		BrowserFactory.setUpBrowser("Firefox");
		driver = BrowserFactory.getDriver();
	}
	@Before("@fileupload")
	public static void setUp() {
		BrowserFactory.setUpBrowser("Edge");
		driver = BrowserFactory.getDriver();
	}
	static WebDriver getDriver() {
		return driver;
	}
	@AfterAll()
	public static void tearDown() {
		driver.quit();
	}
}