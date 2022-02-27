package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{


    @FindBy(xpath= "//*[@id='sw-atc-details-single-container']//div[2]/div/span")
    public WebElement cartMessage;

    @FindBy(xpath= "//div[@id='averageCustomerReviews_feature_div']//i[1]")
    public WebElement numberOfTheStars;

    @FindBy(xpath= "//div[@id='averageCustomerReviews']/span[3]/a/span")
    public WebElement numberOfRatings;

    @FindBy(xpath= "//input[@id='add-to-cart-button']")
    public WebElement addToCartButton;

//    @FindBy(xpath= "//div[@class='a-section a-spacing-none a-padding-none']")
//    public WebElement cartMessage2;

    @FindBy(xpath= "//a[contains(text(),'Go to Cart')]")
    public WebElement goToCartButton;

    @FindBy(xpath= "//span[@data-action='delete']")
    public WebElement deleteInShoppingCart;

    @FindBy(xpath= "//h1[contains(text(),'Your Amazon Cart is empty.')]")
    public WebElement shoppingCartMessage;

    //------------------------
    public void getCartMessage() {
        System.out.println("cartMessage: " + cartMessage.getText());
        BrowserUtils.waitFor(2);
        Assert.assertTrue(cartMessage.isDisplayed());
    }

public void clickFirstOption(){
    for (int i = 0; i <allOptions.size() ; i++) {
        BrowserUtils.highlightAndRemoveWebElement(allOptions.get(i));
        allOptions.get(i).click();
        System.out.println("first: "+title.get(0).getText());
        break;
    }
}

public void verifyNumberOfStars(){
   BrowserUtils.highlightAndRemoveWebElement(numberOfTheStars);
   Assert.assertTrue(numberOfTheStars.isDisplayed());
}

    public void verifyNumberOfRatings(){
        System.out.println("numberOfRatings text: "+numberOfRatings.getText());
        String [] splitted=numberOfRatings.getText().split(" ");
        String rating=splitted[0];
        System.out.println(rating);
    }

    public void getItemsTitles(){
        BrowserUtils.isElementPresentList(titlesInShoppingCart);
        for (int i = 0; i < titlesInShoppingCart.size(); i++) {
            System.out.println(titlesInShoppingCart.get(i).getText());
        }
        Assert.assertTrue(titlesInShoppingCart.size()==2);
    }

    public void getShoppingCartMessage() {
        BrowserUtils.waitForVisibility(shoppingCartMessage,5);
        System.out.println("shoppingCartMessage: " + shoppingCartMessage.getText());
        BrowserUtils.waitFor(2);
        Assert.assertTrue(shoppingCartMessage.isDisplayed());
    }
}
