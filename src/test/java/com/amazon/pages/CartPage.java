package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{


    @FindBy(xpath= "//*[@id='sw-atc-details-single-container']//div[2]/div/span")
    public WebElement cartMessage;

    @FindBy(xpath= "//div[@id='averageCustomerReviews_feature_div']//i/span")
    public WebElement numberOfTheStars;

    @FindBy(xpath= "//div[@id='averageCustomerReviews']/span[3]/a/span")
    public WebElement numberOfRatings;

    @FindBy(xpath= "//input[@id='add-to-cart-button']")
    public WebElement addToCartButton;

    @FindBy(xpath= "//div[@class='a-section a-spacing-none a-padding-none']")
    public WebElement cartMessage2;



    //------------------------
    public void getCartMessage() {
        System.out.println("cartMessage: " + cartMessage.getText());
        BrowserUtils.waitFor(2);
        Assert.assertTrue(cartMessage.isDisplayed());
    }

public void clickFirstBestSellerOption(){
        BrowserUtils.waitForVisibilityList(bestSellerOptions,1);
//    for (int i = 0; i <bestSellerOptions.size() ; i++) {
//        BrowserUtils.scrollToSpecificWebElement(bestSellerOptions.get(i));
//        BrowserUtils.highlightAndRemoveWebElement(bestSellerOptions.get(i));
//        BrowserUtils.waitFor(1);
//        bestSellerOptions.get(i).click();
//        BrowserUtils.waitFor(2);
//    }
    BrowserUtils.scrollToSpecificWebElement(bestSellerOptions.get(0));
    System.out.println("first: "+ bestSellerOptions.get(0).getText());
    BrowserUtils.highlightAndRemoveWebElement(bestSellerOptions.get(0));
    BrowserUtils.waitFor(1);
    bestSellerOptions.get(0).click();
    BrowserUtils.waitFor(2);

}

public void verifyNumberOfStars(){
    System.out.println("numberOfStars text: "+numberOfTheStars.getText());
    String [] splitted=numberOfTheStars.getText().split(" ");
    String stars=splitted[0];
    System.out.println(stars);
}

    public void verifyNumberOfRatings(){
        System.out.println("numberOfRatings text: "+numberOfRatings.getText());
        String [] splitted=numberOfRatings.getText().split(" ");
        String rating=splitted[0];
        System.out.println(rating);
    }

}
