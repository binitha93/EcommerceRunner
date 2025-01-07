package definition.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;


import java.time.Duration;
import java.util.List;

import io.cucumber.java.BeforeAll;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import browser.setup.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import definition.steps.Hooks;

public class StepDefinitions {
	public StepDefinitions(){
		this.driver =Hooks.getDriver();
		}
	WebDriver driver;
	String searchString;
	String filterName;
	String idealForXpath = "//section//div//div[text() = 'Ideal for']";
	String searchBoxXpath= "//input[contains(@title,'Search for Products')]";
	String loginpopupcloseXpath = "//div/span[text()='Login']/ancestor::div/span[@role='button']";
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	

	@Given("I am in e-commerce application")
	public void i_am_in_e_commerce_application() {
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
	}
	@Given("I dismiss login popup")
	public void i_dismiss_login_popup() {
		try {
		WebElement loginpopupclose = driver.findElement(By.xpath(loginpopupcloseXpath));
		loginpopupclose.click();
		}catch(NoSuchElementException e) {
			System.out.println("Login pop up not available to close");
		}
	}
  
	@When("I search for {string}")
	public void i_search_for(String string) {
		searchString=string;
		WebElement searchbox = driver.findElement(By.xpath(searchBoxXpath));
		searchbox.sendKeys(searchString);
		searchbox.sendKeys(Keys.ENTER);
	}

	@Then("I get the search results")
	public void i_get_the_search_results() {	
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'results for')]")));
		} catch (Exception e) {
			System.out.println("Search results not displayed");
			assertTrue(Boolean.FALSE, "Search results not displayed");
		}
		System.out.println("Search results displayed");
	}
	
	@When("I check the checkbox {string}")
	public void i_check_the_checkbox(String filter) {
		filterName = filter;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(idealForXpath)));
		WebElement idealForSection = driver.findElement(By.xpath(idealForXpath));
		try {
			idealForSection.click();
			}catch(StaleElementReferenceException e) {
				idealForSection = driver.findElement(By.xpath(idealForXpath));
				idealForSection.click();
			}
			try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='checkbox']//following-sibling::div[text()='"+filterName+"']")));
			}catch(TimeoutException e) {
				idealForSection = driver.findElement(By.xpath(idealForXpath));
				idealForSection.click();
			}
			try {
				WebElement filterCheckbox =  driver.findElement(By.xpath("//input[@type='checkbox']//following-sibling::div[text()='"+filterName+"']"));
				filterCheckbox.click();
			}catch(NoSuchElementException e) {
				Assert.fail("The filter '"+filterName+"' not available for selection");
			}
	}
	@Then("The search should return corresponding items")
	public void the_search_should_return_corresponding_items() {
	   List<WebElement> selectedFilters = driver.findElements(By.xpath("//section//span[text()='Filters']/ancestor::div/ancestor::div/following-sibling::div//div[text()='✕']/following-sibling::div"));
	   for(WebElement ele:selectedFilters) {
		   Assert.assertTrue(ele.getText().equalsIgnoreCase(filterName));
	   }
	}


	@After("@kids")
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Failure screenshot");
		} else {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Success screenshot");
		}

	}
	


}
