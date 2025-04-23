package browser.setup;


import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	public static WebDriver driver;
	static String browser;
	public static void setUpBrowser() {
		try {
		File f = new File("./config.properties");
		FileInputStream fis = new FileInputStream(f);
		Properties properties = new Properties();
		properties.load(fis);
		browser = properties.getProperty("browserType");

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(browser.equalsIgnoreCase("Chrome")){
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			driver = new ChromeDriver(options);
		}
		if(browser.equalsIgnoreCase("Edge")){
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			driver = new EdgeDriver(options);
		}
		if(browser.equalsIgnoreCase("Firefox")){
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			driver = new FirefoxDriver(options);
		}
	}
	public static void setUpBrowser(String browser) {
		if(browser.equalsIgnoreCase("Chrome")){
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			driver = new ChromeDriver(options);
		}
		if(browser.equalsIgnoreCase("Edge")){
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			driver = new EdgeDriver(options);
		}
		if(browser.equalsIgnoreCase("Firefox")){
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			driver = new FirefoxDriver(options);
		}
	}
	public static void setUpRemoteBrowser(String browser) {
		try {
			File f = new File("./config.properties");
			FileInputStream fis = new FileInputStream(f);
			Properties properties = new Properties();
			properties.load(fis);
	
			DesiredCapabilities capabilities = new DesiredCapabilities();	
			capabilities.setBrowserName(browser);
			String baseURL = properties.getProperty("remoteURL");
			driver = new RemoteWebDriver((new URI(baseURL)).toURL(), capabilities);
			
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			catch(Exception e)
			{
				e.printStackTrace();
			}
				}
	

	
	public static WebDriver getDriver() {
		return driver;
	}
}