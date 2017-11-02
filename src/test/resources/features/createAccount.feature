
Feature: Create online Account
  Create a new online account

  Background:
    Given I am on join page

  @createaccount
  Scenario Outline: Create Account fails if mandatory fields are not filled

    When I do NOT fill in anything <email> for email,<firstName> for firstName,<lastName> for lastName,<password> for password and submit
    Then I should see Required validation failure
    Examples:
      | email | firstName | lastName | password |
      |       |           |          |          |

  @ignore
  Scenario Outline: Create Account fails as email format is wrong
    When I fill in <email> for email,<firstName> for firstName,<lastName> for lastName,<password> for password and submit
    Then I should see error message
    """
    Not a valid email. Take a closer look.
    """
    Examples:
      | email | firstName | lastName | password |
      | 123   |  firnam   | lasnam   |  1234567 |

  @ignore
  Scenario Outline: Create Account fails as an account already exists with the email
    When I fill in <email> for email,<firstName> for firstName,<lastName> for lastName,<password> for password and submit
    Then I should see error message
    """
    Mendeley account found
    """
    Examples:
      | email       | firstName | lastName | password |
      | 123@123.com |  firnam   | lasnam   |  1234567 |

  @ignore
  Scenario Outline: Create Account fails as chosen password does not meet minimum requirements
    When I fill in randomly generated email <email> for email,<firstName> for firstName,<lastName> for lastName,<password> for password and submit
    Then I should see error message
    """
    Password must be at least 7 character
    """
    Examples:
      | email             | firstName | lastName | password |
      | generate randomly |  firnam   | lasnam   |  123     |

  @ignore
  Scenario Outline: Create Account successfully finishes first step and progresses to next step
    When I fill in randomly generated email <email> for email,<firstName> for firstName,<lastName> for lastName,<password> for password and submit
    Then I should progress to next step and see a message addressing me with my firstName
    Examples:
      | email             | firstName | lastName | password     |
      | generate randomly |  firnam   | lasnam   |  1234567     |







