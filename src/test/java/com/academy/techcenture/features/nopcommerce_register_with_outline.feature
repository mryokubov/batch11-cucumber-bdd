@regression
Feature: NopCommerce User Registration Feature with Scenario Outline
  Scenario Outline: NopCommerce Register New User with Scenario Outline
    Given user is on the homepage
    When user clicks on the login link
    Then user should be navigate to login page
    And user should be able to see register button and click it
    Then user should be navigate to register page
    And user clicks on gender as "<gender>"
    And user enters "<firstname>" for firstname
    And user enters "<lastname>" for lastname
    And user enters "<day>", "<month>", "<year>" for dob
    And user enters "<email>"
    And user enters "<company_name>" for company
    And user "<newsletter>" newsletter checkbox
    And user enters "<password>" for password input
    And user enters "<confirm_password>" for confirm password input
    When user clicks on register button
    Then user should see "<success_message>" success message
    When user clicks on continue button
    Then user is on the homepage
#    And user checks if they can log in with newly created credentials "<email>" and "<password>"

    Examples:
    |gender  | firstname | lastname | day | month | year | email                | company_name    | newsletter | password | confirm_password|   success_message           |
    | male   |   Kevin   |  Lee     |  12 | April | 1981 | kevin.lee20@gmail.com| Techcenture LLC |    checks  | Kev123!  |    Kev123!      | Your registration completed |
    | male   |   Kevin   |  Lee     |  12 | April | 1981 | bob.lee20@gmail.com| Techcenture LLC |    checks  | Kev123!  |    Kev123!      | Your registration completed |
    | female |   Linda   |  Lee     |  14 | May   | 1988 | mary.lee20@gmail.com| Techcenture LLC |    unchecks| Kev123!  |    Kev123!      | Your registration completed |


    @smoke
    Examples:
    |gender  | firstname | lastname | day | month | year | email                | company_name    | newsletter | password | confirm_password|   success_message           |
    | female |   Linda   |  Lee     |  14 | May   | 1988 | linda.lee20@gmail.com| Techcenture LLC |    unchecks| Kev123!  |    Kev123!      | Your registration completed |

