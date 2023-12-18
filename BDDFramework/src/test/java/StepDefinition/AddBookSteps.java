package StepDefinition;

import CommonUtility.BaseClass;
import PageObjects.AddToCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddBookSteps extends BaseClass {

    AddToCartPage bookSearch;

    @When("^user searches for \"([^\"]*)\"$")
    public void userSearchesForBookName(String  bookName) {
        bookSearch = new AddToCartPage(BaseClass.driver);
        bookSearch.enterBookName(bookName);
    }

    @And("clicks on search button")
    public void clicksOnSearchButton() {
        bookSearch.clickOnSearchBtn();
    }

    @And("Clicks on first search result")
    public void clicksOnFirstSearchResult() {
        bookSearch.clickOnFirstSearchResult();
    }

    @Then("new window should opened and Verify product details")
    public void verifyProductDetails() {
        bookSearch.verifyDetails();
    }

    @And("clicks on add to cart")
    public void clicksOnAddToCart() {
        bookSearch.clickOnAddToCart();
    }

    @And("clicks on proceed to buy")
    public void clicksOnCheckOut() {
    	bookSearch.clickOnCheckOut();
    }
    @And("clicks on address")
    public void clickOnAddress() {
    	bookSearch.clickOnAddress();
    }
    @Then("Navigate Back to Main window")
    public void navigateBackToMainWindow() {
        bookSearch.navigateToMainWindow();

    }



}
 