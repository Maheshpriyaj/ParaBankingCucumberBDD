Feature: Account Overview
 
  Scenario: View account overview
    Given I am on the Parabank login page
    When I enter valid username "mj" and password "Priya@123"
    And I click on the Login button
    And I navigate to the "<Pages>"page
    Then I should see a list of accounts with balances and available funds
    
     Examples:
	    |Pages|
	    |Accounts Overview|
	   
