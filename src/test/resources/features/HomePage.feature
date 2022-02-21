@HomePage
Feature: HomePage

  Background: open login page
    Given user is on the login page
    When user enters "email" email and "password" password

  @TC_04
  Scenario: Verify that the specified fields are present on the home page
    Then user should verify the title of the page
    Then user verifies that following areas are displayed:
      | website logo       |
      | username area      |
      | search box         |
      | Cart icon          |
      | Returns and orders |

#    Then user verifies that website logo is displayed
#    Then user verifies that username area is displayed
#    Then user verifies that search box is displayed
#    Then user verifies that Cart icon is displayed
#    Then user verifies that Returns and orders are displayed

  @TC_05
  Scenario: Verify the departments from the dropdown list
    And user clicks on All in search box area
    And user gets the dropdown values
    Then user verifies the departments


  @TC_06
  Scenario: Verify the selected department is highlighted.
    And user clicks on All in search box area
    And user gets a random department from the dropdown list
    Then user verifies the selected department/category name


  @TC_07
  Scenario Outline: Verify the total count and best seller options are displayed.

    When user enters book type as "<books>" in search box and press search button
    Then user verifies that total count of products is displayed on the search result page
    Then user verifies that best seller options are displayed

    Examples:
      | books      |
      | Kids books |

  @TC_08
  Scenario Outline: Verify that filtering works correctly.
    When user enters book type as "<books>" in search box and press search button
    And user verifies that options for filter are displayed
    And user selects the book type
    Then user verifies the total results of the product of the chosen type

    Examples:
      | books      |
      | Kids books |