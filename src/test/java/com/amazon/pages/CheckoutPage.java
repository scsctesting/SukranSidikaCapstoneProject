package com.amazon.pages;

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

    @FindBy(xpath = "//span[@id='apx-add-credit-card-action-test-id']")
    public WebElement addACreditCardButton;

    @FindBy(xpath = "//input[@name='addCreditCardNumber']")
    public WebElement cardNumberInputBox;

    @FindBy(xpath = "//input[@name='ppw-accountHolderName']")
    public WebElement nameOnCardInputBox;

    @FindBy(xpath = "//input[@name='ppw-widgetEvent:AddCreditCardEvent']")
    public WebElement addYourCardButton;

    @FindBy(xpath = "//input[@name='ppw-widgetEvent:AddCreditCardEvent']")
    public WebElement errorMessage;



    //-------------------------------------

    public void clickFirstShipToThisAddress(){
        shipToThisAddressButton.get(0).click();
    }

    public void verifyPaymentMethodPage(){
        Assert.assertTrue(paymentMethodPageTitle.isDisplayed());
    }


}
