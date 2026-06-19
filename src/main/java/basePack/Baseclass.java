package basePack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import genutil.ExcelUtility;
import genutil.PropertyUtility;
import objRepo.SauceLoginPage;

public class Baseclass {

	public static WebDriver driver;

	// Create Object of Utilities
	public PropertyUtility plib = new PropertyUtility();
	public ExcelUtility elib = new ExcelUtility();
	
	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("Connected To DataBase ",true);
	}
	
	@BeforeTest
	public void beforeTest() {
		Reporter.log("Pre-Conditions Satisfied",true);
	}
	

	@BeforeClass
	public void beforeClass() throws Throwable {

		// Reading the data from Property file
		String BROWSER = plib.toReadDataFromPropertyFile("browser");

		// Launch the Browser
		if (BROWSER.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		System.out.println("Launched the Browser Successfully");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Reporter.log("Browser Launched",true);
	}

	@BeforeMethod
	public void beforeMethod() throws Throwable {
		String URL = plib.toReadDataFromPropertyFile("url");
		String UN = plib.toReadDataFromPropertyFile("un");
		String PW = plib.toReadDataFromPropertyFile("pwd");

		driver.get(URL);

		SauceLoginPage slp = new SauceLoginPage(driver);
		slp.toLogin(UN, PW);
		Reporter.log("Login Successfull",true);
	}

	@AfterMethod
	public void afterMethod() throws Throwable {
		driver.findElement(By.xpath("//button[.='Open Menu']")).click();
		driver.findElement(By.linkText("Logout")).click();
		Reporter.log("Logged Out Successfully",true);
	}

	@AfterClass
	public void afterClass() throws Throwable {
		driver.quit();
		Reporter.log("Closed the browser Successfully",true);
	}
	
	@AfterTest
	public void afterTest() {
		Reporter.log("Post-Conditions Satisfied",true);
	}
	
	@AfterSuite
	public void afterSuite() {
		Reporter.log("Disconnected To DataBase ",true);
	}
}
