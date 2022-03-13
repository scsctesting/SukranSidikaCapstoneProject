package com.amazon.step_definitions;

import com.amazon.pages.CartPage;
import com.amazon.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Cart_StepDefinitions {
    CartPage cartPage = new CartPage();

    @Then("user clicks on first option")
    public void user_clicks_on_first_option() {
        cartPage.clickFirstOption();
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
        BrowserUtils.waitFor(2);
        cartPage.addToCartButton.click();
    }

    @Then("user verifies the message as {string}")
    public void user_verifies_the_message_as(String string) {
        cartPage.getCartMessage();
    }

    @Then("user clicks on Cart button")
    public void user_clicks_on_Cart_button() {
        cartPage.cartIcon.click();
    }

    @Then("user verifies that the added items are displayed")
    public void user_verifies_that_the_added_items_are_displayed() {
       cartPage.getItemsTitles();
    }

    @Then("user clears the search box")
    public void user_clears_the_search_box() {
        cartPage.searchBoxInput.clear();
    }

    @Then("user clicks on delete button in the Cart")
    public void user_clicks_on_delete_button_in_the_cart() {
        BrowserUtils.waitForVisibility(cartPage.deleteInShoppingCart, 5);
        BrowserUtils.waitForClickability(cartPage.deleteInShoppingCart, 5);
        BrowserUtils.highlightAndRemoveWebElement(cartPage.deleteInShoppingCart);
        cartPage.deleteInShoppingCart.click();
    }

    @Then("user verifies the shopping cart message as {string}")
    public void user_verifies_the_shopping_cart_message_as(String string) {
        cartPage.getShoppingCartMessage();
    }

    @When("user selects quantity as {string} from quantity dropdown")
    public void user_selects_quantity_as_from_quantity_dropdown(String string) {
        cartPage.selectQuantity(string);
    }

    @Then("user verifies quantity as {string} of the item")
    public void user_verifies_quantity_as_of_the_item(String string) {
        cartPage.verifyQuantity(string);
    }

    @Then("user deletes the first item in the Cart")
    public void user_deletes_the_first_item_in_the_cart() {
        cartPage.deleteFirstItemInTheCart();
    }
    @Then("user verifies that item count is decreased")
    public void user_verifies_that_item_count_is_decreased() {
        cartPage.verifyCountDecreased();
    }
}
