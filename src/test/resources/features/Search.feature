@Search @RegressionTest
Feature: Search

  Background: open login page
    Given user is on the login page

  @TC_09 @smoke_test
  Scenario Outline: Typing characters in the search box to see product suggestions starting with the entered character
    When user types characters as "<characters>" in search box
    Then user verifies that product suggestions are displayed

    Examples:
      | characters |
      | ab         |