package StepDefinition;

import CommonUtility.BaseClass;
import PageObjects.BookSearch;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddItemSteps extends BaseClass{
    BookSearch bookSearch;

    @When("^user searches for \"([^\"]*)\"$")
    public void userSearchesForBookName(String  bookName) {
        bookSearch = new BookSearch(BaseClass.driver);
        bookSearch.enterBookName(bookName);
    }

    @And("clicks on search button")
    public void clicksOnSearchButton() throws InterruptedException {
        bookSearch.clickOnSearchBtn();
    }

    @And("^Clicks on first search result \"([^\"]*)\"$")
    public void clicksOnFirstSearchResult(String name) throws InterruptedException {
        bookSearch.clickOnFirstSearchResult(name);
    }

    @Then("new window should opened and Verify product details")
    public void verifyProductDetails() throws InterruptedException {
        bookSearch.verifyDetails();
    }

    @And("clicks on add to cart")
    public void clicksOnAddToCart() throws InterruptedException {
        bookSearch.clickOnAddToCart();
    }

    @Then("Navigate Back to Main window")
    public void navigateBackToMainWindow() {
        bookSearch.navigateToMainWindow();

    }


}
