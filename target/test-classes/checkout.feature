Feature: checkout

Scenario: Verify checkout is sucessful
Given User is on Login Page
When User enters "<Username>" and "<Password>"
And Click on Login button
And User login sucessfully
And click on any product Addtocart button
And click on addtocart icon and check selected product is displayed
And click on remove button and empty in your cart list
And click on addtocart icon
And click on checkout button
Then Enter firstname and lastname and zipcode details
And click on continue button and click on finish button
And Validate order is sucessful
Examples:
      | Username              | Password   |
      |standard_user          |secret_sauce|
      
      
Scenario: Verify checkout is not sucessful
Given User is on Login Page
When  User enters "<Username>" and "<Password>"
And  Click on Login button
And  User login sucessfully
And  click on any product Addtocart button
And  click on addtocart icon and check selected product is displayed
And  click on remove button and empty in your cart list
And  click on addtocart icon
And  click on checkout button
And  Enter firstname and lastname and zipcode details
And  click on continue button
Then Validate checkout is not sucessful
Examples:
      | Username              | Password   |
      |problem_user           |secret_sauce|