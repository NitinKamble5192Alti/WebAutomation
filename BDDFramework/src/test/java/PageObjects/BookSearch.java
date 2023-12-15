package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookSearch {
    WebDriver driver;

    public BookSearch(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String resultsWindow;
    String homeWindow;
    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    WebElement btnSearch;

   @FindBy(xpath = "//img[@alt='One Habit a Day: 31 Habits to Transform Your Life']")
    WebElement resultBook1;

   @FindBy(xpath = "(//span[contains(text(),'You Can')])[3]")
   WebElement resultBook2;

    @FindBy(xpath = "//h1[@id=\"title\"]")
    WebElement title;

    @FindBy(xpath = "(//a[@class=\"a-link-normal\"])[16]")
    WebElement author;

    @FindBy(id = "nav-logo-sprites")
    WebElement logo;



//    @FindBy(xpath = "//span[normalize-space()='180']")
//    WebElement length;
//
//    @FindBy(xpath = "//span[normalize-space()='Westland']")
//    WebElement publisher;
//
//    @FindBy(xpath = "//span[normalize-space()='18 years and up']")
//    WebElement age;

    @FindBy(xpath = "(//span[@id=\"submit.add-to-cart\"])[1]")
    WebElement btnAddToCart;

    public void enterBookName(String bookName){
        homeWindow = driver.getWindowHandle();
        searchBox.sendKeys(bookName);
    }

    public void clickOnSearchBtn() throws InterruptedException {
        Thread.sleep(2000);
        btnSearch.click();
    }

    public void clickOnFirstSearchResult(String name) throws InterruptedException {
        resultsWindow = driver.getWindowHandle();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        if (name.equals("One Habit a Day")) {
            js.executeScript("window.scrollBy(0,400)");
            Thread.sleep(3000);
            resultBook1.click();
        }else{
            js.executeScript("window.scrollBy(0,400)");
            Thread.sleep(3000);
            resultBook2.click();
        }

    }

    public void verifyDetails() throws InterruptedException {
        for (String windows: driver.getWindowHandles()) {
            Thread.sleep(3000);
            driver.switchTo().window(windows);
        }
        //System.out.println("Book Name: "+ title.getText()+"Author "+ author.getText()+"Pages: "+ length.getText()+" Publisher: "+ publisher.getText()+"Age: "+age.getText());
    }

    public void clickOnAddToCart() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,600)");
        Thread.sleep(3000);
        btnAddToCart.click();
    }
    public void navigateToMainWindow(){
        driver.navigate().back();
        logo.click();
    }

}
