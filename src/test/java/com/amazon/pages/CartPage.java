package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{


    @FindBy(xpath= "//*[@id=\"sw-atc-details-single-container\"]//div[2]/div/span")
    public WebElement cartMessage;


    public void getCartMessage() {
        System.out.println("cartMessage: " + cartMessage.getText());
        BrowserUtils.waitFor(2);
        Assert.assertTrue(cartMessage.isDisplayed());
    }


}
