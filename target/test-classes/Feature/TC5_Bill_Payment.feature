Feature: Bill Payment
   
  Scenario: Pay a bill
    Given I am on the Parabank login page
    When I enter valid username "mj" and password "Priya@123"
    And I click on the Login button
    When I navigate to the "<Pages>"page
    And I enter the payee name "Electric Company"
    And I enter the address "123 Main St"
    And I enter the city "Vellakovil"
    And I enter the State "TN"
    And I enter the ZipCode "638208"
    And I enter the Phone "98564"
    And I enter the Account "123456"
    And I enter the Verify Account "123456"
    And I enter the Amount "200"  
    And I click on the Send Payment button
    Then I should see a confirmation message for bill payment "Bill Payment Complete"
Examples:
	    |Pages|
	    |Bill Pay|
	   