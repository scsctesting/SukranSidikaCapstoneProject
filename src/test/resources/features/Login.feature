@Login
Feature: Login

  Background: open login page
    Given user is on the login page

  @TC_01
  Scenario: Verify the login of Amazon
    And user hover over and clicks on Sign-in area
    When user enters "email" email and "password" password
    Then user should verify the title of the page
#      Then user verifies that page title is "<title>"
#
#      Examples:
#      |title|
#      |  abcde   |

  @TC_02
  Scenario Outline: Login with invalid credentials-email.
    When user enters email as "<email>"
    And user clicks on Continue button
    Then user should see alert message as "<message>"

    Examples:
      | email              | message                                           |
      | scsctest@gmail.com | We cannot find an account with that email address |

  @TC_03
  Scenario Outline: Login with invalid credentials-password.
    When user enters "email" email
    And user clicks on Continue button
    And user enters password as "<password>"
    Then user should see alert message as "<message>"

    Examples:
      | password | message                    |
      | abc123   | Your password is incorrect |