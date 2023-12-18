package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//span[@class='nav-icon nav-arrow'])[2]")
	WebElement signInDropDown;

	@FindBy(id = "ap_email")
	WebElement txtUsername;

	@FindBy(id = "continue")
	WebElement btnContinue;

	@FindBy(xpath = "//input[@type='password' and @id='ap_password']")
	WebElement txtPassword;

	@FindBy(id = "signInSubmit")
	WebElement btnSign;

	public void clickOnDropDown() {
		signInDropDown.click();
	}

	public void enterUsername(String username) {
		txtUsername.sendKeys(username);
	}

	public void clickContinue() {
		btnContinue.click();
	}

	public void enterPassword(String password) throws InterruptedException {

		// Send keys to the password field
		txtPassword.sendKeys(password);

	}

	public void clickOnSignIn() {
		btnSign.click();
	}
}
