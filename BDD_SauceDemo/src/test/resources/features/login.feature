Feature: Login Functionality

  Scenario: Login is successful
    Given the user is on the login page
    When the user enters username as "standard_user" and password as "secret_sauce" and clicks the login button
    Then the user validates the product text

  Scenario: Login is failure
    Given the user is on login page
    When the user enters incorrect username and password
    Then the user validates the error message
