Feature: Zero Bank Account Statements

  Scenario Outline: Online Statements Download successfully
    Given user is on login page
    When user enters login credentials "<username>" and "<password>" and click sign-in
    And user clicks on online banking
    And user clicks on online statements
    And user selects the account type and selects the year
    And user clicks on statement link

    Examples: 
      | username | password |
      | username | password |
