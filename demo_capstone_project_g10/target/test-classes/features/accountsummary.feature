Feature: Zero Bank Account Summary

  Scenario Outline: Account Summary loaded successfully
    Given user is on login page
    When user enters login credentials "<username>" and "<password>" and click sign-in
    And user clicks on online banking
    And user clicks on account summary
    Then user validates account types

    Examples:
      | username | password |
      | username | password |
