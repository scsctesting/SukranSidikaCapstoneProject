package com.amazon.pages;

import com.amazon.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {
    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 25);
    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBoxInput;

    @FindBy(xpath = "//span[contains(text(),'Best Seller')]")
    public List<WebElement> bestSellerOptions;



//    @FindBy(css = "abc")
//    protected WebElement currentUser;
//
//    public String getCurrentUserName(){
//        BrowserUtils.waitForPageToLoad(10);
//        wait.until(ExpectedConditions.visibilityOf(currentUser));
//        return currentUser.getText().trim();
//    }


}
