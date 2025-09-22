Feature: Zero Bank Login

  Scenario Outline: Login is successful
    Given user is on login page
    When user enters login credentials "<username>" and "<password>" and click sign-in button
    Then user verifies that the user is redirected to the account summary page

    Examples:
      | username | password |
      | username | password |

  Scenario Outline: Login is Failure due to invalid credentials
    Given user is on login page
    When user enters login credentials "<username>" and "<password>" and click sign-in button
    Then user validates that error message Login and/or password are wrong is displayed

    Examples:
      | username  | password  |
      | username1 | password1 |

  Scenario: Login is Failure due to empty username and password
    Given user is on login page
    When user click sign-in button
    Then user validates that error message Login and/or password are wrong is displayed
