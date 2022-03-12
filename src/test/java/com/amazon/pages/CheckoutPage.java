package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutPage extends BasePage{

    @FindBy(xpath= "//span[@id='sc-buy-box-ptc-button']")
    public WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//section[@aria-label='4 Stars & Up']")
    public WebElement fourStarOption;

    @FindBy(xpath = "//input[@id='searchCriterion.storeZip']")
    public WebElement searchByZipButton;

    @FindBy(xpath = "//input[@id='storeZip']")
    public WebElement zipInputBox;

    @FindBy(xpath = "//input[@name='Search']")
    public WebElement searchButtonForCheckout;

    @FindBy(xpath = "//input[@name='shipToThisAddress']")
    public List<WebElement> shipToThisAddressButton;

    @FindBy(xpath = "//h1")
    public WebElement paymentMethodPageTitle;

    //(//span[@class='a-button a-button-base apx-secure-registration-content-trigger-js'])[1]
   // @FindBy(xpath = "//span[@id='apx-add-credit-card-action-test-id']")
    //@FindBy(xpath = "//(//input[@class='a-button-input a-button-text'])[2]")
   // @FindBy(xpath = "//div[@class='a-section pmts-add-credit-card-component-container']")
    @FindBy(xpath = "//div[@class='a-section pmts-add-credit-card-component-container']/div/span")
    public WebElement addACreditCardButton;

    //@FindBy(xpath = "//input[@name='addCreditCardNumber']")
    @FindBy(xpath = "(//input[@class='a-input-text a-form-normal'])[1]")
    public WebElement cardNumberInputBox;

    @FindBy(xpath = "//input[@name='ppw-accountHolderName']")
    public WebElement nameOnCardInputBox;

    @FindBy(xpath = "//input[@name='ppw-widgetEvent:AddCreditCardEvent']")
    public WebElement addYourCardButton;

    @FindBy(xpath = "//input[@name='ppw-widgetEvent:AddCreditCardEvent']")
    public WebElement errorMessage;

    //@FindBy(xpath = "//div[@class='a-fixed-right-grid']")
    @FindBy(xpath = "//div[@class='a-fixed-right-grid']/div/div/div/div/span")
    public List<WebElement> paymentOptions;

    @FindBy(xpath = "//div[@class='a-popover a-popover-modal a-declarative']")
    public WebElement cardPopup;

    //-------------------------------------

    public void clickFirstShipToThisAddress(){
        shipToThisAddressButton.get(0).click();
    }

    public void verifyPaymentMethodPage(){
        System.out.println("page title:"+paymentMethodPageTitle.getText());
        Assert.assertTrue(paymentMethodPageTitle.isDisplayed());
    }

    public void verifyPaymentOptions(){
        for (int i = 0; i < paymentOptions.size(); i++) {
            System.out.println(paymentOptions.get(i).getText());
        }
    }

    public void clickOnAddCreditCardButton(){
        BrowserUtils.waitForVisibility(addACreditCardButton,3);
        BrowserUtils.isElementPresent(addACreditCardButton);
        BrowserUtils.highlightAndRemoveWebElement(addACreditCardButton);
        addACreditCardButton.click();
        BrowserUtils.waitFor(2);
    }


}
