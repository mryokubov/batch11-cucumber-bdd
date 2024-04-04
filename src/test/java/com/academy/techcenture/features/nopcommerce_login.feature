Feature: NopCommerce Login Feature

  Background: NopCommerce User Login Common Steps
    Given user is on the homepage
    When user clicks on the login link
    Then user should be navigate to login page

  Scenario: NopCommerce User Login Positive Scenario
    When user uses login credentials "kevin.lee@gmail.com" and "Kevin123!" and clicks on login button
    Then user should be able to log in

  Scenario: NopCommerce User Login Negative Scenario
    When user uses login credentials "kevin.lee@gmail.com" and "Kevin888!" and clicks on login button
    Then user should see error "Login was unsuccessful. Please correct the errors and try again. The credentials provided are incorrect"