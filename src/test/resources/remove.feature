Feature: remove

Scenario: Verify remove product from the cart
Given User is on Login Page
When User enters "<Username>" and "<Password>"
And Click on Login button
And User login sucessfully
And click on any product Addtocart button
And click on addtocart icon and check selected product is displayed
Then click on remove button and empty in your cart list
Examples:
      | Username              | Password   |
      |standard_user          |secret_sauce|