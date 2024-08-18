package definition.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TutorialSteps {
	static WebDriver driver;
	public Select select;
	
	@BeforeAll
	public static void setUp() {
		WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
		driver = new EdgeDriver(options);
	}
	@Given("I am in the dropdown test application")
	public void i_am_in_the_test_application() {
		driver.get("https://practice.expandtesting.com/dropdown");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(10000));
	}
		
	@When("I select an element from dropdown")
	public void i_select_an_element_from_dropdown() throws InterruptedException {
		WebElement dropdown = driver.findElement(By.id("dropdown"));
		select = new Select(dropdown);
	    select.selectByVisibleText("Option 2");   
	   
	}
	@Then("I validate the selection")
	public void i_validate_the_selection() throws InterruptedException {
	    System.out.println(select.getFirstSelectedOption().getText());
	}
	

	@Given("I am in the file upload test application")
	public void i_am_in_the_file_upload_test_application() {
		driver.get("https://practice.expandtesting.com/upload");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(10000));
	}
	@When("I upload the file")
	public void i_click_on_the_choose_file_button() {
	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		WebElement upload = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='fileInput']"))));
		upload.sendKeys("C:\\Users\\binit\\Downloads\\Photo.jpg");
		try {
		 WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'alert')]")));
		 if(alert.isDisplayed())
			 System.out.println(alert.getText());
			 Assert.assertFalse("File cannot be uploaded", true);
		}catch(org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Good to go!!");
		}catch(org.openqa.selenium.TimeoutException e) {
			System.out.println("Good to go!!");
		}
	 
	}
	@When("I click on submit")
	public void i_upload_the_file_and_submit() {
		  
        WebElement uploadbtn = driver.findElement(By.id("fileSubmit"));
        uploadbtn.click();
	    
	}
	@Then("I validate the file selection")
	public void i_validate_the_file_selection() {
		
		WebElement successtxt = driver.findElement(By.xpath("//*[contains(text(),'File Uploaded')]"));		
		System.out.println(successtxt.getText());
		
	}
	@AfterAll()
	public static void tearDown() {
		driver.quit();
	}
}