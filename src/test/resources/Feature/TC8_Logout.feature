Feature: Logout
  
  Scenario: User logs out successfully
Given I am on the Parabank login page
    When I enter valid username "mj" and password "Priya@123"
    And I click on the Login button
    Then Verify title after Login "ParaBank | Accounts Overview"
    When I click on the Logout button
    Then Verify title after Logout "ParaBank | Welcome | Online Banking"
    
