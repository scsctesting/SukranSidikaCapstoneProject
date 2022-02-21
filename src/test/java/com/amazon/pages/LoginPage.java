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

    @FindBy(xpath= "//div[@id='nav-tools']/a[2]")
    public WebElement signInArea;

    @FindBy(xpath = "//span[@class='nav-action-inner']")
    public WebElement signIn;

    @FindBy(xpath = "//input[@id='ap_email']")
    public WebElement email;

    @FindBy(xpath = "//input[@id='ap_password']")
    public WebElement password;

    @FindBy(xpath = "//input[@id='continue']")
    public WebElement continueButton;

    @FindBy(id = "abc")
    public WebElement notNowButtonForPhoneRequest;

   // @FindBy(xpath = "//div[@class='a-alert-content']//li")
    @FindBy(xpath = "(//div[@class='a-alert-content'])[1]")
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
    }

    public void login() {
        email.sendKeys(ConfigurationReader.getProperty("email"));
        continueButton.click();
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
        BrowserUtils.waitFor(3);
       // if(BrowserUtils.isElementPresent()){

        //}
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }


    public void getAlertMessage() {
        BrowserUtils.waitForVisibility(alertMessage, 3);
        System.out.println("alert message: " + alertMessage.getText());
        Assert.assertTrue(alertMessage.isDisplayed());
    }

    public void enterEmail() {
        email.sendKeys(ConfigurationReader.getProperty("email"));
        continueButton.click();
    }


}
