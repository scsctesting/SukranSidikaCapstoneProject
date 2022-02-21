package com.amazon.step_definitions;

import com.amazon.pages.LoginPage;
import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDefinitions {
    LoginPage loginPage=new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("Open login page");
        loginPage.enterUrl();
    }

    @Given("user hover over and clicks on Sign-in area")
    public void user_hover_over_and_clicks_on_sign_in_area() {
      loginPage.clickOnSignInArea();
    }



    @When("user enters {string} email and {string} password")
    public void user_enters_email_and_password(String string, String string2) {
        System.out.printf("Login with email %s and %s password\n", string, string2);
        loginPage.login();
    }
    @Then("user should verify the title of the page")
    public void user_should_verify_the_title_of_the_page() {
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(2);
        String title=Driver.getDriver().getTitle();
        System.out.println("title: "+ title);
        //Assert.assertTrue(title.equals(""));
    }




    //----------------------------------------------


//    @Then("user verifies that page title is {string}")
//    public void user_verifies_that_page_title_is(String string) {
//        System.out.println("Verify that page title is: " + string);
//        Assert.assertEquals(string, Driver.getDriver().getTitle());
//    }


    @Then("user clicks on Continue button")
    public void user_clicks_on_Continue_button(){
        loginPage.clickOnContinueButton();
    }

    @When("user enters email as{}"  )
        public void user_enters_email_as(String email){
        loginPage.email.sendKeys(email);
    }

    @Then("user should see alert message as{}")
    public void user_should_see_alert_message_as(String message){
        loginPage.getAlertMessage();
    }

    @When("user enters {string} email")
    public void user_enters_email(String string){
        loginPage.enterEmail();
    }

    @When("user enters password as{}"  )
    public void user_enters_password_as(String password){
        loginPage.password.sendKeys(password);
    }

}
