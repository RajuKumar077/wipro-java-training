Feature: Login

  Scenario Outline: Login is successful
    Given the user is on login page
    When the user enters "<username>" and "<password>" and login button
    Then the user validates products text
    Then the user logsout

    Examples: 
      | username      | password     |
      | standard_user | secret_sauce |
      | visual_user   | secret_sauce |