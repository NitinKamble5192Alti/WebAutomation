package StepDefinition;

import CommonUtility.BaseClass;
import PageObjects.CheckOut;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckOutSteps {
	CheckOut checkOut = new CheckOut(BaseClass.driver);

	@Given("User is on Home page")
	public void user_is_on_home_page() {
		System.out.println("User is on Home page");
	}

	@When("Clicks on cart for checkout")
	public void clicks_on_cart_for_checkout() {
		// Write code here that turns the phrase above into concrete actions
		checkOut.addCart();
	}

	@And("click on proceed to buy")
	public void click_on_proceed_to_buy() {
		// Write code here that turns the phrase above into concrete actions
		checkOut.ProceedToBuy();
	}

	@When("Clicks on add new address")
	public void clicks_on_add_new_address() {
		// Write code here that turns the phrase above into concrete actions
		checkOut.addNewAddress();
	}

	@And("Enters first and last name {string} and enter mobile number {string}")
	public void enters_first_and_last_name_and_enter_mobile_number(String name, String number) {
		// Write code here that turns the phrase above into concrete actions
		checkOut.addDetails1(name, number);
	}

	@And("Enters pincode {string} and flat no {string} and area {string}")
	public void enters_pincode_and_flat_no_and_area(String pincode, String flatNo, String area) {
		// Write code here that turns the phrase above into concrete actions
		checkOut.addDetails2(pincode, flatNo, area);
	}

	@And("Verify payment options are displayed")
	public void verify_payment_options_are_displayed() {
		// Write code here that turns the phrase above into concrete actions
		checkOut.verifyPaymentOption();
	}

	@When("clicks on the Amazon.in icon")
	public void clicks_on_the_amazon_in_icon() {
		checkOut.clickOnIcon();
//		checkOut.clickOnLogoAndReturnToCart();

	}

	@And("clicks on the Cart option")
	public void clicks_on_the_cart_option() {
		checkOut.returnToCart();
	}

	@And("Verify both items are present in cart")
	public void verify_both_items_are_present_in_cart() {
		checkOut.verifyItems();
	}

	@Then("Two items availeble in Cart")
	public void two_items_availeble_in_cart() {
		System.out.println("Successfully added address and two items in cart");
	}
}
