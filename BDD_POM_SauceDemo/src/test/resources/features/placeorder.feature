Feature: Placeorder

  Scenario Outline: Placing the Order Successfully
    Given user is on login page
    When user enters username "<UserName>" and password "<Password>" and click login button
    And user selects the product
    And user clicks add to cart button
    And user clicks cart button
    And user clicks checkout button
    And user enter user information "<FirstName>", "<LastName>", and "<PostalCode>" and click continue button
    Then user verifies product information and click Finish button
    Then user verifies checkout complete message
    Then user logout

    Examples: 
      | UserName      | Password     | FirstName | LastName | PostalCode |
      | standard_user | secret_sauce | Raju      | Kumar    |     841426 |
