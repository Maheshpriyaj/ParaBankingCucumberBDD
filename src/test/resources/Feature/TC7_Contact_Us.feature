Feature: Contact Us
  
  Scenario: Submit a contact form
    Given I am on the Contact Us page
    When I fill in the contact form with the following details:
      | Name        | John Doe            |
      | Email       | john.doe@example.com |
      | Phone       | 1234567890          |
      | Message     | Need assistance     |
    And I click on the Send Message button
    Then I should see a confirmation message for contact us "A Customer Care Representative will be contacting you."
