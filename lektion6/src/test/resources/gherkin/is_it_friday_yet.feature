Feature: Is it Friday yet?
  Everybody wants to know when it's Friday

  Scenario: Sunday isn't Friday
    Given today is "Sunday"
    When I ask whether it's Friday yet
    Then I should be told "Nope"

  Scenario: Monday isn't Friday
    Given today is "Monday"
    When I ask whether it's Friday yet
    Then I should be told "Nope"

  Scenario: Thursday is almost Friday
    Given today is "Thursday"
    When I ask whether it's Friday yet
    Then I should be told "Soon"

  Scenario: Friday is Friday
    Given today is "Friday"
    When I ask whether it's Friday yet
    Then I should be told "TGIF"

  Scenario: Test stuff
    Given tomorrow is "Sunday"
    And the weather is high
    When I ask whether it's Sunday tomorrow
    Then I should be told to shut up
