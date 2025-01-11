	Feature: Transfer Funds
	  
	  Scenario: Transfer funds between accounts
	    Given I am on the Parabank login page
	    When I enter valid username "mj" and password "Priya@123"
	    And I click on the Login button
	    And I navigate to the "<Pages>"page
	    And I enter "500" as the transfer amount
	    And I select value as the from account
	    And I select value as the to account
	    And I click on the Transfer button
	    Then I should see a confirmation message "Transfer Complete!"
	    
	    
	    Examples:
	    |Pages         |
	    |Transfer Funds|
	    
	    
