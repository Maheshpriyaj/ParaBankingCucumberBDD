Feature: User Login
  
  Scenario: Login with valid credentials
    Given I am on the Parabank login page
    When I enter valid username "mj" and password "Priya@123"
    And I click on the Login button
    Then I should see the homepage with a "Welcome" message
    
  
  Scenario: Login with invalid credentials
    Given I am on the Parabank login page
    When I enter invalid username "invalidUser" and password "wrongPass"
    And I click on the Login button
    Then I should see an error message "An internal error has occurred and has been logged."

  
  Scenario: Login without credentials
    Given I am on the Parabank login page
    When I click on the Login button without entering username or password
    Then I should see an error message "Please enter a username and password."

  