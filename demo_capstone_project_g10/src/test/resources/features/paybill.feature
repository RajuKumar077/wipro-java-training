Feature: Zero Bank Pay Bill

  Scenario Outline: Pay Bill is successfull
    Given user is on login page
    When user enters login credentials "<username>" and "<password>" and click sign-in
    And user clicks on online banking
    And user clicks on pay bill
    And user selects payee and select account and enters the "<amount>" to transfer then selects date
    Then user verifies the details and click pay
    Then user verifies that The payment was successfully submitted is displayed

    Examples:
      | username | password | amount |
      | username | password |   2342 |

  Scenario Outline: Pay Bill is Failure
    Given user is on login page
    When user enters login credentials "<username>" and "<password>" and click sign-in
    And user clicks on online banking
    And user clicks on pay bill
    And user selects payee and select account and enters the "<amount>" to transfer then selects date
    Then user verifies the details and click pay
    Then user verifies that please fill out this field is displayed

    Examples:
      | username | password | amount |
      | username | password |        |

  Scenario Outline: Add a New Payee Module with Valid Credentials
    Given user is on login page
    When user enters login credentials "<username>" and "<password>" and click sign-in
    And user clicks on online banking
    And user clicks on pay bill
    And user clicks on Add New Payee
    And user enters the "<payeename>" and "<payeeaddress>" and "<account>" and clicks add
    Then user verifies that The new payee "<payeename>" was successfully created is displayed

    Examples:
      | username | password | account | payeename | payeeaddress |
      | username | password |    2342 | raju      | bhore        |

  Scenario Outline: Add a New Payee Module is Failure
    Given user is on login page
    When user enters login credentials "<username>" and "<password>" and click sign-in
    And user clicks on online banking
    And user clicks on pay bill
    And user clicks on Add New Payee
    And user enters the "<payeename>" and "<payeeaddress>" and "<account>" and clicks add
    Then user verifies that please fill out this field is displayed

    Examples:
      | username | password | account | payeename | payeeaddress |
      | username | password |     234 | Aditya    |              |
