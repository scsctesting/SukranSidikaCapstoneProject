package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    protected WebDriver driver = Driver.getDriver();
   // protected WebDriverWait wait = new WebDriverWait(driver, 25);
    protected WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(25));
    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBoxInput;

    @FindBy(xpath = "//span[contains(text(),'Best Seller')]")
    public List<WebElement> bestSellerOptions;

    @FindBy(xpath = "//div[@class='a-section aok-relative s-image-square-aspect']")
   // @FindBy(xpath = "//div[starts-with(@class,'a-section aok-relative s-image-')]")
    public List<WebElement> allOptions;

    //@FindBy(xpath = "//div[@id='nav-tools']//a[5]")
    @FindBy(xpath = "//a[@id='nav-cart']")
    public WebElement cartIcon;

   @FindBy(id="productTitle")
    public List<WebElement> title;

    @FindBy(xpath = "//div[@class='a-fixed-left-grid']//div/div/ul/li[1]")
    public List<WebElement> titlesInShoppingCart;

    @FindBy(xpath = "//span[@data-action='delete']")
    public List<WebElement> deleteButtonsInShoppingCart;

//    @FindBy(css = "abc")
//    protected WebElement currentUser;
//
//    public String getCurrentUserName(){
//        BrowserUtils.waitForPageToLoad(10);
//        wait.until(ExpectedConditions.visibilityOf(currentUser));
//        return currentUser.getText().trim();
//    }

    public void clickFirstOption(){
        BrowserUtils.waitForPageToLoad(10);
        for (int i = 0; i <allOptions.size() ; i++) {
            BrowserUtils.scrollToSpecificWebElement(allOptions.get(i));
            BrowserUtils.highlightAndRemoveWebElement(allOptions.get(i));
            allOptions.get(i).click();
            System.out.println("first option: "+title.get(0).getText());
            break;
        }
    }

}
