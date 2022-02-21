package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    //@FindBy(id = "//a[@id='nav-link-accountList']")
    @FindBy(id = "//span[@id='nav-link-accountList-nav-line-1']")
    public WebElement signInArea;

    @FindBy(xpath = "//span[@class='nav-action-inner']")
    public WebElement signIn;


    @FindBy(id = "//input[@id='ap_email']")
    public WebElement email;

    @FindBy(id = "//input[@id='ap_password']")
    public WebElement password;

    @FindBy(id = "//input[@id='continue']")
    public WebElement continueButton;

    @FindBy(id = "abc")
    public WebElement notNowButtonForPhoneRequest;

    @FindBy(xpath = "//div[@class='a-alert-content']//li")
    public WebElement alertMessage;

//-------------------------------------------
    public void enterUrl() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    public void clickOnSignInArea() {
        Actions action = new Actions(driver);
        action.moveToElement(signInArea).perform();

        BrowserUtils.highlightAndRemoveWebElement(signIn);
        signIn.click();
       // BrowserUtils.waitFor(3);
        BrowserUtils.waitForPageToLoad(5);
    }

    public void login() {
        email.sendKeys(ConfigurationReader.getProperty("email"));
        continueButton.click();
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
//        BrowserUtils.waitForPageToLoad(10);

    }

    public void clickOnContinueButton() {
        continueButton.click();
    }


    public void getAlertMessage() {
        BrowserUtils.waitForVisibility(alertMessage, 10);
        System.out.println("alert message: " + alertMessage);
        Assert.assertTrue(alertMessage.isDisplayed());
    }

    public void enterEmail() {
        email.sendKeys(ConfigurationReader.getProperty("email"));
        continueButton.click();
    }


}
