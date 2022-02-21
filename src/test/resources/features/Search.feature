Feature: Search

  Background: open login page
    Given user is on the login page

Scenario: Typing any single character in the search box,
          it should show a list of product suggestions starting with the entered character

# Type a letter in search box
#Verify the suggested product suggestions from the dropdown