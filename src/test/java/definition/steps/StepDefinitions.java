package definition.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitions {
	static WebDriver driver;
	@BeforeAll
	public static void setUp() {
		WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
		driver = new EdgeDriver(options);
	}
	@Given("I am in e-commerce application")
	public void i_am_in_e_commerce_application() {
	  driver.get("https://www.flipkart.com/");
	  driver.manage().window().maximize();
	}
	@When("I search for {string}")
	public void i_search_for(String string) {
	   WebElement searchbox = driver.findElement(By.xpath("//input[contains(@title,'Search for Products')]"));
	   searchbox.sendKeys("kids dress");
	   searchbox.sendKeys(Keys.ENTER);
	}
	@Then("I get the search results")
	public void i_get_the_search_results() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'results for')]")));
		}catch(Exception e)
		{
			System.out.println("Search results not displayed");
			assertTrue(Boolean.FALSE,"Search results not displayed");
		}
		System.out.println("Search results displayed");
	}
	@After("@kids")
	public void afterScenario(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Failure screenshot");
		}
		else {
			byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Success screenshot");
		}
		
	}
	
	@AfterAll()
	public static void tearDown() {
		driver.quit();
	}

}
