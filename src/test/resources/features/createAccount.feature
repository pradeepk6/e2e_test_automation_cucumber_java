@createaccount
Feature: Create online Account
  Create a new online account

  Background:
    Given I have navigated to join page

  Scenario: Create Account fails if mandatory fields are not filled
    When I do NOT fill in fields : email,firstName,lastName,password and submit
    Then I should see Required validation failure for all the mentioned fields

  Scenario Outline: Create Account fails as email format is wrong
    When I fill in <email> for email
    And goto to next field so as to trigger asynchromous validation of email field
    Then I should see invalid email error message
    """
    Not a valid email. Take a closer look.
    """
    Examples:
      | email          |
      | 123            |
      | 123gmail.com   |

  Scenario Outline: Asynchronous validation for Email already in use
    When I fill in <email> for email
    And goto to next field so as to trigger asynchromous validation of email field
    Then I should see email in use error message
    """
    Mendeley account found
    """
    Examples:
      | email       |
      | 123@123.com |

  Scenario Outline: Create Account fails as chosen password does not meet minimum requirements
    When I fill in <email> for email,<firstName> for firstName,<lastName> for lastName,<password> for password and submit
    Then I should see password validation error message
    """
    Password must be at least 7 character
    """
    Examples:
      | email             | firstName | lastName | password |
      | generate randomly |  firnam   | lasnam   |  123     |

  Scenario Outline: Create Account successfully finishes first step and progresses to next step
    When I fill in <email> for email,<firstName> for firstName,<lastName> for lastName,<password> for password and submit
    Then I should progress to next step and see a message addressing me with my firstName
    Examples:
      | email             | firstName | lastName | password     |
      | generate randomly |  firnam   | lasnam   |  1234567     |







