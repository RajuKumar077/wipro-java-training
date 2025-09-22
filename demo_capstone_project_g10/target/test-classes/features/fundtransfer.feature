Feature: Zero Bank Fund Transfer

  Scenario Outline: Fund Transfered successfully
    Given user is on login page
    When user enters login credentials "<username>" and "<password>" and click sign-in
    And user clicks on online banking
    And user clicks on transfer fund
    And selects from-account and to-account and enters the "<amount>" to transfer then clicks continue
    Then user verifies the details and click submit
    Then user verifies that You successfully submitted your transaction is displayed

    Examples:
      | username | password | amount |
      | username | password |  200 |

  Scenario Outline: Fund Transfered failure
    Given user is on login page
    When user enters login credentials "<username>" and "<password>" and click sign-in
    And user clicks on online banking
    And user clicks on transfer fund
    And selects from-account and to-account and enters the "<amount>" to transfer then clicks continue
    Then user verifies that please fill out this field is displayed


    Examples:
      | username | password | amount |
      | username | password |        |
