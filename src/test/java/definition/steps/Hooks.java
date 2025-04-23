package definition.steps;


import org.openqa.selenium.WebDriver;

import browser.setup.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {
public static ThreadLocal <WebDriver> driver = new ThreadLocal<>();
public static ThreadLocal <String> browser = new ThreadLocal<>();
	@Before("@local")
	public static void setUp(Scenario scenario) {
		if(scenario.getSourceTagNames().contains("@chrome")){
			browser.set("chrome");
			BrowserFactory.setUpBrowser(browser.get());
		}
		else if(scenario.getSourceTagNames().contains("@firefox")){
			browser.set("firefox");
			BrowserFactory.setUpBrowser(browser.get());
		}
		else if(scenario.getSourceTagNames().contains("@edge")){
			browser.set("edge");
			BrowserFactory.setUpBrowser(browser.get());
		}
		else if(scenario.getSourceTagNames().contains("@opera")){
			browser.set("operablink");
			BrowserFactory.setUpBrowser(browser.get());
		}
		else
			BrowserFactory.setUpBrowser();
		driver.set(BrowserFactory.getDriver());
	}
	@Before("@remote")
	public static void remoteSetUp(Scenario scenario) {
		if(scenario.getSourceTagNames().contains("@chrome"))
			browser.set("chrome");
		else if(scenario.getSourceTagNames().contains("@firefox"))
			browser.set("firefox");
		else if(scenario.getSourceTagNames().contains("@edge"))
			browser.set("MicrosoftEdge");

		BrowserFactory.setUpRemoteBrowser(browser.get());
		driver.set(BrowserFactory.getDriver());
	}


	static WebDriver getDriver() {
		return driver.get();
	}
	@After
	public static void tearDown() {
		if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
		
	}
}