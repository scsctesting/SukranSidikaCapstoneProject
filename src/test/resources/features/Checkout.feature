@Checkout @RegressionTest
Feature: Checkout

  Background: open login page
    Given user is on the login page
    And user hover over and clicks on Sign-in area
    When user enters "email" email and "password" password

  @TC_15
  Scenario Outline: Validate address selection for the purchase
    When user enters item as "<item>" in search box and press search button
    And user clicks on the 4 star icon
    And user clicks on first option
    And user clicks on Add to Cart
    And user clicks on Proceed to checkout Button
    And user selects Search by Zip Code option
    And user enters zip code into the zip code area
    And user clicks on Search button
    And user clicks on "Ship to This Address" button of first option
    Then user validates that user is navigated to next step "Select a payment method"
    Examples:
      | item     |
      | journals |

  @TC_16
  Scenario Outline: Validate payment method options
    When user enters item as "<item>" in search box and press search button
    And user clicks on the 4 star icon
    And user clicks on first option
    And user clicks on Add to Cart
    And user clicks on Proceed to checkout Button
    And user selects Search by Zip Code option
    And user enters zip code into the zip code area
    And user clicks on Search button
    And user clicks on "Ship to This Address" button of first option
    Then user validates that user is navigated to next step "Select a payment method"
    Then user should see options for payment methods

    Examples:
      | item            |
      | Socks for women |


  @TC_17
  Scenario Outline: Validate that  error message is displayed when the user enters invalid input in all the mandatory field on the Payment Page
    When user enters item as "<item>" in search box and press search button
    And user clicks on the 4 star icon
    And user clicks on first option
    And user clicks on Add to Cart
    And user clicks on Proceed to checkout Button
    And user selects Search by Zip Code option
    And user enters zip code into the zip code area
    And user clicks on Search button
    And user clicks on "Ship to This Address" button of first option
    Then user validates that user is navigated to next step "Select a payment method"
    And user clicks on Add a credit cart or debit card link
    And user verifies card pop up is displayed
    And user adds credit cart number into the card number input box
    And user adds name into the name on the card input box
    And user clicks on Add your card button
    Then user verifies the error message as "<errorMessage>"

    Examples:
      | item        | errorMessage                                    |
      | Adult books | There was a problem.Card number is not correct. |
