package com.amazon.step_definitions;

import com.amazon.pages.HomePage;
import com.amazon.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomePage_StepDefinitions {
    HomePage homePage = new HomePage();

    @Then("user verifies that website logo is displayed")
    public void user_verifies_that_website_logo_is_displayed() {
        BrowserUtils.waitForVisibility(homePage.logo, 2);
        BrowserUtils.highlightAndRemoveWebElement(homePage.logo);
        BrowserUtils.waitFor(1);
        Assert.assertTrue(homePage.logo.isDisplayed());
    }

    @Then("user verifies that username area is displayed")
    public void user_verifies_that_username_area_is_displayed() {
        BrowserUtils.highlightAndRemoveWebElement(homePage.usernameArea);
        BrowserUtils.waitFor(1);
        Assert.assertTrue(homePage.usernameArea.isDisplayed());
    }

    @Then("user verifies that search box is displayed")
    public void user_verifies_that_search_box_is_displayed() {
        BrowserUtils.highlightAndRemoveWebElement(homePage.searchField);
        BrowserUtils.waitFor(1);
        Assert.assertTrue(homePage.searchField.isDisplayed());
    }

    @Then("user verifies that Cart icon is displayed")
    public void user_verifies_that_Cart_icon_is_displayed() {
        BrowserUtils.highlightAndRemoveWebElement(homePage.cartIcon);
        BrowserUtils.waitFor(1);
        Assert.assertTrue(homePage.cartIcon.isDisplayed());
    }

    @Then("user verifies that Returns and orders are displayed")
    public void user_verifies_that_Returns_and_orders_are_displayed() {
        BrowserUtils.highlightAndRemoveWebElement(homePage.returnsAndOrders);
        BrowserUtils.waitFor(1);
        Assert.assertTrue(homePage.returnsAndOrders.isDisplayed());
    }

    @Given("user clicks on All in search box area")
    public void user_clicks_on_all_in_search_box_area() {
        homePage.clickOnSearchBoxArea();
    }

    @Given("user gets the dropdown values")
    public void user_gets_the_dropdown_values() {
        homePage.getDropdownOptions();
    }

    @Given("user gets department as {string} from the dropdown list")
    public void user_gets_department_as_from_the_dropdown_list(String string) {
        homePage.selectDepartment(string);
    }

    @Then("user verifies the selected department name")
    public void user_verifies_the_selected_department_name() {
        homePage.verifyDepartmentName();
    }

    @When("user enters item as {string} in search box and press search button")
    public void user_enters_item_as_in_search_box_and_press_search_button(String string) {
        homePage.enterItemType(string);
    }

    @Then("user verifies that total count of products is displayed on the search result page")
    public void user_verifies_that_total_count_of_products_is_displayed_on_the_search_result_page() {
        Assert.assertTrue(homePage.totalCountOfProducts.isDisplayed());
    }

    @Then("user verifies that best seller options are displayed")
    public void user_verifies_that_best_seller_options_are_displayed() {
        System.out.println("size of best sellers: " + homePage.bestSellerOptions.size());
        Assert.assertTrue(homePage.bestSellerOptions.size() > 0);
    }

    @When("user verifies that options for filter are displayed")
    public void user_verifies_that_options_for_filter_are_displayed() {
        homePage.getFilterOptions();
        Assert.assertTrue(homePage.filterOptions.size() > 0);
    }

    @When("user selects the book type option as {string}")
    public void user_selects_the_book_type_option_as(String string) {
        homePage.selectBookType(string);
    }

    @Then("user verifies the selected book type")
    public void user_verifies_the_selected_book_type() {
        homePage.verifyBookType();
    }

}
