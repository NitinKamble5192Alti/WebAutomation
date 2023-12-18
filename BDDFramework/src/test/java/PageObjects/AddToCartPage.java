package PageObjects;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class AddToCartPage {
WebDriver driver;
public AddToCartPage(WebDriver driver) {
this.driver = driver;
PageFactory.initElements(driver, this);
}

String resultsWindow;
String homeWindow;

@FindBy(id = "twotabsearchtextbox")
WebElement searchBox;
@FindBy(id = "nav-search-submit-button")
WebElement btnSearch;
@FindBy(xpath = "(//span[@class=\"a-size-medium a-color-base a-text-normal\"])[1]")
WebElement resultBook1;
@FindBy(xpath = "//h1[@id=\"title\"]")
WebElement title;
@FindBy(xpath = "(//a[@class=\"a-link-normal\"])[16]")
WebElement author;
@FindBy(id = "nav-logo-sprites")
WebElement logo;

@FindBy(xpath = "(//span[@id=\"submit.add-to-cart\"])[1]")
WebElement btnAddToCart;

@FindBy(xpath="//span[@id='sc-buy-box-ptc-button']")
WebElement btnCheckOut;

@FindBy(xpath="//span[@id=\"orderSummaryPrimaryActionBtn\"]")
WebElement btnForAddress;



public void enterBookName(String bookName){
homeWindow = driver.getWindowHandle();
searchBox.sendKeys(bookName);
}
public void clickOnSearchBtn(){
btnSearch.click();
}
public void clickOnFirstSearchResult(){
resultsWindow = driver.getWindowHandle();
resultBook1.click();
}
public void verifyDetails(){
for (String windows: driver.getWindowHandles()) {
driver.switchTo().window(windows);
}
}
public void clickOnAddToCart(){
JavascriptExecutor jse = (JavascriptExecutor) driver;
jse.executeScript("window.scrollBy(0,700)");
btnAddToCart.click();
}
public void clickOnCheckOut() {
JavascriptExecutor jse = (JavascriptExecutor) driver;
jse.executeScript("window.scrollBy(0,300)");
btnCheckOut.click();
}
public void clickOnAddress() {
JavascriptExecutor jse = (JavascriptExecutor) driver;
jse.executeScript("window.scrollBy(0,200)");
btnForAddress.click();
}
public void navigateToMainWindow(){
driver.navigate().back();
logo.click();
}
}