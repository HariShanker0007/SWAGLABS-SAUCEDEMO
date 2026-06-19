package objRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InfoPage {

	WebDriver driver;

	public InfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first-name")
	private WebElement firstName;

	@FindBy(id = "last-name")
	private WebElement lastname;

	@FindBy(id = "postal-code")
	private WebElement pin;

	@FindBy(id = "continue")
	private WebElement conBtn;

	public WebElement getConBtn() {
		return conBtn;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getPin() {
		return pin;
	}

	/**
	 * 
	 * @param fn
	 * @param ln
	 * @param zip
	 */
	public void details(String fn, String ln, String zip) throws Throwable {
		firstName.sendKeys(fn);
		lastname.sendKeys(ln);
		pin.sendKeys(zip);
		conBtn.click();
	}
}
