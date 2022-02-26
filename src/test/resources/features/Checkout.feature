Feature: Checkout

  Background: open login page
    Given user is on the login page

  @TC_15
  Scenario Outline: Validate address selection for the purchase
    When user enters item as "<item>" in search box and press search button
    And user clicks on the 4 star icon
    And user clicks on first best seller option
    And user clicks on Add to Cart
    And user clicks on Proceed to checkout Button
    And user selects Search by Zip Code option
    And user enters zip code into the zip code area
    And user clicks on Search button
    And user clicks on "Ship to This Address" button of first option
    Then user validates that user is navigated to next step "Select a payment method"
    Examples:
      | item            |
      | Socks for women |

  #---------------------------------------------

  @TC_16
  Scenario Outline: Validate that  error message is displayed when the user enters invalid input in all the mandatory field on the Payment Page
    When user enters item as "<item>" in search box and press search button
    And user clicks on the 4 star icon
    And user clicks on first best seller option
    And user clicks on Add to Cart
    And user clicks on Proceed to checkout Button
    And user selects Search by Zip Code option
    And user enters zip code into the zip code area
    And user clicks on Search button
    And user clicks on "Ship to This Address" button of first option
    Then user validates that user is navigated to next step "Select a payment method"
# 12.click “Add a credit cart or debit card” link
# 11.Add Credit Cart Number into the box as 1231 2312 3123 or 1231 2312 3123 1122-16 digits
# 12. Add Name on the card into the box
# 13. Choose month and year from the drop down box
# 14. Click “Add your card” button
# 11. verify that error message is displayed as
# There was a problem.
# Card number is not correct.

    Examples:
      | item            |
      | Socks for women |
  #-----------------------------------
  @TC_17
  Scenario Outline: Validate payment method options

    When user enters item as "<item>" in search box and press search button
    And user clicks on the 4 star icon
    And user clicks on first best seller option
    And user clicks on Add to Cart
    And user clicks on Proceed to checkout Button
    And user selects Search by Zip Code option
    And user enters zip code into the zip code area
    And user clicks on Search button
    And user clicks on "Ship to This Address" button of first option
    Then user validates that user is navigated to next step "Select a payment method"
    Then user should see following options as payment methods
  #(Date table kullan)

    Examples:
      | item            |
      | Socks for women |