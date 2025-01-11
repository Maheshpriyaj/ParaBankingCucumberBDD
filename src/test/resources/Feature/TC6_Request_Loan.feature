Feature: Request Loan
  
  Scenario: Apply for a loan
    Given I am on the Parabank login page
    When I enter valid username "mj" and password "Priya@123"
    And I click on the Login button
    When I navigate to the "<Pages>"page
    And I enter "10000" as the loan amount
    And I enter "500" as the down payment
    And I select "14121" as the account to transfer funds from
    And I click on the Apply Now button
    Then I should see a confirmation message for request loan "Congratulations, your loan has been approved."
    
    Examples:
	    |Pages|
	    |Request Loan|
    
