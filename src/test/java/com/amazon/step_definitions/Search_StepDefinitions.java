package com.amazon.step_definitions;

import com.amazon.pages.SearchPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Search_StepDefinitions {
    SearchPage searchPage = new SearchPage();

    @When("user types characters as {string} in search box")
    public void user_types_characters_as_in_search_box(String string) {
        searchPage.enterCharacters(string);
    }

    @Then("user verifies that product suggestions are displayed")
    public void user_verifies_that_product_suggestions_are_displayed() {
        System.out.println("size of dropdown suggestions: " + searchPage.suggestionsFromSearchDropdown.size());
        Assert.assertTrue(searchPage.suggestionsFromSearchDropdown.size() > 0);
    }

}
