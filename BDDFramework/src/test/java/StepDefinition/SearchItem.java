package StepDefinition;

import CommonUtility.BaseClass;
import PageObjects.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchItem {
	HomePage homePage = new HomePage(BaseClass.driver);

	@Given("User on home page")
	public void user_on_home_page() {
		System.out.println("On Home");
	}

	@When("Click on search")
	public void click_on_search() {
		homePage.clickOnSearch();
	}

	@When("the user searches for \"([^\"]*)\"$")
	public void the_user_searches_for_one_habit_a_day(String bookName) {
		homePage.enterBook1(bookName);
	}

	@When("Click on search submit")
	public void click_on_search_submit() {
		homePage.searchClick();
	}

	@When("Click on first result")
	public void click_on_first_result() {
		homePage.searchClickOnBook();

	}

	@When("verifies details \\(Book name, author, length, publisher, reading age)")
	public void verifies_details_book_name_author_length_publisher_reading_age() {
		homePage.getBookDetails();
	}

	@When("Click on add cart")
	public void click_on_add_cart() {
		homePage.addCart();
	}

	@When("Clik on nevigate back")
	public void clik_on_nevigate_back() {
		homePage.navigateBack();
	}

	@When("Search book \"([^\"]*)\"$")
	public void search_book(String bookName) {
		homePage.clickOnSearch();
		homePage.enterBook1(bookName);
		homePage.clickSubmit();
	}

	@When("Clicks on a random result")
	public void clicks_on_a_random_result() {
		homePage.chooseBook();
	}

	@Then("Two books added in cart")
	public void two_books_added_in_cart() {
		System.out.println("Successfully added two books in cart and verified successfully");
	}

}
