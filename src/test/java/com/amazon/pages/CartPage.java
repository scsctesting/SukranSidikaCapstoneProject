package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

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

    @FindBy(xpath = "//span[@data-action='a-dropdown-button']")
    public WebElement quantityButton;

    @FindBy(xpath = "//ul[@role='listbox']/li")
    public List<WebElement>quantityDropdownValues;


    //------------------------
    public void getCartMessage() {
        System.out.println("cartMessage: " + cartMessage.getText());
        BrowserUtils.waitFor(2);
        Assert.assertTrue(cartMessage.isDisplayed());
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
        BrowserUtils.waitFor(2);
        BrowserUtils.waitForVisibility(shoppingCartMessage,10);
        System.out.println("shoppingCartMessage: " + shoppingCartMessage.getText());
        Assert.assertTrue(shoppingCartMessage.isDisplayed());
    }

    int quantity;
    public void selectQuantity(String string){
        BrowserUtils.waitForVisibility(quantityButton,2);
        BrowserUtils.highlightAndRemoveWebElement(quantityButton);
        quantityButton.click();
       // BrowserUtils.waitFor(1);
        BrowserUtils.waitForVisibilityList(quantityDropdownValues,2);
        for (int i = 0; i <quantityDropdownValues.size() ; i++) {
            if(quantityDropdownValues.get(i).getText().equals(string)){
                quantity=Integer.parseInt(quantityDropdownValues.get(i).getText());
                System.out.println("quantity: "+quantity);
                quantityDropdownValues.get(i).click();
                break;
            }
        }
    }

    public void verifyQuantity(String string){
        Assert.assertEquals(quantity, Integer.parseInt(string));
    }

    int countBefore;
    int countAfter;
    public void deleteFirstItemInTheCart(){
        BrowserUtils.waitForVisibilityList(deleteButtonsInShoppingCart,5);
        for (int i = 0; i < deleteButtonsInShoppingCart.size(); i++) {
            countBefore=titlesInShoppingCart.size();
            System.out.println("countBefore delete: "+countBefore);
            BrowserUtils.highlightAndRemoveWebElement(deleteButtonsInShoppingCart.get(i));
            deleteButtonsInShoppingCart.get(i).click();
            BrowserUtils.waitFor(1);
            countAfter=titlesInShoppingCart.size();
            System.out.println("countafter delete: "+countAfter);
            break;
        }
    }

    public void verifyCountDecreased(){
        BrowserUtils.waitFor(2);
        Assert.assertTrue(countBefore>countAfter);
    }

}
