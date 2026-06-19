package objRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceProdPage {
	WebDriver driver;

	public SauceProdPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[.='Sauce Labs Backpack']/../../..//button[.='Add to cart']")
	private WebElement backPack;

	@FindBy(xpath = "//div[.='Sauce Labs Bike Light']/../../..//button[.='Add to cart']")
	private WebElement bikeLight;

	@FindBy(xpath = "//div[.='Sauce Labs Bolt T-Shirt']/../../..//button[.='Add to cart']")
	private WebElement tShirt;

	@FindBy(xpath = "//div[.='Sauce Labs Fleece Jacket']/../../..//button[.='Add to cart']")
	private WebElement jacket;

	@FindBy(xpath = "//div[.='Sauce Labs Onesie']/../../..//button[.='Add to cart']")
	private WebElement oneSie;

	@FindBy(xpath = "//div[.='Test.allTheThings() T-Shirt (Red)']/../../..//button[.='Add to cart']")
	private WebElement Redshirt;

	@FindBy(xpath = "//a[@data-test='shopping-cart-link']")
	private WebElement cartBtn;

	public WebElement gettShirt() {
		return tShirt;
	}

	public WebElement getJacket() {
		return jacket;
	}

	public WebElement getOneSie() {
		return oneSie;
	}

	public WebElement getRedshirt() {
		return Redshirt;
	}

	public WebElement getCartBtn() {
		return cartBtn;
	}

	public WebElement getBackPack() {
		return backPack;
	}

	public WebElement getBikeLight() {
		return bikeLight;
	}

	public void addProd2toCart() throws Throwable {
		backPack.click();
		bikeLight.click();
		cartBtn.click();
	}

	public void addProd4toCart() throws Throwable {
		backPack.click();
		bikeLight.click();
		jacket.click();
		cartBtn.click();
	}

	public void addProd6toCart() throws Throwable {
		backPack.click();
		bikeLight.click();
		tShirt.click();
		jacket.click();
		oneSie.click();
		Redshirt.click();
		cartBtn.click();
	}
}
