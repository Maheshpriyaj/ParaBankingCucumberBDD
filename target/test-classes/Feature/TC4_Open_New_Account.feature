Feature: Open New Account
  
  Scenario: Open a new checking account
    Given I am on the Parabank login page
    When I enter valid username "mj" and password "Priya@123"
    And I click on the Login button
    And I navigate to the "<Pages>" page
    And I select "CHECKING" as the account type
    And I select value as the existing account to transfer funds from
    And I click on the Open New Account button
    Then I should see a confirmation message "Account Opened!" with the new account number
    
     Examples:
	    |Pages|
	    |Open New Account|
	   
