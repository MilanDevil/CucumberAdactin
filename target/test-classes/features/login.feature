Feature: verifying the Adactin login details

  Scenario Outline: Verifying the login details with valid credentials
    Given User is on the Adactin page
    When User try to login "<username>" and "<password>"
    Then User should verify success messsage

    Examples: 
      | username | password |
      | Milton19 | L837GC   |
