package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {
    @FindBy(xpath = "//div[@class='autocomplete-results-container']/div")
    public List<WebElement> suggestionsFromSearchDropdown;

    public void enterCharacters(String characters) {
        searchBoxInput.sendKeys(characters);
    }

}
