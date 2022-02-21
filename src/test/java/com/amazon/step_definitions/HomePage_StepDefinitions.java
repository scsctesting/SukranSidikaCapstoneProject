package com.amazon.step_definitions;

import com.amazon.pages.HomePage;
import com.amazon.utilities.BrowserUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;

import java.util.List;

public class HomePage_StepDefinitions {
    HomePage homePage=new HomePage();

    @Then("user verifies that website logo is displayed")
    public void user_verifies_that_website_logo_is_displayed(){
        BrowserUtils.waitForVisibility(homePage.logo,2);
        Assert.assertTrue(homePage.logo.isDisplayed());
    }

    @Then("user verifies that username area is displayed")
    public void user_verifies_that_username_area_is_displayed(){
        Assert.assertTrue(homePage.usernameArea.isDisplayed());
    }

    @Then("user verifies that search box is displayed")
    public void user_verifies_that_search_box_is_displayed(){
        Assert.assertTrue(homePage.searchField.isDisplayed());
    }

    @Then("user verifies that Cart icon is displayed")
    public void user_verifies_that_Cart_icon_is_displayed(){
        Assert.assertTrue(homePage.cartIcon.isDisplayed());
    }

    @Then("user verifies that Returns and orders are displayed")
    public void user_verifies_that_Returns_and_orders_are_displayed(){
        Assert.assertTrue(homePage.returnsAndOrders.isDisplayed());
    }



}
