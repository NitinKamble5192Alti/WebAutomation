package PageObjects;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.logging.XMLFormatter;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@id='nav-cart']")
    WebElement btnCart;

    @FindBy(xpath = "//input[@name='proceedToRetailCheckout']")
    WebElement btnCheckout;

    @FindBy(xpath = "//a[@id='add-new-address-popover-link']")
    WebElement addAddressLink;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressFullName']")
    WebElement txtName;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressPhoneNumber']")
    WebElement txtMobNo;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressPostalCode']")
    WebElement txtPincode;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressLine1']")
    WebElement txtAddress;

    @FindBy(xpath = "//input[@aria-labelledby='address-ui-widgets-form-submit-button-announce']")
    WebElement btnUseAddress;

    @FindBy(xpath = "//div[@class='a-row a-spacing-mini pmts-instrument-headings']")
    WebElement lblPayment;

    @FindBy(xpath = "//i[@class='a-icon a-icon-logo clickable-heading']")
    WebElement amazonLogo;

    @FindBy(xpath = "//a[contains(text(),'Return to Cart ')]")
    WebElement btnReturnToCart;

    @FindBy(xpath = "//h1[contains(text(),'Shopping Cart')]")
    WebElement lblShoppingCart;

    @FindBy(xpath = "//span[contains(text(),'You Can') and @class='a-truncate-full a-offscreen']")
    WebElement bookName1;

    @FindBy(xpath = "//span[contains(text(),'One') and @class='a-truncate-full a-offscreen']")
    WebElement bookName2;


    @FindBy(xpath = "(//span[@class='a-text-bold'])[1]")
    WebElement lblPaymentOption1;

    @FindBy(xpath = "(//span[@class='a-text-bold'])[2]")
    WebElement lblPaymentOption2;

    @FindBy(xpath = "//span[@class='a-color-base a-text-bold']")
    WebElement lblPaymentOption3;

    public void clickOnMyCart(){
        btnCart.click();
    }

    public void clickOnCheckout(){
        btnCheckout.click();
    }

    public void clickOnAddAddress(){
        addAddressLink.click();
    }

    public void addAddressDetails(String arg0, String arg1, int arg2, String arg3) throws InterruptedException {

        String pincode = String.valueOf(arg2);
        String house = String.valueOf(arg3);

        txtName.sendKeys(arg0);
        txtMobNo.sendKeys(arg1);
        txtPincode.sendKeys(pincode);
        txtAddress.sendKeys(house);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,200)");
        Thread.sleep(3000);
        btnUseAddress.click();
    }

    public void isPaymentMethodsDisplayed() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.visibilityOf(lblPayment));
        Thread.sleep(10000);
        if (lblPayment.isDisplayed())
            System.out.println("Available Payment Methods: "+lblPaymentOption1.getText()+" "+lblPaymentOption2.getText()+" "+lblPaymentOption3.getText());
        else
            throw new NoSuchElementException("Payment Methods Are Not Displayed!");

    }

    public void clickOnLogoAndReturnToCart(){

       // By buttonLocator = By.xpath("//a[contains(text(),'Return to Cart ')]");
        amazonLogo.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLocator));
        btnReturnToCart.click();

    }
    public void isMyCartDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        if (lblShoppingCart.isDisplayed()) {
            System.out.println("Items Added To Cart: " +bookName1.getText()+ " , " + bookName2.getText());
            System.out.println("CheckOut Process Is Completed... Items Added Successfully!");
        }else
            throw new NoSuchElementException("Something Went Wrong!");

        System.out.println("Exiting!");

    }



}
