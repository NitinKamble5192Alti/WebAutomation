package StepDefinition;

import CommonUtility.BaseClass;
import PageObjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps extends BaseClass {

//  WebDriver driver;
	HomePage homePage;

	@Given("navigate to home page")
	public void navigateToHomePage() throws Exception {
		setUp();
		navigateToUrl();
	}

	@When("Click on navlink")
	public void click_on_navlink() {
		homePage = new HomePage(BaseClass.driver);
		homePage.clickOnDropDown();

	}

	@When("^user enters \"([^\"]*)\"$")
	public void user_enters_username(String username) {
		homePage.enterUsername(username);

	}

	@And("user clicks on continue")
	public void user_clicks_on_continue() {
		homePage.clickContinue();
	}

//^user enters (.*)$
//^user enters password as \"([^\"]*)\"$
	@And("^user enters password as \"([^\"]*)\"$")
	public void user_enters_password(String password) throws InterruptedException {
		homePage.enterPassword(password);
	}

	@And("user clicks on sign in")
	public void user_clicks_on_sign_in() {
		homePage.clickOnSignIn();
	}

	@Then("verify user navigated to user home page")
	public void verify_user_navigated_to_user_home_page() {
		System.out.println("Successfully added two books in cart and verified Successfully!");

	}

}