Feature: Addtocart

Scenario: Verify adding product to the cart
Given User is on Login Page
When User enters "<Username>" and "<Password>"
And Click on Login button
Then User login sucessfully
And click on any product Addtocart button
And click on addtocart icon and check selected product is displayed
Examples:
      | Username              | Password   |
      |standard_user          |secret_sauce|