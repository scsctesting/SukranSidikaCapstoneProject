package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    @FindBy(xpath = "//div[@id='nav-logo']")
    public WebElement logo;

    @FindBy(xpath = "//div[@id='nav-tools']//a[2]/div/span")
    public WebElement usernameArea;

    @FindBy(xpath = "//div[@class='nav-search-field ']")
    public WebElement searchField;

    @FindBy(id = "nav-search-submit-button")
    public WebElement searchSubmitButton;

    @FindBy(xpath = "//div[@id='nav-tools']//a[5]")
    public WebElement cartIcon;

    @FindBy(xpath = "//div[@id='nav-tools']//a[4]")
    public WebElement returnsAndOrders;



}
