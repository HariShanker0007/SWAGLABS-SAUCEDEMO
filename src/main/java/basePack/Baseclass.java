package basePack;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
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
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import genutil.ExcelUtility;
import genutil.PropertyUtility;
import objRepo.SauceLoginPage;

public class Baseclass {
	
	/**
	 * @author Hari
	 */

	public WebDriver driver;
	public static WebDriver sdriver;

	// Create Object of Utilities
	public PropertyUtility plib = new PropertyUtility();
	public ExcelUtility elib = new ExcelUtility();

	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("Connected To DataBase", true);
	}

	@BeforeTest
	public void beforeTest() {
		Reporter.log("Pre-Conditions Satisfied", true);
	}

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(@Optional("") String BROWSER) throws Throwable {

		// Reading the data from Property file

//		// Launch the Browser
		if (BROWSER == null || BROWSER.isEmpty()) {
			BROWSER = plib.toReadDataFromPropertyFile("browser");
		}

		if (BROWSER.equalsIgnoreCase("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			//    options.addArguments("--headless=new");
			    options.addArguments("--disable-gpu");
			    options.addArguments("--no-sandbox");
			    options.addArguments("--disable-dev-shm-usage");
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
		} else if (BROWSER.equalsIgnoreCase("Edge")) {
			 EdgeOptions options = new EdgeOptions();
		        options.addArguments("--headless=new");   // ✅ REQUIRED
		        options.addArguments("--disable-gpu");
		        options.addArguments("--no-sandbox");
		        options.addArguments("--disable-dev-shm-usage");
			driver = new EdgeDriver(options);
		} else {
			driver = new FirefoxDriver();
		}
		sdriver = driver;
		System.out.println("Launched the Browser Successfully");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Reporter.log("Browser Launched", true);
	}

	@BeforeMethod
	public void beforeMethod() throws Throwable {
		String URL = plib.toReadDataFromPropertyFile("url");
		String UN = plib.toReadDataFromPropertyFile("un");
		String PW = plib.toReadDataFromPropertyFile("pwd");

		driver.get(URL);

		SauceLoginPage slp = new SauceLoginPage(driver);
		slp.toLogin(UN, PW);
		Reporter.log("Login Successfull", true);
	}

	@AfterMethod
	public void afterMethod() throws Throwable {
		driver.findElement(By.xpath("//button[.='Open Menu']")).click();
		driver.findElement(By.linkText("Logout")).click();
		Reporter.log("Logged Out Successfully", true);
	}

	@AfterClass
	public void afterClass() throws Throwable {
		driver.quit();
		Reporter.log("Closed the browser Successfully", true);
	}

	@AfterTest
	public void afterTest() {
		Reporter.log("Post-Conditions Satisfied", true);
	}

	@AfterSuite
	public void afterSuite() {
		Reporter.log("Disconnected To DataBase ", true);
	}
}
