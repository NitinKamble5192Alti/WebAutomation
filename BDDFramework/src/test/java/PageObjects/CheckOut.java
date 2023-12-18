package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOut {

	WebDriver driver;
	String winHandleBefore;
	String winHandleBefore1;

	public CheckOut(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='nav-cart-count-container']")
	WebElement addCart;

	@FindBy(xpath = "//input[@name=\"proceedToRetailCheckout\"]")
	WebElement proceedToBuy;

	@FindBy(xpath = "//a[@id='add-new-address-popover-link']")
	WebElement addAddress;

	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressFullName']")
	WebElement fullName;

	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressPhoneNumber']")
	WebElement phoneNumber;

	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressPostalCode']")
	WebElement pincode;
	// input[@id='address-ui-widgets-enterAddressLine1']

	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressLine1']")
	WebElement address;

	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressLine2']")
	WebElement street;

	@FindBy(xpath = "//input[@aria-labelledby='address-ui-widgets-form-submit-button-announce']")
	WebElement submit;

	@FindBy(xpath = "//div[@class='a-fixed-left-grid-col a-col-right']")
	WebElement payment;

	// i[@class='a-icon a-icon-logo clickable-heading']
	@FindBy(xpath = "//i[@class='a-icon a-icon-domain-in a-icon-domain clickable-heading']")
	WebElement icon;

//    @FindBy(xpath = "//span[@class='a-declarative']//div[@class='a-row']")
//    WebElement iconA;
//    
//    @FindBy(xpath = "//i[@role='img'][1]")
//    WebElement iconAam;

	@FindBy(xpath = "//a[@role='button']")
	WebElement returnCart;

	@FindBy(xpath = "//img[@alt='You Can, Opens in a new tab']")
	WebElement firstItem;

	@FindBy(xpath = "//img[@alt='One Habit a Day: 31 Habits to Transform Your Life, Opens in a new tab']")
	WebElement secondItem;

	@FindBy(xpath = "//i[@class='a-icon a-icon-logo clickable-heading']")
	WebElement amazonLogo;

	@FindBy(xpath = "//a[contains(text(),'Return to Cart ')]")
	WebElement btnReturnToCart;

	public void addCart() {
		addCart.click();
	}

	public void ProceedToBuy() {
		proceedToBuy.click();
	}

	public void addNewAddress() {
		WebElement element = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='add-new-address-popover-link']")));
		addAddress.click();
	}

	public void addDetails1(String name, String number) {
		fullName.sendKeys(name);
		phoneNumber.sendKeys(number);
	}

	public void addDetails2(String pin, String flatNo, String area) {
		pincode.sendKeys(pin);
		address.sendKeys(flatNo);
		street.sendKeys(area);
		submit.click();
	}

	public void verifyPaymentOption() {
		boolean isDisplay = payment.isDisplayed();
		if (isDisplay == true) {
			System.out.println("Payment option is display");
		} else {
			System.out.println("Payment option is not display");
		}
	}

	public void clickOnIcon() {
		amazonLogo.click();
	}

	public void returnToCart() {

		WebElement element = (new WebDriverWait(driver, 40))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@role='button']")));
		returnCart.click();
	}

	public void verifyItems() {
		boolean item1 = firstItem.isDisplayed();
		boolean item2 = secondItem.isDisplayed();
		if (item1 == true && item2 == true) {
			System.out.println("Both the item present in Cart");
		} else {
			System.out.println("Items are not present");
		}
	}

	public void clickOnLogoAndReturnToCart() {

		// By buttonLocator = By.xpath("//a[contains(text(),'Return to Cart ')]");
		amazonLogo.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLocator));
		btnReturnToCart.click();

	}

}
