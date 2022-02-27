package com.amazon.step_definitions;

import com.amazon.pages.CartPage;
import io.cucumber.java.en.Then;

public class Cart_StepDefinitions {
    CartPage cartPage = new CartPage();

    @Then("user clicks on first best seller option")
    public void user_clicks_on_first_best_seller_option() {
        cartPage.clickFirstBestSellerOption();
    }

    @Then("user verifies the number of the stars")
    public void user_verifies_the_number_of_the_stars() {
        cartPage.verifyNumberOfStars();
    }

    @Then("user verifies the total number of ratings")
    public void user_verifies_the_total_number_of_ratings() {
        cartPage.verifyNumberOfRatings();
    }

    @Then("user clicks on Add to Cart")
    public void user_clicks_on_add_to_cart() {
        cartPage.addToCartButton.click();
    }

    @Then("user verifies the message as {string}")
    public void user_verifies_the_message_as(String string) {
        cartPage.getCartMessage();
    }

}
