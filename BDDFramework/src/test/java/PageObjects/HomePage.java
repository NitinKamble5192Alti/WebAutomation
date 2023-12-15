package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	String winHandleBefore;
	String winHandleBefore1;

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

	@FindBy(xpath = "//input[@type='password']")
	WebElement amazonPassword;

	@FindBy(id = "signInSubmit")
	WebElement btnSign;

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchInput;

	@FindBy(id = "nav-search-submit-button")
	WebElement search;

	@FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal'][normalize-space()='One Habit a Day: 31 Habits to Transform Your Life']")
	WebElement clickOnbook;

	@FindBy(id = "productTitle")
	WebElement title;

	@FindBy(xpath = "//a[contains(text(),'Ashdin Doctor')]")
	WebElement author;

	@FindBy(xpath = "//span[normalize-space()='180']")
	WebElement length;

	@FindBy(xpath = "//input[@id='add-to-cart-button' and @name='submit.add-to-cart']")
	WebElement addCart;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement btnSubmit;

	@FindBy(xpath = "//img[@alt='You Can']")
	WebElement secondBook;

	@FindBy(xpath = "//a[contains(text(),'George Matthew Adams')]")
	WebElement sAuthor;

	@FindBy(xpath = "//span[@id='productTitle']")
	WebElement bookTitle;

	@FindBy(xpath = "//span[contains(text(),'232 pages')]")
	WebElement sLength;

	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	WebElement addCart1;

	public void clickOnDropDown() {
		signInDropDown.click();
	}

	public void enterUsername(String username) {
		txtUsername.sendKeys(username);
	}

	public void clickContinue() {
		btnContinue.click();
	}

	public void enterPassword(String password) {

		amazonPassword.sendKeys(password);
	}

	public void clickOnSignIn() {
		btnSign.click();
	}

	public void clickSubmit() {
		btnSubmit.click();
	}

	public void clickOnSearch() {
		searchInput.click();
	}

	public void enterBook1(String bookName) {
		searchInput.sendKeys(bookName);
	}

	public void searchClick() {
		search.click();
	}

	public void searchClickOnBook() {
		winHandleBefore = driver.getWindowHandle();
		clickOnbook.click();
	}

	public void getBookDetails() {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		System.out.println("Book title is: " + title.getText());
		System.out.println("Book author is: " + author.getText());
		// System.out.println("Book length is: "+length.getText()+"Pages");
	}

	public void addCart() {
		addCart.click();
		driver.close();
	}

	public void navigateBack() {
		driver.switchTo().window(winHandleBefore);
		driver.navigate().back();
	}

	public void chooseBook() {
		winHandleBefore1 = driver.getWindowHandle();
		secondBook.click();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		System.out.println("Book title is: " + bookTitle.getText());
		System.out.println("Book author is: " + sAuthor.getText());
		System.out.println("Book length is: " + sLength.getText());
		addCart1.click();
		driver.close();
		driver.switchTo().window(winHandleBefore1);
		driver.navigate().back();
	}

}