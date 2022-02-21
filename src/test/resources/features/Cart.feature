@Cart
Feature: Cart

  Background: open login page
    Given user is on the login page

@TC_09
    Scenario: Verify adding to cart is working as expected
#    Type "Kids Books" in search box and press search button (enter)
#    3. validate that best seller options are displayed.
#    4. Click on first best seller option
#    5. Verify number of the stars
#    6. Verify total number of ratings
#    7. Click on Add to Cart
#    8. Verify the message "Added to Cart"


@TC_10
Scenario: Verify adding multiple items to the cart is working as expected
  When user enters book type as "<books>" in search box and press search button
#3. validate that best seller options are displayed.
  Then user verifies that best seller options are displayed
#4. Click on first best seller option

#5. Verify number of the stars
#6. Verify total number of ratings
#7. Click on Add to Cart
#8. Verify the message "Added to Cart"
#9. Type "Kids Books" in search box and press search button
#9. Click on the first option
#10. Verify number of the stars
#11. Verify total number of ratings
#12. Click on Add to Cart
#13. Verify the message "Added to Cart"
#14.Click to Go to Cart button
#15. verify that the two added books are displayed.
#---------------------------------------------
  @TC_11
  Scenario: Verify that user can add the same item to their cart more than once.
    When user enters book type as "<books>" in search box and press search button

#  Select a random option
#  select quantity from quantity dropdown
#  Click Add to Cart button
#  Click go to cart button
#  verify quantity of the item




   # -----------------------------------------
@TC_12
Scenario: Verify that user can remove item from their cart
When user enters book type as "<books>" in search box and press search button
Then user verifies that best seller options are displayed
#4. Click on first best seller option
#5. Click on Add to Cart
#6.Click to Go to Cart button
#7.Click the delete button in the Cart
#8. verify that the message is displayed(Your Amazon Cart is empty.)

  #------------------------------------------
@TC_13
Scenario: Verify deleting a product from the cart is working as expected

  When user enters book type as "<books>" in search box and press search button
  Then user verifies that best seller options are displayed
#4. Click on first best seller option
#5. Click on Add to Cart
#6.Type "Kids Books" in search box and press search button
#7. Click on the first option
#8.Click on Add to Cart
#9.Click to Go to Cart button
#10. verify that the two added books are displayed.
#11. Delete the first item in the Cart
#12. Verify that item is deleted.(once sayiy al-delet den sonra sayinin azaldigini verify et)
