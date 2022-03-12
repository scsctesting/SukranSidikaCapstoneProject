package com.amazon.step_definitions;

import com.amazon.pages.CheckoutPage;
import com.amazon.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Checkout_StepDefinitions {
    CheckoutPage checkoutPage=new CheckoutPage();

    @When("user clicks on the {int} star icon")
    public void user_clicks_on_the_star_icon(Integer int1) {
        checkoutPage.fourStarOption.click();
    }

    @When("user clicks on Proceed to checkout Button")
    public void user_clicks_on_proceed_to_checkout_button() {
        checkoutPage.proceedToCheckoutButton.click();
    }

    @When("user selects Search by Zip Code option")
    public void user_selects_search_by_zip_code_option() {
        checkoutPage.searchByZipButton.click();
    }

    @When("user enters zip code into the zip code area")
    public void user_enters_zip_code_into_the_zip_code_area() {
        checkoutPage.zipInputBox.sendKeys("30096", Keys.ENTER);
    }

    @When("user clicks on Search button")
    public void user_clicks_on_search_button() {
       checkoutPage.searchButtonForCheckout.click();
    }

    @When("user clicks on {string} button of first option")
    public void user_clicks_on_button_of_first_option(String string) {
        checkoutPage.clickFirstShipToThisAddress();
    }

    @Then("user validates that user is navigated to next step {string}")
    public void user_validates_that_user_is_navigated_to_next_step(String string) {
        checkoutPage.verifyPaymentMethodPage();
    }

    @Then("user clicks on Add a credit cart or debit card link")
    public void user_clicks_on_add_a_credit_cart_or_debit_card_link() {
        checkoutPage.clickOnAddCreditCardButton();
    }

    @Then("user adds credit cart number into the card number input box")
    public void user_adds_credit_cart_number_into_the_card_number_input_box(){
        checkoutPage.cardNumberInputBox.sendKeys("1231 2312 3123 1122");
    }

    @Then("user adds name into the name on the card input box")
    public void user_adds_name_into_the_name_on_the_card_input_box() {
        checkoutPage.nameOnCardInputBox.sendKeys("Jack James");
    }

    @Then("user selects month and year from the drop down box")
    public void user_selects_month_and_year_from_the_drop_down_box() {

    }

    @Then("user clicks on Add your card button")
    public void user_clicks_on_add_your_card_button() {
        checkoutPage.addYourCardButton.click();
    }

    @Then("user verifies the error message as {string}")
    public void user_verifies_the_error_message_as(String string) {
        Assert.assertTrue(checkoutPage.errorMessage.isDisplayed());
    }

    @Then("user should see options for payment methods")
    public void user_should_see_options_for_payment_methods() {
        checkoutPage.verifyPaymentOptions();
    }

    @Then("user verifies card pop up is displayed")
    public void user_verifies_card_pop_up_is_displayed() {
    checkoutPage.cardPopup.isDisplayed();
    }

}
