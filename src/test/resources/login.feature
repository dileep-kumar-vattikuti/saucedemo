Feature: Login
Scenario: Validate login functionality using different user inputs
Given User is on Login Page
When User enters "<Username>" and "<Password>"
And Click on Login button
Then User login sucessfully
Examples:
      | Username              | Password   |
      |standard_user          |secret_sauce|
      |performance_glitch_user|secret_sauce|
      |problem_user           |secret_sauce|
      

Scenario: Validate login functionality using invalid inputs
Given User is on Login Page
When User enters  "<Username>" and "<Password>"
And Click on Login button
Then User should not login successful
     
Examples:
      | Username              | Password |
      | standard_user          |dileep   |      