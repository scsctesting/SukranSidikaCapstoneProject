package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {


    @FindBy(xpath = "//div[@id='nav-logo']")
    public WebElement logo;

    @FindBy(xpath = "//div[@id='nav-tools']//a[2]/div/span")
    public WebElement usernameArea;

    @FindBy(xpath = "//div[@class='nav-search-field ']")
    public WebElement searchField;

    @FindBy(id = "nav-search-submit-button")
    public WebElement searchSubmitButton;



    @FindBy(xpath = "//div[@id='nav-tools']//a[4]")
    public WebElement returnsAndOrders;

    @FindBy(xpath = "//div[@id='nav-search-dropdown-card']")
    public WebElement allInSearchBoxArea;

    @FindBy(xpath = "//select[@id='searchDropdownBox']/option")
    public List<WebElement> dropdownOptions;



    @FindBy(xpath = "//span[contains(text(),' results for')]")
    public WebElement totalCountOfProducts;

    @FindBy(xpath = "//div[@id='filters']/div")
    public List<WebElement> filterOptions;

    @FindBy(xpath = "(//div[@id='filters']/ul[4])/li")
    public List<WebElement> bookTypeOptions;

    public void clickOnSearchBoxArea() {
        BrowserUtils.highlightAndRemoveWebElement(allInSearchBoxArea);
        allInSearchBoxArea.click();
    }

    public List<String> getDropdownOptions() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < dropdownOptions.size(); i++) {
            list.add(dropdownOptions.get(i).getText());
        }
        System.out.println(list);
        return list;
    }

    String department = "";

    public void selectDepartment(String expected) {
        allInSearchBoxArea.click();
        BrowserUtils.waitForVisibilityList(dropdownOptions, 2);
        for (int i = 1; i < dropdownOptions.size(); i++) {
            String actual = dropdownOptions.get(i).getText();
            if (actual.equals(expected)) {
                department = actual;
                BrowserUtils.highlightAndRemoveWebElement(dropdownOptions.get(i));
                System.out.println("option: " + dropdownOptions.get(i).getText());
                dropdownOptions.get(i).click();
                break;
            }
        }
    }

    public void verifyDepartmentName() {
        System.out.println("department name:" + department);
        Assert.assertEquals("Books", department);
    }

    public void enterItemType(String expected) {
        searchBoxInput.sendKeys(expected, Keys.ENTER);
    }

    public void getFilterOptions() {
        for (int i = 0; i < filterOptions.size(); i++) {
            System.out.println(filterOptions.get(i).getText());
        }
    }


    String bookType = "";

    public void selectItemType(String book) {
        BrowserUtils.waitForVisibilityList(bookTypeOptions, 2);
        for (int i = 1; i < bookTypeOptions.size(); i++) {
            String actual = bookTypeOptions.get(i).getText();
            if (actual.equals(book)) {
                bookType = actual;
                BrowserUtils.highlightAndRemoveWebElement(bookTypeOptions.get(i));
                System.out.println("option: " + bookTypeOptions.get(i).getText());
                bookTypeOptions.get(i).click();
                break;
            }
        }
    }

    public void verifyBookType() {
        System.out.println("Book type:" + bookType);
        Assert.assertEquals("Chapter Books", bookType);
    }




}
