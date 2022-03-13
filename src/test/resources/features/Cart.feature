@Cart @RegressionTest
Feature: Cart

  Background: open login page
    Given user is on the login page

  @TC_10 @smoke_test
  Scenario Outline: Verify adding to cart is working as expected
    When user enters item as "<item>" in search box and press search button
    Then user verifies that best seller options are displayed
    And user clicks on first option
    Then user verifies the number of the stars
    Then user verifies the total number of ratings
    And user clicks on Add to Cart
    Then user verifies the message as "<message>"

    Examples:
      | item       | message       |
      | Kids books | Added to Cart |

  @TC_11
  Scenario Outline: Verify adding multiple items to the cart is working as expected
    When user enters item as "<item>" in search box and press search button
    Then user verifies that best seller options are displayed
    And user clicks on first option
    And user clicks on Add to Cart
    Then user verifies the message as "<message>"
    And user clears the search box
    When user enters item as "<item2>" in search box and press search button
    And user clicks on first option
    And user clicks on Add to Cart
    Then user verifies the message as "<message>"
    And user clicks on Cart button
    Then user verifies that the added items are displayed

    Examples:
      | item        | message       | item2      |
      | Adult books | Added to Cart | Kids books |

  @TC_12
  Scenario Outline: Verify that user can add the same item to their cart more than once.
    When user enters item as "<item>" in search box and press search button
    And user clicks on first option
    And user clicks on Add to Cart
    And user clicks on Cart button
    And user selects quantity as "<quantity>" from quantity dropdown
    Then user verifies quantity as "<quantity>" of the item

    Examples:
      | item       | quantity |
      | Kids books | 2        |

  @TC_13
  Scenario Outline: Verify that user can remove item from their cart
    When user enters item as "<item>" in search box and press search button
    Then user verifies that best seller options are displayed
    And user clicks on first option
    And user clicks on Add to Cart
    And user clicks on Cart button
    And user clicks on delete button in the Cart
    Then user verifies the shopping cart message as "<message>"
    Examples:
      | item        | message                    |
      | adult books | Your Amazon Cart is empty. |

  @TC_14
  Scenario Outline: Verify deleting a product from the cart is working as expected

    When user enters item as "<item>" in search box and press search button
    Then user verifies that best seller options are displayed
    And user clicks on first option
    And user clicks on Add to Cart
    And user clears the search box
    When user enters item as "<item2>" in search box and press search button
    And user clicks on first option
    And user clicks on Add to Cart
    And user clicks on Cart button
    Then user verifies that the added items are displayed
    And user deletes the first item in the Cart
    Then user verifies that item count is decreased

    Examples:
      | item       | item2       |
      | Kids books | Adult books |