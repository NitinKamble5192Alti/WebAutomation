package StepDefinition;

import CommonUtility.BaseClass;
import PageObjects.CheckoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutPageSteps {

    CheckoutPage checkoutPage;

    @When("user click on cart button on home page")
    public void userClickOnCartButtonOnHomePage() {
        checkoutPage = new CheckoutPage(BaseClass.driver);
        checkoutPage.clickOnMyCart();
    }

    @And("clicks on Proceed to buy button")
    public void clicksOnProceedToBuyButton() {
        checkoutPage.clickOnCheckout();
    }

    @And("clicks Add new Address link")
    public void clicksAddNewAddressLink() {
        checkoutPage.clickOnAddAddress();
    }

    @Then("user should enter details {string} {string} {int} {string} and click Use this address button")
    public void userShouldEnterDetailsAndClickUseThisAddressButton(String arg0, String arg1, int arg2, String arg3) throws InterruptedException {
        checkoutPage.addAddressDetails(arg0,arg1,arg2,arg3);
    }

    @And("Payment method options should be displayed")
    public void paymentMethodOptionsShouldBeDisplayed() throws InterruptedException {
        checkoutPage.isPaymentMethodsDisplayed();
    }

    @And("user clicks on Amazon.in and further clicks on Return to cart button")
    public void userClicksOnAmazonInAndFurtherClicksOnReturnToCartButton() {
        checkoutPage.clickOnLogoAndReturnToCart();
    }

    @Then("Verify user lands on cart page with both items added in cart.")
    public void verifyUserLandsOnCartPageWithBothItemsAddedInCart() throws InterruptedException {
        checkoutPage.isMyCartDisplayed();
    }


}
